package com.Algorithm.LinkedList;

import java.util.HashMap;

/**
 * hashmap����˫������
 */
public class N146_LRU {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2,1);
//        lruCache.put(2,2);
        System.out.println(lruCache.get(2));
//        lruCache.put(3,3);
//        System.out.println(lruCache.get(2));
//        lruCache.put(4,4);
//        System.out.println(lruCache.get(1));
//        System.out.println(lruCache.get(3));
//        System.out.println(lruCache.get(4));


    }
}
class LRUCache {

    class Node{
        int key;
        int value;
        Node pre;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }

    static HashMap<Integer, Node> map;
    static int max_size;
    static int size;
    static Node head;
    static Node tail;


    public LRUCache(int capacity) {
        map = new HashMap<>();
        size = 0;
        max_size = capacity;
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.pre = head;
    }

    /**
     * map��鲻������
     * �鵽�˾Ͱѽڵ��ͷŵ� Ȼ��ŵ�ͷ��
     * @param key
     * @return
     */
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node tem = map.get(key);
        unlink(tem);
        appendHead(tem);
        return tem.value;
    }

    /**
     * put�ȿ�ԭ���治����key ���ھ��ͷŵ�
     * Ȼ���½��ڵ�ŵ�ͷ�Ϻ�map��
     * ���У�鳬������ģ���ͷŵ�β�ͣ�map����ɾ��
     * @param key
     * @param value
     */
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            unlink(node);
        }
        Node fresh = new Node(key,value);
        map.put(key,fresh);
        appendHead(fresh);
        if(size > max_size){
            Node removetail = removetail();
            map.remove(removetail.key);
        }
    }

    public static void unlink(Node tem){
        Node next = tem.next;
        Node pre = tem.pre;
        tem.pre = null;
        tem.next = null;
        next.pre = pre;
        pre.next = next;
        size--;
    }

    public static void appendHead(Node tem){

        Node next = head.next;
        head.next = tem;
        tem.pre = head;
        next.pre = tem;
        tem.next = next;
        size++;

    }

    public static Node removetail(){
        Node toRemove = tail.pre;
        Node pre = toRemove.pre;
        toRemove.pre = null;
        toRemove.next = null;
        pre.next = tail;
        tail.pre = pre;
        size--;
        return toRemove;

    }
}
