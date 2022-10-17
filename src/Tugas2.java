import java.util.Arrays;
import java.util.Scanner;

interface library {
    void cekDate(int date);
    boolean cekFrom(String method, String from);
    boolean cekName(String method, String name);
    void list();
}
public class Tugas2 implements library {
    Scanner input = new Scanner(System.in);
    String inName, inFrom;
    int inDate, inIndex = 1;
    public String[] book = new String[1];
    String[] place = {"Malang", "Bandung", "Surabaya"};
    public void cekDate(int date){
        for (int i = 0; i < book.length; i++) {
            int parsedYear = Integer.parseInt(parseBook(book[i], "date"));
            if (parsedYear < 2018 && date < 2018) {
                System.out.printf("%s, %s. %s\n", parseBook(book[i], "name"), parseBook(book[i], "from"), parseBook(book[i], "date"));
            } else {
                System.out.printf("%s, %s. %s\n", parseBook(book[i], "name"), parseBook(book[i], "from"), parseBook(book[i], "date"));
            }
        }
    }

    public boolean cekFrom(String method, String from){
        if(method.equals("find")){
            for (int i = 0; i < book.length; i++) {
                if (from.compareTo(parseBook(book[i], "from")) == 0){
                    System.out.printf("%s, %s. %s\n", parseBook(book[i],"name"), parseBook(book[i], "from"), parseBook(book[i], "date"));
                }
            }
        } else if (method.equals("validate")){
            for (int i = 0; i < place.length; i++) {
                if (from.equals(place[i])){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean cekName(String method, String name){
        if (method.equals("find")){
            for (int i = 0; i < book.length; i++) {
                if (parseBook(book[i], "name").equals(name)){
                    System.out.printf("%s, %s. %s\n", parseBook(book[i],"name"), parseBook(book[i], "from"), parseBook(book[i], "date"));
                }
            }
        } else if (method.equals("dup")){
            for (int i = 0; i < book.length; i++) {
                if (name.compareTo(parseBook(book[i], "name")) == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public void list(){
        System.out.printf("%-15s | %-15s | %-15s", "Name", "From", "Year");
        for (String s : book) {
            System.out.printf("\n%-15s , %-15s . %-15s", parseBook(s,"name"), parseBook(s, "from"), parseBook(s, "date"));
        }
        mainMenu();
    }

    private String parseBook(String book, String tag){
        String[] parsedBook = book.split("[,.]");
        String parsedName = parsedBook[0];
        String parsedFrom = parsedBook[1];
        String parsedDate = parsedBook[2];
        if (tag.equals("name")){
            return parsedName;
        } else if (tag.equals("from")) {
            return parsedFrom;
        } else if (tag.equals("date")) {
            return parsedDate;
        } else {
            return "null";
        }
    }

    void findBook(){
        System.out.println("Find Book");
        System.out.println("1. Find books by Region\n2. Find books by Date");
        System.out.print("Pilih menu : ");
        int findMethod = input.nextInt();
        switch (findMethod){
            case 1:
                System.out.println("Finding Book Using Region Method");
                System.out.print("Input Region : ");
                input.nextLine(); String findRegion = input.nextLine();
                cekFrom("find", findRegion);
                break;
            case 2:
                System.out.println("Finding Book Using Date Method");
                System.out.print("Input Region : ");
                input.nextLine(); int findDate = input.nextInt();
                cekDate(findDate);
                break;
        }
        mainMenu();
    }

    public void deleteBook(){
        System.out.print("Masukkan Nama buku :");
        input.nextLine();
        String rmBook = input.nextLine();
        String tempBooks[] = new String[book.length - 1];
        try {
            if(cekName("dup", rmBook)){
                for(int i = 0, k = 0; i < book.length; i++){
                    if (!rmBook.equals(parseBook(book[i], "name"))){
                        tempBooks[k++] = book[i];
                    }
                }
                inIndex--;
                book = Arrays.copyOf(tempBooks, inIndex);
            } else {
                throw new Exception("Buku tidak terdaftar di sistem");
            }
        } catch (Exception e){
            System.out.println(e);
            deleteBook();
        }
        mainMenu();
    }
    
    public void inputNama(){
        System.out.print("Nama : ");
        inName = input.nextLine();
        try {
            if (cekName("dup", inName)){
                throw new Exception("Nama telah ada di list book");
            }
        } catch (Exception e){
            System.out.println(e);
            inputNama();
        }
    }

    public void inputFrom(){
        System.out.print("From : ");
        inFrom = input.nextLine();
        try {
            if (!cekFrom("validate", inFrom)) {
                throw new Exception("Region tidak terdaftar pada sistem");
            }
        } catch (Exception e){
            System.out.println(e);
            inputFrom();
        }
    }

    public void inputDate(){
        System.out.print("Date : ");
        inDate = input.nextInt();
    }

    public void registerBook(){
        System.out.println("Register ");
        input.nextLine();

        inputNama();
        inputFrom();
        inputDate();

        String bookName = (inName + "," + inFrom + "." + inDate);
        book = Arrays.copyOf(book, inIndex + 1);
        book[inIndex] = bookName;
        inIndex++;
        System.out.println("Buku berhasil ditambahkan");
        mainMenu();
    }

    private void mainMenu(){
        System.out.print("\n===============================");
        System.out.println("\nWelcome to, UMM Library");
        System.out.println("1. Book Register\n2. List Book\n3. Find Book\n4. Delete Book");
        System.out.print("Pilih menu: ");
        int go = input.nextInt();
        switch (go){
            case 1 : registerBook(); break;
            case 2 : list(); break;
            case 3 : findBook(); break;
            case 4 : deleteBook(); break;
        }
    }
    public static void main(String[] args) {
        Tugas2 main = new Tugas2();
        main.book[0] = "This is Book,Malang.2022";
        main.mainMenu();
    }
}
