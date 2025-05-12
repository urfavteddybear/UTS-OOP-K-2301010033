package uts.oop;
import java.util.Scanner;

public class UTSOOP {
    private static Mahasiswa[] mahasiswaList = new Mahasiswa[100];
    private static int jumlah = 0;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int pilihan = 0;
        do {
            System.out.println("\nAplikasi Pengelolaan Data Mahasiswa");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Mahasiswa");
            System.out.println("3. Ubah Mahasiswa");
            System.out.println("4. Hapus Mahasiswa");
            System.out.println("5. Keluar");
            pilihan = readInt("Pilih menu: ", 1, 5);

            switch (pilihan) {
                case 1 -> tambahMahasiswa();
                case 2 -> tampilkanMahasiswa();
                case 3 -> ubahMahasiswa();
                case 4 -> hapusMahasiswa();
                case 5 -> System.out.println("Terima kasih telah menggunakan aplikasi ini.");
            }
        } while (pilihan != 5);

        scanner.close();
    }

    // Method untuk menambahkan mahasiswa baru
    private static void tambahMahasiswa() {
        System.out.println("\nTambah Data Mahasiswa");
        String nama = readNama("Masukkan Nama: ");
        String nim = readNIM("Masukkan NIM: ");
        String jurusan = readJurusan("Masukkan Jurusan: ");
        // Pembuatan data mahasiswa
        mahasiswaList[jumlah++] = new Mahasiswa(nama, nim, jurusan);
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    private static void tampilkanMahasiswa() {
        if (jumlah == 0) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }
        for (int i = 0; i < jumlah; i++) {
            System.out.println((i + 1) + ". " + mahasiswaList[i]);
        }
    }
    // Method untuk mengedit mahasiswa 
    private static void ubahMahasiswa() {
        if (jumlah == 0) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        tampilkanMahasiswa();
        int index = readInt("\nMasukkan nomor mahasiswa yang ingin diubah: ", 1, jumlah) - 1;

        System.out.println("\nPilih data yang ingin diubah:");
        System.out.println("1. Nama");
        System.out.println("2. NIM");
        System.out.println("3. Jurusan");
        int pilihan = readInt("Pilihan: ", 1, 3);

        Mahasiswa mahasiswa = mahasiswaList[index];
        switch (pilihan) {
            case 1 -> {
                mahasiswa.setNama(readNama("Masukkan Nama Baru: "));
                System.out.println("Nama berhasil diubah!");
            }
            case 2 -> {
                mahasiswa.setNim(readNIM("Masukkan NIM Baru: "));
                System.out.println("NIM berhasil diubah!");
            }
            case 3 -> {
                mahasiswa.setJurusan(readJurusan("Masukkan Jurusan Baru: "));
                System.out.println("Jurusan berhasil diubah!");
            }
        }
    }
    // Method untuk menghapus data mahasiswa
    private static void hapusMahasiswa() {
        if (jumlah == 0) {
            System.out.println("Belum ada data mahasiswa.");
            return;
        }

        tampilkanMahasiswa();
        int index = readInt("Masukkan nomor mahasiswa yang ingin dihapus: ", 1, jumlah) - 1;

        for (int i = index; i < jumlah - 1; i++) {
            mahasiswaList[i] = mahasiswaList[i + 1];
        }
        mahasiswaList[--jumlah] = null;
        System.out.println("Mahasiswa berhasil dihapus!");
    }

    // Validasi Nama tidak boleh mengandung angka
    private static String readNama(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Nama tidak boleh kosong!");
            } else if (input.matches(".*\\d.*")) {
                System.out.println("Nama tidak boleh mengandung angka!");
            } else {
                return input;
            }
        }
    }
    
    // Validasi NIM harus berupa nomor
    private static String readNIM(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("NIM tidak boleh kosong!");
            } else if (!input.matches("\\d+")) {
                System.out.println("NIM harus berupa angka!");
            } else {
                return input;
            }
        }
    }
    
    // Validasi Jurusan tidak boleh mengandung angka
    private static String readJurusan(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                System.out.println("Jurusan tidak boleh kosong!");
            } else if (input.matches(".*\\d.*")) {
                System.out.println("Jurusan tidak boleh mengandung angka!");
            } else {
                return input;
            }
        }
    }

    // Overloading untuk membaca nilai integer pada range tsb
    private static int readInt(String prompt, int min, int max) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());
                if (input >= min && input <= max) {
                    return input;
                } else {
                    System.out.println("Masukkan angka antara " + min + " dan " + max + "!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }
    
    private static int readInt(String prompt) {
        int input;
        while (true) {
            try {
                System.out.print(prompt);
                input = Integer.parseInt(scanner.nextLine().trim());
                return input;
            } catch (NumberFormatException e) {
                System.out.println("Masukkan angka yang valid!");
            }
        }
    }
    
    // Validasi nilai input tidak boleh kosong
    private static String readString(String prompt) {
        String input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextLine().trim();
            if (!input.isEmpty()) {
                return input;
            } else {
                System.out.println("Input tidak boleh kosong!");
            }
        }
    }
}