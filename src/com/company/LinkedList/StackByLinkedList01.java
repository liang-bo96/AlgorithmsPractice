package com.company.LinkedList;

public class StackByLinkedList01 {
    private int Size;
    private Node first;
    public void push(Node n){
        if (first == null){
            first = n;
        }else{
            Node temp = first;
            while (temp.getNext() != null ){
                temp = temp.getNext();
            }
            temp.setNext(n);
        }
        Size++;
    }
    public Node pop(){
        if(Size>1){

            Node temp = first;
            while (temp.getNext().getNext() != null ){
                temp = temp.getNext();
            }
            Node last = temp.getNext();
            temp.setNext(null);
            Size--;
            return last;
        }
        return first;

    }

    public static void main(String[] args) {
        StackByLinkedList01 stack = new StackByLinkedList01();
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
