package org.example;

import org.example.dao.RandomDao;
import org.example.dao.RandomDaoImp;
import org.example.dao.ScannerDao;
import org.example.dao.ScannerDaoImp;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //double salary = 1000;

        //System.out.println(MoneyUtil.format(salary));

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        ScannerDao scannerDao = new ScannerDaoImp(scanner); // Crear instancia de ScannerDaoImp
        RandomDao randomDao = new RandomDaoImp(random);

        Game game = new Game(scannerDao,randomDao);

        game.play();
    }
}