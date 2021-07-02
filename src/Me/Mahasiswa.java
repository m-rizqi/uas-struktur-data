package Me;
public class Mahasiswa {
    private String name;
    private int nim;
    private String gender;
    
    public Mahasiswa(String name, int nim, String gender){
        this.name = name;
        this.nim = nim;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
