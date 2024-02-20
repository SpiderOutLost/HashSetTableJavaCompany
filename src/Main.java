
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        CompanyHash companyHash = new CompanyHash();
        BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\danil\\IdeaProjects\\untitled\\src\\Companies.txt"));
        String line;

        while ((line = reader.readLine()) != null){
            companyHash.add(line);

        }
        System.out.println("Выберите работу:\n"+
                "1 - добавить компанию\n" +
                "2 - найти компанию" +
                "3 - удалить компанию\n" +
                "4 - вывести все компании\n" +
                "5 - выйти из программы");
        // 1 - добавить, 2 - найти, 3 - удалить, 4 - вывести
        reader.close();
        while(true){
            Scanner in = new Scanner(System.in);
            int key = in.nextInt();
            switch (key){
                case 1:
                    System.out.println("Введите местоположение компании через пробел, которую хотите добавить");
                    Scanner LineADD = new Scanner(System.in); // Полное местоположение компании через пробел
                    String line_add = LineADD.nextLine();

                    companyHash.add(line_add);
                    break;
                case 2:
                    System.out.println("Введите местоположение компании через пробел, которую хотите найти");
                    Scanner LineInSpisiok = new Scanner(System.in); // Полное местоположение компании через пробел
                    String line_in_spisok = LineInSpisiok.nextLine();
                    companyHash.FindCompany(line_in_spisok);
                    break;
                case 3:
                    System.out.println("Введите местоположение компании через пробел, которую хотите удалить");
                    Scanner removeCompanyLine = new Scanner(System.in); // Полное местоположение компании через пробел
                    String remove_line = removeCompanyLine.nextLine();
                    companyHash.remove(remove_line);
                    break;
                case 4:
                    companyHash.Print();
                    break;
                case 5: break;
            }
        }
    }
}