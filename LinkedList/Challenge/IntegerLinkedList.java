package LinkedList.Challenge;

public class IntegerLinkedList {

    private IntegerNode head;
    private int size;

    public void addToFront(Integer value) {
        IntegerNode node = new IntegerNode(value);
        node.setNext(head);
        head = node;
        size++;
    }

    public IntegerNode removeFromFront() {
        if (isEmpty()) {
            return null;
        }

        IntegerNode removedNode = head;
        head = head.getNext();
        size--;
        removedNode.setNext(null);
        return removedNode;
    }

    public void insertSorted(Integer value) {

        // add your code here
        IntegerNode insertedNode = new IntegerNode(value);
        if (head ==null || head.getValue() > insertedNode.getValue()) {
            insertedNode.setNext(head);
            head = insertedNode;
            return;
        }

        IntegerNode current = head.getNext();
        IntegerNode previous = head;

        while(current!=null && insertedNode.getValue()>current.getValue()){
            previous = current;
            current = current.getNext();
        }
        previous.setNext(insertedNode);
        insertedNode.setNext(current);

    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList() {
        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}