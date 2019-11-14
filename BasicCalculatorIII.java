/*
772. Basic Calculator III (Hard)
Implement a basic calculator to evaluate a simple expression string.

The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces .

The expression string contains only non-negative integers, +, -, *, / operators , open ( and closing parentheses ) and empty spaces . The integer division should truncate toward zero.

You may assume that the given expression is always valid. All intermediate results will be in the range of [-2147483648, 2147483647].

Some examples:

"1 + 1" = 2
" 6-4 / 2 " = 4
"2*(5+5*2)/3+(6/2+8)" = 21
"(2+6* 3+5- (3*14/7+2)*5)+3"=-12
 

Note: Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //Remove all white spaces
        s = s.replaceAll("\\s+", "");
        
        //Use stack so most recent number is at the top
        Stack<Integer> stack = new Stack<>();
        
        //Start with + since we always want to add first number to res
        char sign = '+';
        
        //Iterate through characters in String
        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);
            if (c == '(') {
                // Find a block between '(' and ')', call function recursively on it
                int l = 1;
                int r = i + 1;
                
                //Changing position of r
                while (r < s.length() && l > 0) {
                    if (s.charAt(r) == '(') {
                        l++;
                    }
                    else if (s.charAt(r) == ')') {
                        l--;
                    } 
                    r++;
                }
                
                int blockValue = calculate(s.substring(i + 1, r - 1));
                i = r; //Reset value of i
                if (sign == '+') {
                    stack.push(blockValue);
                } else if (sign == '-') {
                    stack.push(-blockValue);
                } else if (sign == '*') {
                    stack.push(stack.pop() * blockValue);
                } else if (sign == '/') {
                    stack.push(stack.pop() / blockValue);
                }
            } else if (Character.isDigit(c)) { //Continue calculation (rest is same as Basic Calculator I and II)
                int j = i;
                int num = 0;
                
                //Generate multiple digit number
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    num = 10 * num + (s.charAt(j) - '0');
                    j++;
                }
                i = j;
                if (sign == '+') {
                    stack.push(num);
                } else if (sign == '-') {
                    stack.push(-num);
                } else if (sign == '*') {
                    stack.push(stack.pop() * num);
                } else if (sign == '/') {
                    stack.push(stack.pop() / num);
                }
            } else {
                sign = c; //character is just another sign, set sign to c
                i++;
            }
        }
        
        //Calculate final value
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}