package lrua;

import java.util.HashMap;

/*class Node{
	int value;
	int key;
	Node prev;
	Node next;
	
	public Node(int key,int value){
		this.key = key;
		this.value = value;
	}
} 
public class LRU {
     private int  capacity,count;
     private HashMap<Integer,Node> hmp;
     private Node head , tail;
     
     public LRU(int size) {
    	 this.capacity = size;
    	 hmp = new HashMap<Integer,Node>();
    	 head = new Node(0,0);
    	 tail = new Node(0,0);
    	 head.prev = null;
    	 head.next = tail;
    	 tail.prev = head;
    	 tail.next = null;
    	 this.count = 0;
     }
     
     public void addNode(Node node) {
    	 node.next = head.next;
    	 node.next.prev = node;
    	 node.prev = head;
    	 head.next = node;
     }
     
     public void deleteNode(Node node) {
    	 node.prev.next = node.next;
    	 node.next.prev = node.prev;
     }
     
     public int get(int key) {
    	 if(hmp.get(key) != null) {
    		 Node existNode = hmp.get(key);   //get for hashmap
    		 int val = existNode.value;
    		 deleteNode(existNode);
    		 addNode(existNode);
    		 return val;
    	 }
    	 return -1;
     }
     
     public void set(int key,int value) {
    	 if(hmp.get(key)!=null) {
    		 Node existNode = hmp.get(key);
    		 deleteNode(existNode);
    		 addNode(existNode);
    	 }else {
    		 if(count!=capacity) {
    			 Node newNode = new Node(key,value);
    			 addNode(newNode);
    			 hmp.put(key,newNode);   // put for map
    			 count++;
    		 }else {
    			 hmp.remove(tail.prev.key); 
    			 deleteNode(tail.prev);
    			 Node newNode = new Node(key,value);
    			 hmp.put(key,newNode); 
    			 addNode(newNode);
    		 }
    	 }
     } 
}*/
