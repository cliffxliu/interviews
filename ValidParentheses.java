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