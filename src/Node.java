class Node{
    private Mahasiswa mahasiswa;
    private Node next;
    private Node previous;

    public Node(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
    }

    public void showNode() {
        System.out.println("{ " + this.mahasiswa.getName()+" }");
    }

    public Mahasiswa getMahasiswa() {
        return mahasiswa;
    }

    public void setMahasiswa(Mahasiswa mahasiswa) {
        this.mahasiswa = mahasiswa;
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

}