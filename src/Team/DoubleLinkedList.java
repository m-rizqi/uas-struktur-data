package Team;

public class DoubleLinkedList {
    private Node first;
    private Node last;

    public DoubleLinkedList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void insertFirst(Mahasiswa mahasiswa) {
        Node temp = new Node(mahasiswa);
        if (isEmpty()) {
            last = temp;
        } else {
            first.setPrevious(temp);
        }
        temp.setNext(first);
        first = temp;
    }

    public void insertLast(Mahasiswa mahasiswa) {
        Node temp = new Node(mahasiswa);
        if (isEmpty())
            first = temp;
        else {
            last.setNext(temp);
            temp.setPrevious(last);
        }
        last = temp;
    }

    public Node deleteFirst() {
        Node temp = first;
        if (first.getNext() == null) {
            last = null;
        } else {
            first.getNext().setPrevious(null);
        }
        first = first.getNext();
        return temp;
    }

    public Node deleteLast() {
        Node temp = last;
        if (first.getNext() == null) {
            first = null;
        } else {
            last.getPrevious().setNext(null);
        }
        last = last.getPrevious();
        return temp;
    }

    public void showForward() {
        System.out.println("------------------------------------------------------------");
        System.out.println("              | N A M A                  | N I M       | P/L");
        System.out.println("------------------------------------------------------------");
        System.out.println("List: (first) |");
        Node index = first;
        while (index != null) {
            index.showNode();
            index = index.getNext();
        }
        System.out.println("         V    |");
        System.out.println("List:  (last) |");
    }

    public void showBackward() {
        System.out.println("------------------------------------------------------------");
        System.out.println("              | N A M A                  | N I M       | P/L");
        System.out.println("------------------------------------------------------------");
        System.out.println("List:  (last) |");
        Node index = last;
        while (index != null) {
            index.showNode();
            index = index.getPrevious();
        }
        System.out.println("         V    |");
        System.out.println("List: (first) |");
    }

    public Node getFirst() {
        return this.first;
    }

    public Node getLast() {
        return this.last;
    }

}
