package com.company.LinkedList;

public class StackByLinkedList{
    private int Size;
    private Node first;
    public void push(Node n){
        Node temp = first;
        first = n;
        first.setNext(temp);
        Size++;
    }
    public Node pop(){
        Node Old = first;
        Size--;
        first = first.getNext();
        return Old;
    }

    public static void main(String[] args) {
        StackByLinkedList stack = new StackByLinkedList();
        Node first = new Node("first");
        Node second = new Node("second");
        Node third = new Node("third");
        stack.push(first);
        stack.push(second);
        stack.push(third);
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }
}
