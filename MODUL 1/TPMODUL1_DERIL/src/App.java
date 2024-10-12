import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {

        // Membuat ArrayList penerbangan
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        daftarPenerbangan.add(new Penerbangan("GA123", "Jakarta", "Bali", "08:00", "10:00", 1500000));
        daftarPenerbangan.add(new Penerbangan("SJ456", "Surabaya", "Jakarta", "12:00", "14:00", 1200000));
        daftarPenerbangan.add(new Penerbangan("AI789", "Bandung", "Medan", "15:00", "17:00", 1800000));

        // Membuat Scanner untuk input
        Scanner input = new Scanner(System.in);

        // Menampilkan daftar penerbangan
        System.out.println("Daftar Penerbangan Tersedia:");
        for (int i = 0; i < daftarPenerbangan.size(); i++) {
            System.out.println((i + 1) + ". " + daftarPenerbangan.get(i).getNomorPenerbangan());
        }

        // Memilih penerbangan
        System.out.print("Pilih nomor penerbangan: ");
        int pilihan = input.nextInt();
        input.nextLine(); // Membersihkan buffer

        if (pilihan > 0 && pilihan <= daftarPenerbangan.size()) {
            Penerbangan penerbanganDipilih = daftarPenerbangan.get(pilihan - 1);

            // Memasukkan data penumpang
            System.out.print("Masukkan NIK (gunakan NIM Praktikan): ");
            String NIK = input.nextLine();
            System.out.print("Masukkan Nama Depan (gunakan Nama Pendek Praktikan): ");
            String namaDepan = input.nextLine();
            System.out.print("Masukkan Nama Belakang (gunakan Kelas Praktikan): ");
            String namaBelakang = input.nextLine();

            // Membuat objek penumpang
            Penumpang penumpang = new Penumpang(NIK, namaDepan, namaBelakang);

            // Menampilkan data pemesanan
            System.out.println("\n--- Detail Pemesanan Tiket ---");
            penerbanganDipilih.tampilDaftarPenerbangan();
            System.out.println("\nDetail Penumpang:");
            penumpang.tampilDaftarPenumpang();
        } else {
            System.out.println("Penerbangan tidak valid.");
        }

        input.close();
    }
}

class Penerbangan {
    private String nomorPenerbangan;
    private String bandaraKeberangkatan;
    private String bandaraTujuan;
    private String waktuKeberangkatan;
    private String waktuKedatangan;
    private float hargaTiket;

    // Constructor
    public Penerbangan(String nomorPenerbangan, String bandaraKeberangkatan, String bandaraTujuan,
                       String waktuKeberangkatan, String waktuKedatangan, float hargaTiket) {
        this.nomorPenerbangan = nomorPenerbangan;
        this.bandaraKeberangkatan = bandaraKeberangkatan;
        this.bandaraTujuan = bandaraTujuan;
        this.waktuKeberangkatan = waktuKeberangkatan;
        this.waktuKedatangan = waktuKedatangan;
        this.hargaTiket = hargaTiket;
    }

    // Getters
    public String getNomorPenerbangan() {
        return nomorPenerbangan;
    }

    public String getBandaraKeberangkatan() {
        return bandaraKeberangkatan;
    }

    public String getBandaraTujuan() {
        return bandaraTujuan;
    }

    public String getWaktuKeberangkatan() {
        return waktuKeberangkatan;
    }

    public String getWaktuKedatangan() {
        return waktuKedatangan;
    }

    public float getHargaTiket() {
        return hargaTiket;
    }

    // Method untuk menampilkan daftar penerbangan
    public void tampilDaftarPenerbangan() {
        System.out.println("Nomor Penerbangan: " + nomorPenerbangan);
        System.out.println("Bandara Keberangkatan: " + bandaraKeberangkatan);
        System.out.println("Bandara Tujuan: " + bandaraTujuan);
        System.out.println("Waktu Keberangkatan: " + waktuKeberangkatan);
        System.out.println("Waktu Kedatangan: " + waktuKedatangan);
        System.out.println("Harga Tiket: Rp. " + hargaTiket);
    }
}

class Penumpang {
    private String NIK;
    private String namaDepan;
    private String namaBelakang;

    // Constructor
    public Penumpang(String NIK, String namaDepan, String namaBelakang) {
        this.NIK = NIK;
        this.namaDepan = namaDepan;
        this.namaBelakang = namaBelakang;
    }

    // Method untuk menampilkan daftar penumpang
    public void tampilDaftarPenumpang() {
        System.out.println("NIK: " + NIK);
        System.out.println("Nama: " + namaDepan + " " + namaBelakang);
    }
}

