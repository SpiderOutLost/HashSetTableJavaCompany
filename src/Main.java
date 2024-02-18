
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
            String[] s = line.split(" ");
            Company company = new Company(s[0], s[1], s[2], s[3]);
            companyHash.add(company);

        }
        reader.close();

        Company company_Proverka_na_nahojdenie = new Company("Россия", "Москва", "Арбат", "12");
        companyHash.FindCompany(company_Proverka_na_nahojdenie);
    }
}