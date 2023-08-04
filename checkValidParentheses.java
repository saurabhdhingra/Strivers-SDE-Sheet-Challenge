import java.util.Stack;

public class checkValidParentheses {
    
}

class Solution {
    public boolean isValid(String s) {
       boolean ans = true;
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i<s.length();i++){
            if(s.charAt(i)=='('){
                stack.push('(');
            }
            else if(s.charAt(i)=='['){
                stack.push('[');
            }
            else if(s.charAt(i)=='{'){
                stack.push('{');
            }
            
            else if( !stack.empty() && s.charAt(i) != '(' || s.charAt(i)=='[' || s.charAt(i)=='{'){
                if(s.charAt(i)==')'){if(stack.peek() == '(' ){
                   stack.pop();
               }else{
                   ans = false;
                   break;
               }
               }else if(s.charAt(i)==']'){
                if(stack.peek() == '[' ){
                   stack.pop();
               }else{
                   ans = false;
                   break;
               }
                 
            }else if(s.charAt(i)=='}'){
               if(stack.peek() == '{' ){
                   stack.pop();
               }else{
                   ans = false;
                   break;
               }
                 
            }
               
            }
           
            
            
            
        }
        
        return ans || stack.empty();
    }
}