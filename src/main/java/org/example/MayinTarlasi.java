package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class MayinTarlasi {

    public static void main(String[] args) {

        String[][] matrix;

        Scanner sc = new Scanner(System.in);

        System.out.println("Satir sayisi girin: ");

        int satir = sc.nextInt();

        System.out.println("Sütun sayisi girin: ");

        int sutun = sc.nextInt();

        matrix = createMatrix(satir, sutun);

        String[][] matrixForUser = createMatrixForUser(satir, sutun);


        while (true) {
            printFields(matrix);
            printFields(matrixForUser);
            System.out.print("Satir sec: ");
            int seciliSatir = sc.nextInt();
            System.out.print("Sutun sec: ");
            int seciliSutun = sc.nextInt();
            if (seciliSatir < 0 || seciliSatir > satir - 1 || seciliSutun < 0 || seciliSutun > sutun - 1) {
                System.out.println("BAD INPUT!");
                continue;
            }
            if (!isFieldEmpty(matrix, seciliSatir, seciliSutun)) {
                System.out.println("GAME OVER!");
                break;
            }
            int mineCount = Integer.parseInt(String.valueOf(sayiyiHesapla(matrix, seciliSatir, seciliSutun)));
            setField(matrixForUser, seciliSatir, seciliSutun, String.valueOf(mineCount));


        }

    }

    public static String[][] createMatrix(int satir, int sutun) {
        int mayinSayisi = (satir * sutun) / 4;
        String[][] matrix = new String[satir][sutun];
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                matrix[i][j] = "-";
            }
        }
        for (int i = 0; i < mayinSayisi; i++) {
            int randomSatir = Math.toIntExact(Math.round(Math.random() * (satir - 1)));
            int randomSutun = Math.toIntExact(Math.round(Math.random() * (sutun - 1)));
            if (matrix[randomSatir][randomSutun].equals("-")) {
                matrix[randomSatir][randomSutun] = "*";
            } else {
                i--;
            }

        }
        return matrix;
    }

    public static String[][] createMatrixForUser(int satir, int sutun) {
        String[][] matrix = new String[satir][sutun];
        for (int i = 0; i < satir; i++) {
            for (int j = 0; j < sutun; j++) {
                matrix[i][j] = "-";
            }
        }
        return matrix;
    }

    public static Boolean isFieldEmpty(String[][] matrix, int satir, int sutun) {
        if (matrix[satir][sutun].equals("*")) {
            return false;
        }
        return true;
    }

    public static void setField(String[][] matrix, int satir, int sutun, String value) {
        matrix[satir][sutun] = value;
    }

    public static int sayiyiHesapla(String[][] matrix, int satir, int sutun) {
        int mine = 0;

        for (int i = satir - 1; i <= satir + 1; i++) {
            for (int j = sutun - 1; j <= sutun + 1; j++) {
                try {
                    if (matrix[i][j].equals("*")) {
                        mine += 1;
                    }
                } catch (Exception e) {
                }
            }
        }

        return mine;
    }

    public static void printFields(String[][] matrix) {
        for (String[] i : matrix) {
            for (String s : i) {
                System.out.print(s);

            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }
}
