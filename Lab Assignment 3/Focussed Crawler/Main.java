package com.company;
import java.lang.annotation.Documented;
import java.util.*;
import java.lang.Math;
import java.io.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException;
import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.file.*;

public class Main {

    // Initialising Page count to 0
    public static int pageCount = 0;
    final static String baseURL = "https://pec.ac.in";
    static int fileNumber = 0;

    public static String fullLinkFinder(String url){
        ArrayList<String> validURL = new ArrayList<String>();
        validURL.add("https://alumni.pec.ac.in");
        validURL.add("https://pec.ac.in");
        validURL.add("http://pec.ac.in");
        validURL.add("https://www.pec.ac.in");
        validURL.add("http://www.pec.ac.in");

        if(url.startsWith(validURL.get(0)) || url.startsWith(validURL.get(1)) || url.startsWith(validURL.get(2)) || url.startsWith(validURL.get(3)) || url.startsWith(validURL.get(4))){
            return url;
        }
        if(url.startsWith("#")){
            return "https://pec.ac.in/";
        }
        // Sub-domain of pec.ac.in/ankit/goyal.....and so on
        if(url.startsWith("/")){
            return baseURL + url;
        }
        // URL of any other domain
        return url;

    }

    public static boolean isValid(String url){

        ArrayList<String> validURL = new ArrayList<String>();
        validURL.add("https://alumni.pec.ac.in");
        validURL.add("https://pec.ac.in");
        validURL.add("http://pec.ac.in");
        validURL.add("https://www.pec.ac.in");
        validURL.add("http://www.pec.ac.in");

        if(url.startsWith(validURL.get(0)) || url.startsWith(validURL.get(1)) || url.startsWith(validURL.get(2)) || url.startsWith(validURL.get(3)) || url.startsWith(validURL.get(4))){
            return true;
        }
        return false;
    }

    public static void traverse(int index, ArrayList<String> urlList, ArrayList<String> extraUrl, ArrayList<String> finalResultUrl, ArrayList<String> finalResultPara, ArrayList<String> finalResultURLtext, ArrayList<String> finalResultH1, ArrayList<String> finalResultH2, ArrayList<String> finalResultH3, ArrayList<String> finalResultH4, Set<String> visitedUrls, int depth){

        if(depth == 5) return;

        for(int i=0;i<urlList.size();++i){

            String url = urlList.get(i);

            try{
                // Using string and not StringBuffer because Jsoup.connect requires string input and gives out string as output
                final Document document = Jsoup.connect(url).get();
                Elements links = document.getElementsByTag("a");
                Elements paras = document.getElementsByTag("p");
                Elements h1 = document.getElementsByTag("h1");
                Elements h2 = document.getElementsByTag("h2");
                Elements h3 = document.getElementsByTag("h3");
                Elements h4 = document.getElementsByTag("h4");

                String paragraph = new String();
                for(Element para:paras){
                    String paraText = para.text();
                    if(paraText.length()!=0){

                        if(paragraph.length()!=0){
                            paragraph += " | ";
                        }
                        paragraph += paraText;
                    }
                }
                String linkPara = new String();
                for(Element link:links){
                    String linkText = link.text();
                    if(linkText.length()!=0){
                        if(linkPara.length()!=0){
                            linkPara += " | ";
                        }
                        linkPara += linkText;

                    }
                }
                String h1Para = new String();
                for(Element h:h1){
                    String linkText = h.text();
                    if(linkText.length()!=0){
                        if(h1Para.length()!=0){
                            h1Para += " | ";
                        }
                        h1Para += linkText;

                    }
                }
                String h2Para = new String();
                for(Element h:h2){
                    String linkText = h.text();
                    if(linkText.length()!=0){
                        if(h2Para.length()!=0){
                            h2Para += " | ";
                        }
                        h2Para += linkText;
                    }
                }
                String h3Para = new String();
                for(Element h:h3){
                    String linkText = h.text();
                    if(linkText.length()!=0){
                        if(h3Para.length()!=0){
                            h3Para += " | ";
                        }
                        h3Para += linkText;
                    }
                }
                String h4Para = new String();
                for(Element h:h4){
                    String linkText = h.text();
                    if(linkText.length()!=0){
                        if(h4Para.length()!=0){
                            h4Para += " | ";
                        }
                        h4Para += linkText;
                    }
                }
                if(url.contains("faculty") || url.contains("Faculty") || url.contains("FACULTY") || paragraph.contains("faculty") || paragraph.contains("Faculty") || paragraph.contains("FACULTY")) {
                    finalResultUrl.add(url);
                    finalResultPara.add(paragraph);
                    finalResultURLtext.add(linkPara);
                    finalResultH1.add(h1Para);
                    finalResultH2.add(h2Para);
                    finalResultH3.add(h3Para);
                    finalResultH4.add(h4Para);
                    pageCount++;
                    System.out.println("Page number: "+ pageCount + " scraped.");
                }

                ArrayList<String> urlListNext = new ArrayList<String>();

                for(Element link:links){
                    String linkHref = link.attr("href");

                    // Garbage Links
                    if(linkHref.equals("") || linkHref.endsWith("javascript:;") || linkHref.startsWith("https://pec.ac.in/~pecac") || linkHref.endsWith("annexure-III")){
                        continue;
                    }
                    // Files
                    if(linkHref.contains(".pdf") || linkHref.contains(".PDF") || linkHref.contains(".xlsx") || linkHref.contains(".XLSX") || linkHref.contains(".docx") || linkHref.contains(".DOCX") ||linkHref.contains(".doc") || linkHref.contains(".DOC") ||linkHref.contains(".jpg") || linkHref.contains(".jpeg") || linkHref.contains(".png") || linkHref.contains(".svg") || linkHref.contains(".JPG") || linkHref.contains(".JPEG") || linkHref.contains(".PNG") || linkHref.contains(".SVG") ){
                        continue;
                    }

                    // Preprocess links here
                    linkHref = fullLinkFinder(linkHref);

                    // to check whether to traverse this link or not
                    boolean checkLink = isValid(linkHref);

                    if(checkLink == false){
                        if(visitedUrls.contains(linkHref)){
                            continue;
                        }
                        else{
                            visitedUrls.add(linkHref);
                            extraUrl.add(linkHref);
                        }

                        continue;
                    }

                    if(visitedUrls.contains(linkHref)){
                        continue;
                    }
                    else{
                        visitedUrls.add(linkHref);
                        urlListNext.add(linkHref);
                    }
                    // StringBuffer linkText = new StringBuffer(link.text());
                }

                // urlList contains the next level children
                traverse(index,urlListNext, extraUrl,finalResultUrl,finalResultPara, finalResultURLtext, finalResultH1, finalResultH2, finalResultH3, finalResultH4, visitedUrls, depth+1);

            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

    }

    public static void main(String[] args) throws IOException {

        // URLs to traverse i.e. of pec.ac.in domain
        ArrayList<String> urlList = new ArrayList<String>();

        // URL not to traverse eg. youtube.com, facebook.com, eakadmik portal link, etc.
        ArrayList<String> extraUrl = new ArrayList<String>();

        final String url = "https://www.pec.ac.in/";
        urlList.add(url);

        // Storing final results
        ArrayList<String> finalResultUrl = new ArrayList<String>();
        ArrayList<String> finalResultPara = new ArrayList<String>();
        ArrayList<String> finalResultURLtext = new ArrayList<String>();
        ArrayList<String> finalResultH1 = new ArrayList<String>();
        ArrayList<String> finalResultH2 = new ArrayList<String>();
        ArrayList<String> finalResultH3 = new ArrayList<String>();
        ArrayList<String> finalResultH4 = new ArrayList<String>();

        // set to keep track of visited URLs
        Set<String> visitedUrls = new HashSet<String>();
        visitedUrls.add(url);

        int index = 0, depth = 0;
        traverse(index,urlList, extraUrl,finalResultUrl,finalResultPara, finalResultURLtext, finalResultH1, finalResultH2, finalResultH3, finalResultH4,visitedUrls, depth);

        // Writing to CSV
        File file = new File("D:\\Data.csv");
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        bw.write("Links, Link Text, Paragraph Content <p>, Heading H1, Heading H2, Heading H3, Heading H4");
        bw.newLine();
        for(int i=0;i<finalResultUrl.size();i++)
        {
            String paragraph = finalResultPara.get(i).replace(",","");
            String linkText = finalResultURLtext.get(i).replace(",","");
            String h1 = finalResultH1.get(i).replace(",","");
            String h2 = finalResultH2.get(i).replace(",","");
            String h3 = finalResultH3.get(i).replace(",","");
            String h4 = finalResultH4.get(i).replace(",","");
            bw.write(finalResultUrl.get(i)+","+linkText+","+paragraph+","+h1+","+h2+","+h3+","+h4);
            bw.newLine();
        }
        bw.close();
        fw.close();

        System.out.println("CSV File written!");
    }
}
