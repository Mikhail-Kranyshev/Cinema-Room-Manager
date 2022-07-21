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
                "3. Statistics\n" +
                "0. Exit");
        int n = -1;
        while (n < 0 || n > 3) {
            Scanner sc = new Scanner(System.in);
            if (sc.hasNextInt()) {
                n = sc.nextInt();
            }
        }
        return n;
    }

    public static char[][] buyTicket(char[][] matrix, Scanner sc) {
        do {
            System.out.println("Enter a row number:");
            int rowNumber = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNumber = sc.nextInt();
            if (rowNumber > matrix.length || seatNumber > matrix[0].length) {
                System.out.println("\nWrong input!\n");
            } else if (matrix[rowNumber - 1][seatNumber - 1] == 'B') {
                System.out.println("\nThat ticket has already been purchased!\n");
            } else {
                matrix[rowNumber - 1][seatNumber - 1] = 'B';
                int price = 10;
                if (matrix.length * matrix[0].length > 60 && rowNumber > matrix.length / 2) {
                    price = 8;
                }
                System.out.println("\nTicket price: $" + price);
                return matrix;
            }
        } while (true);
    }


    public static void getStatistics(char[][] matrix) {
        int count = 0;
        int currentIncome = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 'B') {
                    count++;
                    if (matrix.length * matrix[0].length > 60 && i + 1 > matrix.length / 2) {
                        currentIncome += 8;
                    } else {
                        currentIncome += 10;
                    }
                }
            }
        }
        float percentage = count * 100 / (float) (matrix.length * matrix[0].length);
        int totalIncome;
        if (matrix.length * matrix[0].length < 60) {
            totalIncome = matrix.length * matrix[0].length * 10;
        } else {
            int front = matrix.length / 2;
            int end = matrix.length - front;
            totalIncome = (front * matrix[0].length * 10) + end * matrix[0].length * 8;
        }
        System.out.printf("\nNumber of purchased tickets: %d\n", count);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.printf("Current income: $%d\n", currentIncome);
        System.out.printf("Total income: $%d\n", totalIncome);
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        final int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        final int numberOfSeats = scanner.nextInt();
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
                case 3:
                    getStatistics(cinema);
            }
        } while (choice != 0);
    }
}