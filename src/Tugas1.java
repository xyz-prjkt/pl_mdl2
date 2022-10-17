import java.util.Scanner;
public class Tugas1 extends Tugas1Model {
    Scanner inputData = new Scanner(System.in);

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

        String allowedDomain = "@webmail.umm.ac.id";
        String parsedStart = inputEmail.substring(0, inputEmail.length() - allowedDomain.length());

        try {
            if (parsedStart.isEmpty()){
                throw new Exception("Email tidak sah");
            } else if (!inputEmail.endsWith(allowedDomain)) {
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
        String inputNama = inputData.nextLine();
        try {
            if (containsNum(inputNama)){
                throw new Exception("Nama tidak diperbolehkan terdapat angka");
            } else {
                setNama(inputNama);
            }
        } catch (Exception e){
            System.out.println(e);
            inputNama();
        }
    }

    void inputTelp(){
        System.out.print("Masukkan No Telp : ");
        String inputTelp = inputData.nextLine();
        try {
            if (!inputTelp.substring(0,3).equals("+62")) {
                throw new Exception("Nomor telp harus berasal dari Indonesia (+62)");
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

    boolean containsNum(String text){
        char[] chars = text.toCharArray();
        for (char c : chars){
            if(Character.isDigit(c)){
                return true;
            }
        }
        return false;
    }
}
