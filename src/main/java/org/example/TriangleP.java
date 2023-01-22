package org.example;

import java.util.Scanner;

public class TriangleP {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Basamak Sayisi: ");
        int basamak = scanner.nextInt();
        int tepeYildizSayisi = (basamak * 2) - 1;
        String ucgen = "";
        int yildizSayisi = tepeYildizSayisi;
        int boslukSayisi = 0;
        for (int z = 0; z < basamak; z++) {
            for (int i = 0; i < boslukSayisi; i++) {
                ucgen += " ";
            }
            for (int i = 0; i < yildizSayisi; i++) {
                ucgen += "*";

            }
            for (int i = 0; i < boslukSayisi; i++) {
                ucgen += " ";
            }
            ucgen += "\n";
            yildizSayisi -= 2;
            boslukSayisi++;
        }
        System.out.println(ucgen);
    }
}
