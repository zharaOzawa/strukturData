import java.util.Scanner;

public class tugas1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Kapasitas array 10 sesuai kriteria [cite: 2]
        String[] nimArr = new String[10]; 
        String[] namaArr = new String[10];
        int count = 0; // Variabel count untuk melacak jumlah data 

        while (true) {
            // Menampilkan menu pilihan secara lengkap 
            System.out.println("\n========== MENU UTAMA ==========");
            System.out.println("Status Array: " + count + "/10 terisi");
            System.out.println("1. Insert at beginning");
            System.out.println("2. Insert at given position");
            System.out.println("3. Insert at end");
            System.out.println("4. Delete from beginning");
            System.out.println("5. Delete given position");
            System.out.println("6. Delete from end");
            System.out.println("7. Delete first occurence");
            System.out.println("8. Show data");
            System.out.println("9. Exit");
            System.out.print("Pilih menu (1-9): ");
            
            int menu = input.nextInt();

            if (menu == 9) { // Menu 9: Exit [cite: 12]
                System.out.println("Keluar dari program...");
                break;
            }

            // LOGIKA TAMBAH DATA (Menu 1, 2, 3)
            if (menu >= 1 && menu <= 3) {
                if (count >= 10) {
                    System.out.println("Gagal: Array sudah penuh!");
                    continue;
                }
                System.out.print("Masukkan NIM: "); String n = input.next();
                System.out.print("Masukkan Nama: "); String m = input.next();

                if (menu == 1) { // Insert at beginning [cite: 4]
                    for (int i = count; i > 0; i--) {
                        nimArr[i] = nimArr[i-1];
                        namaArr[i] = namaArr[i-1];
                    }
                    nimArr[0] = n; namaArr[0] = m;
                } 
                else if (menu == 2) { // Insert at given position [cite: 5]
                    System.out.print("Masukkan posisi (0-" + count + "): ");
                    int p = input.nextInt();
                    for (int i = count; i > p; i--) {
                        nimArr[i] = nimArr[i-1];
                        namaArr[i] = namaArr[i-1];
                    }
                    nimArr[p] = n; namaArr[p] = m;
                } 
                else if (menu == 3) { // Insert at end [cite: 6]
                    nimArr[count] = n;
                    namaArr[count] = m;
                }
                count++; // Setiap insert, count ditambah 1 
            } 
            
            // LOGIKA HAPUS DATA (Menu 4, 5, 6, 7)
            else if (menu >= 4 && menu <= 7) {
                if (count <= 0) {
                    System.out.println("Gagal: Data masih kosong!");
                    continue;
                }
                int hapusIdx = -1;

                if (menu == 4) { // Delete from beginning [cite: 7]
                    hapusIdx = 0;
                } 
                else if (menu == 5) { // Delete given position [cite: 8]
                    System.out.print("Masukkan posisi index yang dihapus: ");
                    hapusIdx = input.nextInt();
                } 
                else if (menu == 6) { // Delete from end [cite: 9]
                    hapusIdx = count - 1;
                } 
                else if (menu == 7) { // Delete first occurrence [cite: 10]
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    String cari = input.next();
                    for (int i = 0; i < count; i++) {
                        if (nimArr[i].equals(cari)) {
                            hapusIdx = i;
                            break;
                        }
                    }
                }

                if (hapusIdx != -1 && hapusIdx < count) {
                    // Geser data ke kiri untuk menutup lubang
                    for (int i = hapusIdx; i < count - 1; i++) {
                        nimArr[i] = nimArr[i+1];
                        namaArr[i] = namaArr[i+1];
                    }
                    count--; // Setiap delete, count dikurang 1 
                    System.out.println("Data berhasil dihapus.");
                } else {
                    System.out.println("Index tidak ditemukan!");
                }
            } 
            
            else if (menu == 8) { // Show data [cite: 11]
                System.out.println("--- DAFTAR MAHASISWA ---");
                for (int i = 0; i < count; i++) {
                    System.out.println("Index " + i + " -> NIM: " + nimArr[i] + ", Nama: " + namaArr[i]);
                }
            }
            else {
                System.out.println("Menu tidak valid!");
            }
        }
    }
}