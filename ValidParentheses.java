/*
20. Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.

Example 1:
Input: "()"
Output: true

Example 2:
Input: "()[]{}"
Output: true

Example 3:
Input: "(]"
Output: false

Example 4:
Input: "([)]"
Output: false

Example 5:
Input: "{[]}"
Output: true
*/


/* Intuition: Use a FILO a stack and modify the stack in the following way:
1. If the next character is a left bracket, we add it to the stack.
2. If the next character is a right bracket, we check if it's a pair and if the stack isn't empty either, we remove the left parentheses.
3. Otherwise, if the stack is empty or it's not a pair, we can just exit out and return false.
At the end, if the stack is empty, then we are done and have valid parentheses. 

*/
class Solution {
    public boolean isValid(String input) {
        Stack<Character> stack = new Stack<>();
        for (char ch: input.toCharArray()) {
            if (ch == '[' || ch == '(' || ch == '{') {
                stack.push(ch);
            }
            else if (!stack.isEmpty() && isPairParentheses(stack.peek(), ch)){
                stack.pop();
            }
            else {
                return false;
            }
                    
        }
        return stack.isEmpty();
    }
    
    public boolean isPairParentheses(char left, char right) {
        return left == '[' && right == ']' || 
            left == '(' && right == ')' || 
            left == '{' && right == '}';
    }   
}

/*
Complexity analysis:
Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1)O(1) time.
Space complexity : O(n) as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
*/