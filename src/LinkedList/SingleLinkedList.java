package LinkedList;

public class SingleLinkedList {
    public Node head;
    public Node tail;
    public int size;

    public Node createSingleLinkedList (int nodeValue) {
        Node node = new Node();
        node.next = null;
        node.value = nodeValue;
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    //insert Method
    public void insertLinkedList(int nodeValue, int location) {
        Node node = new Node();
        node.value = nodeValue;

        if (head == null){
            createSingleLinkedList(nodeValue);
            return;
        } else if (location == 0){
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            Node tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    }

    // Traversing through a linked list
    public void traverseLinkedList (){
        if (head == null) {
            System.out.println("Linked list does not exist");
        } else {
            Node tempNode = head;
            for (int i = 0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size -1){
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;

            }
            System.out.println("\n");

        }
    }

    //EXERCISE 1: given a value, search for that element and return a boolean if the element exist or not.
	public boolean checkListForValue(int givenValue) {
		Node tempNode = head;
		while (head != null) {
			if (tempNode.value == givenValue) {
				return true;
			}
			tempNode = tempNode.next;
		}
		return false;
	}

	//EXERCISE 2: Given a location Implement a Delete method.
	public void deleteAtLocation(int location) {
		if (head == null) {
			System.out.println("Nothing to delete");
			return;
		}

		if (location < 0 || location >= size) {
			System.out.println("Invalid location");
			return;
		}

		//delete head
		if (location == 0) {
			if (size == 1) {
				head = null;
				tail = null;
				size = 0;
				return;
			}
			head = head.next;
			size--;
			return;
		}

		//delete at middle or tail
		Node prev = head;
		int index = 0;
		while (index < location - 1) {
			prev = prev.next;
			index++;
		}
		Node toDelete = prev.next;
		prev.next = toDelete.next;

		//if deleting the tail, update it
		if (toDelete == tail) {
			tail = prev;
		}

		size--;
	}
}
