import java.io.*;
import java.util.*;


class Solution {
  

  static class QuestionMyHashMap {
         ListNode[] nodes;
         int size;
        public QuestionMyHashMap(int capacity){
          nodes = new ListNode[capacity];
          size = capacity;
        }

        public void put(String key, String value){
          int i = idx(key);
          // System.out.println(key + " " + value + " " + i);
          if(nodes[i] == null)
            nodes[i] = new ListNode("-1","-1");
          // System.out.println("nodes[i]: " + nodes[i].val);
          ListNode prev = find(nodes[i],key);
          
          if(prev.next == null)
            prev.next = new ListNode(key, value);
          else 
            prev.next.val = value;
          // System.out.println("prev.next.val " + prev.next.val);
        }

        public String get(String key){
          int i = idx(key);
          // System.out.println("get operations: " + key + " " + i + " nodes[i]: " + nodes[i].val);
          if(nodes[i] == null)             
          return null;
          ListNode node = find(nodes[i],key);
          // System.out.println("node.next.val " + node.next.val);
          return node.next == null?null:node.next.val;
  
        }
    
        public int idx(String key) {
          String k = key;
          return k.hashCode()%size;
        }
    
        public ListNode find(ListNode bucket, String key){
          ListNode node = bucket, prev = null;
          while(node != null && !node.key.equals(key)){
            prev = node;
            node = node.next;
          }
          return prev;
        }
                   
  }
  
 

  public static void main(String[] args) {
      QuestionMyHashMap q = new QuestionMyHashMap(10);
    
      for (int i = 0; i < 100; i++){
        q.put(Integer.toString(i), Integer.toString(i) + "ZZZ");
        
      }
      
      
      for (int i = 0; i < 100; i++) {
          String val = q.get(Integer.toString(i));
        // System.out.println(val);
          if (val == null || !val.equals(Integer.toString(i) + "ZZZ")) {
              System.out.println("Failed:" + Integer.toString(i));
              return;
          }
      }

      q.put("10",  "10YYY" );
      String val = q.get("10");
      if (val == null || !val.equals("10YYY")){
          System.out.println("Failed: replace" );
          return;
      }
      val = q.get("a10");
      if (val != null ){
          System.out.println("Failed: null val" );
          return;
      }

      
      System.out.println("OK");
  }
}

class ListNode{
  String key;
  String val;
  ListNode next;
  
  ListNode(String key, String val){
    this.key = key;
    this.val = val;
  }
}