import java.io.*;
import java.util.*;
import java.lang.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class howManyDucks {
  
  /*
   *    Count how many ducks are there in the pond
   * .  QUACK - means 1 duck
   * .  QUACKQUACK . means 1 duck
   * .  QUQUACKACK   means 2 ducks
   * .  QUACKQUUACKACK - means 2 ducks
   */
  
  public int howManyDucks(String str) {
    if (str.length() < 5) {
      return 0;
    }
    Map<Character, Integer> map = new HashMap<>();
    int res = 0;
    int curr = 0;
    for (int i = 0; i < str.length(); i++) {
      map.put(str.charAt(i), "QUACK".indexOf(str.charAt(i)));
    }
    for (char c: str.toCharArray()) {
      if (map.get(c) == 0) {
        curr++;
      }
      if (map.get(c) == 4) {
        curr--;
      }
      res = Math.max(res, curr);
    }
    return res;
  }
  
  public void validate(int expected, String str) {
    int received = howManyDucks(str);
    if (expected != received) {
      System.out.println ("Expected " + expected + " Got " + received + " are number of ducks in " + str);
    } else {
      System.out.println ("Success " + expected + " Got " + received + " are number of ducks in " + str);
    }
  }

  public static void main(String[] args) {
    
    Solution sol = new Solution();
    sol.validate (0, "");
    sol.validate (0, "QA");
    sol.validate (1, "QUACK");
    sol.validate (1, "QUACKQUACK");
    sol.validate (2, "QUAQUCKACK");
    sol.validate (3, "QUAQUQUCKAACCKK");
    sol.validate (3, "QUAQUQUCKAACCKKQUACK");
    sol.validate (2, "QQUUAACCKKQUACKQUACK");

  }
}