/* 
146. LRU Cache (Medium)
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

The cache is initialized with a positive capacity.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2 ); //capacity = 2

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
*/


/*
Doubly Linked List: This will hold the items that our cache has. We will have n items in the cache.

This structure satisfies the constraint for fast addition since any doubly linked list item can be added or removed in O(1) time with proper references.

Hashtable: The hashtable will give us fast access to any item in the doubly linked list items to avoid O(n) search for items and the LRU entry (which will always be at the tail of the doubly linked list).

This is a very common pattern, we use a structure to satisfy special insertion or remove properties (use a BST, linked list, etc.) and back it up with with a hashtable so we do not re-traverse the structures every time to find elements.

*/

class LRUCache {
    
    private class DNode {
        int key;
        int value;
        DNode prev;
        DNode next;
    }
    
    private Map<Integer, DNode> hashtable = new HashMap<Integer, DNode>();
    private DNode head, tail; //dummy head and tail
    private int totalItemsInCache;
    private int maxCapacity;
    

    public LRUCache(int maxCapacity) {
        //Cache starts empty
        totalItemsInCache = 0;
        
        //Capacity is set by client
        this.maxCapacity = maxCapacity;
        
        //Initialize the dummy head of the cache
        head = new DNode();
        head.prev = null;
        
        //Initialize the dummy tail of the cache
        tail = new DNode();
        tail.next = null;
        
        //Wire the head and tail together
        head.next = tail;
        tail.prev = head;
        
    }
    
    public int get(int key) {
        DNode node = hashtable.get(key);
        boolean itemFoundInCache = (node != null);
        
        if (!itemFoundInCache) {
            return -1;
        }
        
        moveToHead(node);
        return node.value;
        
    }
    
    public void put(int key, int value) {
        DNode node = hashtable.get(key);
        boolean itemFoundInCache = (node != null);
        
        if (!itemFoundInCache) {
            DNode newNode = new DNode();
            newNode.key = key;
            newNode.value = value;
            
            hashtable.put(key, newNode);
            addNode(newNode);
            
            totalItemsInCache++;
            
            if (totalItemsInCache > maxCapacity) {
                removeLRUEntryFromStructure();
            }
        } else {
            node.value = value;
            moveToHead(node);
        } 
    }
    
    private void removeLRUEntryFromStructure() {
        DNode tail = popTail();
        hashtable.remove(tail.key);
        totalItemsInCache--;
    }
    
    /*
      Insertions to the doubly linked list will always
      be right after the dummy head
    */
    private void addNode(DNode node){

      // Wire the node being inserted
      node.prev = head;
      node.next = head.next;

      // Re-wire the head's old next
      head.next.prev = node;

      // Re-wire the head to point to the inserted node
      head.next = node;
    }

    
    /*
      Remove the given node from the doubly linked list
    */
    private void removeNode(DNode node){

      // Grab reference to the prev and next of the node
      DNode savedPrev = node.prev;
      DNode savedNext = node.next;

      // Cut out going forwards
      savedPrev.next = savedNext;

      // Cut out going backards
      savedNext.prev = savedPrev;
    }

    
    private void moveToHead(DNode node){
      removeNode(node);
      addNode(node);
    }
    
    private DNode popTail(){
      DNode itemBeingRemoved = tail.prev;
      removeNode(itemBeingRemoved);
      return itemBeingRemoved;
    }
    
    
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

 /*
Complexity Analysis:
Time: O(1)
Space: O(N)
 */