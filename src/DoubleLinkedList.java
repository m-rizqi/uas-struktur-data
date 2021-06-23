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

    public boolean insertAfter(Mahasiswa mahasiswa, Mahasiswa mahasiswa2) {
        Node index = first;
        while (!index.getMahasiswa().equals(mahasiswa)) {
            index = index.getNext();
            if (index == null) {
                return false;
            }
        }
        Node temp = new Node(mahasiswa2);
        if (index == last) {
            last = temp;
        } else {
            temp.setNext(index.getNext());
            index.getNext().setPrevious(temp);
        }
        temp.setPrevious(index);
        index.setNext(temp);
        return true;
    }

    public Node delete(Mahasiswa mahasiswa) {
        Node index = first;
        while (!index.getMahasiswa().equals(mahasiswa)) {
            index = index.getNext();
            if (index == null) {
                return null;
            }
        }
        if (index == first) {
            first = index.getNext();
        } else {
            index.getPrevious().setNext(index.getNext());
        }

        if (index == last) {
            last = index.getPrevious();
        } else {
            index.getNext().setPrevious(index.getPrevious());
        }
        return index;
    }

    public void showForward() {
        System.out.print("List (first-->last): ");
        Node index = first;
        while (index != null) {
            index.showNode();
            index = index.getNext();
        }
        System.out.println("");
    }

    public void showBackward() {
        System.out.print("List (last-->first): ");
        Node index = last;
        while (index != null) {
            index.showNode();
            index = index.getPrevious();
        }
        System.out.println("");
    }
}
