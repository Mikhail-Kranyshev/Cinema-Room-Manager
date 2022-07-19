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
        System.out.println("");
    }

    public static char[][] createCinema(int n, int m) {
        char[][] matrix = new char[n][m];
        for (char[] i: matrix) {
            Arrays.fill(i, 'S');
        }
        print(matrix);
        return matrix;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        char[][] cinema = createCinema(numberOfRows, numberOfSeats);

        System.out.println("Enter a row number:");
        int rowNumber = scanner.nextInt();
        System.out.println("Enter a seat number in that row:");
        int seatNumber = scanner.nextInt();

        int price = 10;
        if (numberOfRows * numberOfSeats > 60 && rowNumber > numberOfRows / 2) {
            price = 8;
        }
        System.out.println("\nTicket price: $" + price);
        cinema[rowNumber - 1][seatNumber - 1] = 'B';
        print(cinema);
    }
}