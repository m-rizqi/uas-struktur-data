package Team;

public class Mahasiswa {
    private String nama;
    private long nim;
    private String gender;

    public Mahasiswa(String nama, long nim, String gender) {
        this.nama = nama;
        this.nim = nim;
        this.gender = gender;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getNim() {
        return nim;
    }

    public void setNim(long nim) {
        this.nim = nim;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
