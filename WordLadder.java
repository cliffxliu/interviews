/*
127. Word Ladder (Medium)
Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
You may assume no duplicates in the word list.
You may assume beginWord and endWord are non-empty and are not the same.

Example 1:

Input:
beginWord = "hit",
endWord = "cog",
wordList = ["hot","dot","dog","lot","log","cog"]

Output: 5

Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.


Example 2:

Input:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]

Output: 0

Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
*/

class Solution {
    //BFS: start from the beginWord, then visit its neighbors, then the non-visited neighbors of its neighbors until we arrive at the endWord
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList); //Store all the words we've visited
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        int count = 1; //res
        while (!queue.isEmpty()) {
            int size = queue.size();
            //For all words this round
            for (int i = 0; i < size; i++) {
                char[] current = queue.poll().toCharArray();
                //Traverse the current word
                for (int j = 0; j < current.length; j++) {
                    char temp = current[j];
                    //Change one letter at a time
                    for (char c = 'a'; c <= 'z'; c++) {
                        current[j] = c;
                        String currentString = new String(current);
                        
                        //If the set already contains the word, and it's equal to endWord, we have changed it to endWord
                        if (set.contains(currentString)) {
                            if (currentString.equals(endWord)) {
                                return count + 1;
                            }
                        
                            //Add children to queue
                            queue.add(currentString);
                            set.remove(currentString);
                        }
                    }
                    //Undo change of letter
                    current[j] = temp;
                }
            }
            count++;
        }
    
        return 0; 
    }
}