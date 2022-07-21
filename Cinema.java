package cinema;

import java.util.Arrays;
import java.util.Scanner;

public class Cinema {
    public static void print(char[][] matrix) {
        System.out.print("\nCinema:\n ");
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.print(" " + (i + 1));
        }
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(" " + matrix[i][j]);
            }
            System.out.println("");
        }
    }

    public static char[][] createCinema(int n, int m) {
        char[][] matrix = new char[n][m];
        for (char[] i: matrix) {
            Arrays.fill(i, 'S');
        }
        return matrix;
    }

    public static int menu(){
        System.out.println("\n1. Show the seats\n" +
                "2. Buy a ticket\n" +
                "0. Exit");
        int n = -1;
        while (n < 0 || n > 2) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            }
        }
        return n;
    }

    public static char[][] buyTicket(char[][] matrix, Scanner sc){
        System.out.println("Enter a row number:");
        int rowNumber = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = sc.nextInt();

        int price = 10;
        if (matrix.length * matrix[0].length > 60 && rowNumber > matrix.length / 2) {
            price = 8;
        }
        System.out.println("\nTicket price: $" + price);
        matrix[rowNumber - 1][seatNumber - 1] = 'B';
        return matrix;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        char[][] cinema = createCinema(numberOfRows, numberOfSeats);
        int choice = 0;
        do {
            choice = menu();
            switch (choice) {
                case 1:
                    print(cinema);
                    break;
                case 2:
                    cinema = buyTicket(cinema, scanner);
                    break;
            }
        } while (choice != 0);
    }
}