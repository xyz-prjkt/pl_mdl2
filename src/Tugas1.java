import java.util.Scanner;
public class Tugas1 {

    Scanner inputData = new Scanner(System.in);
    private String NIM;
    private String Email;
    private String Nama;
    private String Telp;
    private String Alamat;

    public static void main(String[] args) {
        Tugas1 main = new Tugas1();
        main.inputNama();
        main.inputNIM();
        main.inputEmail();
        main.inputTelp();
        main.inputAlamat();
        main.displayProfile();
    }

    void displayProfile(){
        System.out.printf("%-15s%s\n", "Nama" + ":", getNama());
        System.out.printf("%-15s%s\n", "NIM" + ":", getNIM());
        System.out.printf("%-15s%s\n", "eMail" + ":", getEmail());
        System.out.printf("%-15s%s\n", "No. Telp" + ":", getTelp());
        System.out.printf("%-15s%s\n", "Alamat" + ":", getAlamat());
    }

    void inputNIM(){
        System.out.print("Masukkan NIM : ");

        String inputNIM = inputData.nextLine();
        String middleNIM = inputNIM.substring(4, 12);

        try {
            if (inputNIM.length() > 15) {
                throw new Exception("NIM terdeteksi lebih dari 15 digit");
            } else if (inputNIM.length() < 15 ) {
                throw new Exception("NIM terdeteksi kurang dari 15 digit");
            } else if (middleNIM.equals("10370311")){
                setNIM(inputNIM);
            } else {
                throw new Exception("NIM tidak sesuai");
            }
        } catch (Exception e) {
            System.out.println(e);
            inputNIM();
        }
    }

    void inputEmail(){
        System.out.print("Masukkan Email UMM : ");
        String inputEmail = inputData.nextLine();

        /*  Blueprint Case
            xyzuan@webmail.umm.ac.id // Users Input
            xyzuan = 6 Char // frontEmail
            @webmail.umm.ac.id = 18 Char // endEmail
            totalChar = 24
            frontIndex = 24 - 18 = 6, so begins with 1 -> 6
            startIndex = 1 -> frontIndex
            endIndex = frontIndex -> totalChar
        */

        String endEmail = "@webmail.umm.ac.id";
        int totalEmailChar = inputEmail.length();
        int endEmailChar = endEmail.length();
        int frontIndex = totalEmailChar - endEmailChar;
        String parsedStart = inputEmail.substring(0, frontIndex);
        String parsedEnd = inputEmail.substring(frontIndex, totalEmailChar);

        try {
            if (parsedStart.isEmpty()){
                throw new Exception("Email tidak sah");
            } else if (!parsedEnd.equals(endEmail)) {
                throw new Exception("Email wajib menggunakan domain @webmail.umm.ac.id");
            } else {
                setEmail(inputEmail);
            }
        } catch (Exception e) {
            System.out.println(e);
            inputEmail();
        }
    }

    void inputNama(){
        System.out.print("Masukkan Nama : ");
        setNama(inputData.nextLine());
    }

    void inputTelp(){
        System.out.print("Masukkan No Telp : ");
        String inputTelp = inputData.nextLine();
        try {
            if (!inputTelp.contains("+62")) {
                throw new Exception("Nomor telp harus diawali dengan +62");
            } else {
                setTelp(inputTelp);
            }
        } catch (Exception e) {
            System.out.println(e);
            inputTelp();
        }
    }

    void inputAlamat(){
        System.out.print("Masukkan Alamat : ");
        setAlamat(inputData.nextLine());
    }

    public String getNIM() {
        return NIM;
    }

    public void setNIM(String NIM) {
        this.NIM = NIM;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String nama) {
        Nama = nama;
    }

    public String getTelp() {
        return Telp;
    }

    public void setTelp(String telp) {
        Telp = telp;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String alamat) {
        Alamat = alamat;
    }
}
