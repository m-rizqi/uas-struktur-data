public class Mahasiswa {
    private String name;
    private int nim;
    private Gender gender;
    
    public Mahasiswa(String name, int nim, Gender gender){
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

}
