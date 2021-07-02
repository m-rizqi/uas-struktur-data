package Team;

public class Node {
    private Node next;
    private Node previous;
    private Mahasiswa mahasiswa;

    public Node(Mahasiswa m) {
        this.mahasiswa = m;
    }

    public void showNode() {
        System.out.printf("         |    | %-25s| %-12d| %s\n",mahasiswa.getNama(),mahasiswa.getNim(),mahasiswa.getGender());
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }
}
