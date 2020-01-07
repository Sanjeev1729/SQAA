package lrua;

import java.util.HashMap;
/*
 * apple : 1
 * banana : 1
 * mango : 1
 * apple : 2
 * kiwi : 1
 */
class Node{
	String key;
	int value;
	Node prev;
	Node next;
	
	public Node(String key,int value){
		this.key = key;
		this.value = value;
	}
}
public class LRUQ1 {
    private int capacity;
    private int count;
    private Node head;
    private Node tail;
    private HashMap<String,Node> hmp;
    public LRUQ1(int size){
    	this.capacity = size;
    	hmp = new HashMap<String,Node>();
    	count = 0;
    	head = new Node(null,0);
    	tail = new Node(null,0);
    	head.next = tail;
    	head.prev = null;
    	tail.next = null;
    	tail.prev = head;   	
    }
    
    public void addNode(Node node) {
    	node.next = head.next;
    	node.prev = head;
    	node.next.prev = node;
    	head.next = node;
    }
    
    public void deleteNode(Node node) {
    	node.prev.next = node.next;
    	node.next.prev = node.prev;
    }
    
    public int get(String key) {
    	if(hmp.get(key)!=null) {
    		Node node = hmp.get(key);
    		int val = node.value;
    		deleteNode(node);
    		addNode(node);
    		return val;
    	}
    	return -1;
    }
    
    public void set(String key) {
    	if(hmp.get(key)!=null) {
    		Node node = hmp.get(key);
    		deleteNode(node);
    		int val = node.value;
    		val = val + 1;
    		node.value = val;
    		addNode(node);
    	}else {
    		Node newNode = new Node(key,1);
    		hmp.put(key, newNode);
    		if(count!=capacity) {
    			addNode(newNode);
    			count++;
    		}else {
    			hmp.remove(tail.prev.key);
    			deleteNode(tail.prev);
    			addNode(newNode);
    		}
    	}
    }
}
