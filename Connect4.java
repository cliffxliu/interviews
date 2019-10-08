/*
Implement a function that takes a Connect Four board string and decodes it into 
a representative 2D array. 

Example:
For an input string of "9_r4_brbrbr_3b2rb_b2r2br_r2b3rb", the output would look like:
_ _ _ _ _ _ _ 
_ _ r _ _ _ _ 
b r b r b r _ 
b b b r r b _ 
b r r b b r _ 
r b b r r r b 

Example:
For an input string of "42_", the output would look like:
_ _ _ _ _ _ _ 
_ _ _ _ _ _ _ 
_ _ _ _ _ _ _ 
_ _ _ _ _ _ _ 
_ _ _ _ _ _ _ 
_ _ _ _ _ _ _ 
*/
class Solution {
    /*
    Parse through the string once. 
    */
    public static char[][] c4(String input) {
        char[][] res = new char[6][7];
        int row = 0;
        int col = 0;
        int curr = 0;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                curr = curr * 10 + Character.getNumericValue(input.charAt(i)); //If more than one digit
            }
            else {
                char character = input.charAt(i);
                if(curr > 0) {
                    for(int j = 0; j < curr; j++) {
                        res[row][col] = character;
                        col++;
                        if (col > 6) { //Wrap it around to the next row
                            col = col % 7;
                            row ++;
                        }
                    }
                }
                else {
                    res[row][col] = character;
                    col++;
                    if (col > 6) {
                        col = col % 7;
                        row ++;
                    }
                }
                curr = 0;
            }
        }
        return res;
    }
}

/*
Complexity:
Time: O(N). One pass through the input string.
Space: O(1). Constant space for the result array since we know it's 6 x 7.
*/
*/