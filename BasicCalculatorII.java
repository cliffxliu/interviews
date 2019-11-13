/*
227. Basic Calculator II (Medium)
Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

Example 1:
Input: "3+2*2"
Output: 7

Example 2:

Input: " 3/2 "
Output: 1

Example 3:
Input: " 3+5 / 2 "
Output: 5

Note:
You may assume that the given expression is always valid.
Do not use the eval built-in library function.
*/

class Solution {
    public int calculate(String s) {
        if (s.length() == 0) {
            return 0;
        }
        //Use stack so most recent operation/number is at the top
        Stack<Integer> stack = new Stack<>();
        
        //Number to manipulate and push into stack
        int currNum = 0;
        
        //Start with + because we want to add first number to our res regardless
        char currOp = '+';
        s += '+';
        
        //Iterate through characters in String
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = currNum * 10 + currChar - '0'; //Multiple digit numbers
                continue;
            }
            if (currChar == ' ') {
                continue;
            }

            //Push intermediate results (to be summed later) into stack
            if (currOp == '+') {
                stack.push(currNum);
            } else if (currOp == '-') {
                stack.push(currNum * -1);
            } else if (currOp == '*') { //ONLY pop and calculate if mul/div
                stack.push(stack.pop() * currNum);
            } else if (currOp == '/') {
                stack.push(stack.pop() / currNum);
            }
            currOp = currChar; //Reset currOp to become currChar
            currNum = 0; //Reset number
        }
        
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
        
    }
}