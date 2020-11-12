<script>
function balanceParenthesis(s){
	var string = s;
    var stack = []
    var balanced = true;
    
    for(var i=0;i<string.length;++i){
    	if(string[i]==='(' || string[i]==='[' || string[i]==='{'){
        	stack.push(string[i]);
        }
        else if(string[i]==')')
        {
        	if(stack.length===0 || stack[stack.length-1] !== '('){
            	balanced = false;
                break;
            }
            stack.pop();
        }
        else if(string[i]==']')
        {
        	if(stack.length===0 || stack[stack.length-1] !== '['){
            	balanced = false;
                break;
            }
            stack.pop();
        }
        else if(string[i]=='}')
        {
        	if(stack.length===0 || stack[stack.length-1] !== '{'){
            	balanced = false;
                break;
            }
            stack.pop();
        }
    }
    if(balanced === false || stack.length!==0){
    	document.write("Brackets are not Balanced");
    	console.log("Brackets are not Balanced\n");
        return false;
    }
    else{
    	document.write("Brackets are Balanced");
    	console.log("Brackets are Balanced\n");
        return true;
    }
}
var s = prompt("Please enter the input string");
var ans = balanceParenthesis(s);
document.write("<br>");
document.write(ans);
console.log(ans);

   
</script>
