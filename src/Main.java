import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        CompanyHash companyHash = new CompanyHash();
        System.out.println("Меню по управлению хэш таблицой"); // 1 - создать компанию и добавить в таблицу
        // 2 - удалить компанию из таблицу
        // 3 - найти компанию по критериям
        // 4 - выход из программы
        boolean rabota_programm = true;
        while (rabota_programm){
        int key = in.nextInt();
        switch (key){
            case 1 :
                System.out.println("Ваша страна:");
                String country = in.next();
                System.out.println("Ваш город:");
                String city = in.next();
                System.out.println("Ваша улица:");
                String street = in.next();
                System.out.println("Ваш номер дома:");
                int NumHouse = in.nextInt();
                Company company = new Company(country, city, street, NumHouse);
                companyHash.add(company);
                break;
            case 2:
                System.out.println("Какую компанию из нижеперечисленных удалить? Введите полное местоположение компании");
                companyHash.Print();
                System.out.println("Ваша страна:");
                String delcountry = in.next();
                System.out.println("Ваш город:");
                String delcity = in.next();
                System.out.println("Ваша улица:");
                String delstreet = in.next();
                System.out.println("Ваш номер дома:");
                int delNumHouse = in.nextInt();
                Company delcompany = new Company(delcountry, delcity, delstreet, delNumHouse);
                companyHash.remove(delcompany);
                break;
            case 3:
                System.out.println("Какой критерий у вас есть?");
                Scanner input_criter  = new Scanner(System.in);
                int Criteri = in.nextInt(); // 1 - страна 2 - город 3 - улица 4 - номер дома

                break;
            case 4:
                rabota_programm = false;
                break;
            }
        }
    }
}