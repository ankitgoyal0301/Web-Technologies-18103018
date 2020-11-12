<script>

function triangle(n,max){
	for (var i = 0; i < n; i++)
	{
		for (var j = 0; j < max-i-1; j++)
		{
			document.write("&nbsp;&nbsp;");
		}

		for (var j = 0; j < i*2+1; j++)
		{
        	if(n==1){ 
            	document.write("X");
            }
            else{
            	document.write("0");
            }
		}

		document.write("<br>");
	}
}

function christmasTree(n){
	for (var i = 0; i < n; i++)
    {
    	triangle( i+1 , n );
    }
}

function base(n,h){
	var len = 2*n -1;
    var start = (len/2) -1
    
    for(var i=0;i<h;++i){
    
    	for (var j = 0; j < start-1; j++)
    	{
        	document.write("&nbsp;&nbsp;");
    	}

		for (var j = 0; j < 3; j++){
			document.write("0");
		}
    	document.write("<br>");
    }
}
var tree = 6
var height = 6
christmasTree(tree);
base(tree,height);
</script>
