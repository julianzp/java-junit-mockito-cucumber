package org.example.dao;
import java.util.Scanner;

public class ScannerDaoImp implements ScannerDao{

    private Scanner scanner;

    public ScannerDaoImp(Scanner scanner) {

        this.scanner = scanner;
    }
    @Override
    public String readLine() {
        return scanner.nextLine();
    }
}
