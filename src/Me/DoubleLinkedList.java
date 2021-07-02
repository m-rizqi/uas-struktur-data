package Me;
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

    public boolean insertBefore(Mahasiswa mahasiswa, Mahasiswa mahasiswa2) {
        Node index = first;
        while (!index.getMahasiswa().equals(mahasiswa)) {
            index = index.getNext();
            if (index == null) {
                return false;
            }
        }
        Node temp = new Node(mahasiswa2);
        if (index == first) {
            first = temp;
        } else {
            temp.setPrevious(index.getPrevious());
            index.getPrevious().setNext(temp);
        }
        temp.setNext(index);
        index.setPrevious(temp);
        return true;
    }

    public Node delete(int NIM) {
        Node index = first;
        while (index.getMahasiswa().getNim() != NIM) {
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
        System.out.println("List: (first)");
        System.out.println("         |");
        Node index = first;
        while (index != null) {
            index.showNode();
            index = index.getNext();
        }
        System.out.println("         |");
        System.out.println("         V");
        System.out.println("      (last)");
    }

    public void showBackward() {
        System.out.println("List: (last)");
        System.out.println("         |");
        Node index = last;
        while (index != null) {
            index.showNode();
            index = index.getPrevious();
        }
        System.out.println("         |");
        System.out.println("         V");
        System.out.println("      (first)");
    }
    
    public Node getFirst(){
        return this.first;
    }
    public Node getLast(){
        return this.last;
    }
}
