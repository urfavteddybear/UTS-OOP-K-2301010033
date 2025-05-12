package uts.oop;

/**
 *
 * @author User
 */
public class Mahasiswa {
    private String nama;
    private String nim;
    private String jurusan;
    
    // Constructor dengan semua parameter (nama, nim, jurusan)
    public Mahasiswa(String nama, String nim, String jurusan) {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }
    
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNim() { return nim; }
    public void setNim(String nim) { this.nim = nim; }
    public String getJurusan() { return jurusan; }
    public void setJurusan(String jurusan) { this.jurusan = jurusan; }
    
    @Override
    public String toString() {
        return "Nama: " + nama + ", NIM: " + nim + ", Jurusan: " + jurusan;
    }
}