package LinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertLinkedList(1,0);
        singleLinkedList.insertLinkedList(2,1);
        singleLinkedList.insertLinkedList(3,2);
        singleLinkedList.insertLinkedList(4,3);
//
        singleLinkedList.traverseLinkedList();
//        LinkedList<String> tes = new LinkedList<>();

	    // Exercise 1:
	    System.out.println(singleLinkedList.checkListForValue(6));



    }
}
