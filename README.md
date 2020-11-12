# 18103018

### Name: Ankit Goyal
### SID: 18103018
---
Web Technologies Assignments:
- **Assignment 1:**

![Assignment 1](https://github.com/ankitgoyal0301/18103018/blob/master/Lab%20Assignment%201/Assignment.PNG)

- **Assignment 2:**

1. Write a java program to compare two strings lexicographically (without using library function).  
2. Write a program to implement counting sort (with input in the range 0 to 20 and input can be repeated multiple times)  
3. Write a program to sort strings (without using library function).  
4. Find the smallest n such that Σi = i2 where 1 ≤ i ≤ n is too large to be represented as an int.  
5. Let us define a couple of sets of integers, and let Java compute the set-theoretical operations (union, intersection and complement). We first fix our universe, which will consist of the 11 elements, Universe = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, A and B will be entered by users.  
a. Only array can be used as data structure  
b. Using any efficient data-structure available in Java  
c. Compare the time to compute the operations  
6. Write a ConsoleProgram that reads in a number from the user and then displays the Hailstone sequence for that number (Pick some positive integer and call it n. If n is even, divide it by two. If n is odd, multiply it by three and add one. Continue this process until n is equal to one

- **Assignment 3:**

A) To implement a program (Web scrapper) in Java that take as input any URL say http://pec.ac.in and do following things. 
1. It sends the request (http request) for the URL supplied. 
2. Get the page and extract all the text and html tags present in the page. 
3. Extracted text along with tags should be sent to an Excel file like <p> || welcome to pec (both in separate columns). 
4. Paste the extracted anchor tags i.e. </a> and the URLs in a separate file along-with the text so this excel with have two columns <text in anchor> <corresponding URL>. 

B) You can use String/ StringBuffer/ String Builder class function to perform the above operations 

C) Try to change the crawler developed above to Focused Web crawler. By crawling only those webpages that have information regarding any faculty of that institute.  

D) Devise a method to handle downloadable data present in the website like PDF, word links etc. 

- **Assignment 4:**

1. A farmer wants to reorganize the crops growing in his farm. The farm is in the form of an N X M grid with each cell in the grid being a square plot. Each plot has to be planted with a variety of crop. The farmer has 26 varieties of crops that he can plant. The plant varieties are represented by lowercase English alphabets. He wants to follow the following condition while planting: In each row, there must be at least 2 different varieties of crops (any number of crops can be used in a column)No two nearby (Top, bottom, left, right) plots can have the same variety of crops. Given the current state of the farm, find the minimum number of plots that have to replant with a different crop so that the above conditions are satisfied. Input The first line contains two integers N and M, the dimensions of the farm. The next N lines contain M lowercase characters from‘a’ to ‘z’ representing the crop variety at that plot. Output a single integer denoting the minimum number of plots that have to be replanted in order to satisfy the conditions imposed.
Example#1 Input 4 4 acaa dddd bbbb ccce Output 6 Explanation: In this Example, We may replant the farm to look like: acac dede baba cece This arrangement of crop varieties satisfies the given conditions and the cost of this replacement is 6.

2. The prgram starts with the int value -1, then casts the int to a byte, then to a char, and finally back to an int. The first cast nar- rows the value from 32 bits down to 8, the second widens it from 8 bits to 16, and the final cast widens it from 16 bits back to 32. Does the value end up back where it started? If you ran the program, you found that it does not.

- **Assignment 5:**

1. Write a program to create a simple counting thread. It will count to 100, pausing one second between each number. Also, in keeping with counting theme, it will output a string every ten number.

2. Write a program that uses multiple threads to find the integer in the range 1 to 10000 that has the largest number of divisors but for the range 1 to 100000 (or less, if you don't have a fast computer).At the end of the program, output the elapsed.

3. You're working with an intern that keeps coming to you with JavaScript code that won't run because the braces, brackets, and parentheses are off. To save you both some time, you decide to write a braces/brackets/parentheses validator. Write an efficient function that tells us whether or not an input string's openers and closers are properly nested.
Examples:
"{ [ ] ( ) }" should return true
"{ [ ( ] ) }" should return false
"{ [ }" should return false

4. Write a JavaScript program to generate the Christmas Tree pattern below. The tree should be composed of zeroes (0), and it must be topped with an asterisk (*).
