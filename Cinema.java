package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();
        System.out.println("Total income:");
        int price;
        if (numberOfRows * numberOfSeats < 60) {
            price = numberOfRows * numberOfSeats * 10;
        } else {
            int front = numberOfRows / 2;
            int end = numberOfRows - front;
            price = (front * numberOfSeats * 10) + end * numberOfSeats * 8;
        }
        System.out.println("$" + price);
//        System.out.println("Cinema:\n" +
//                "  1 2 3 4 5 6 7 8\n" +
//                "1 S S S S S S S S\n" +
//                "2 S S S S S S S S\n" +
//                "3 S S S S S S S S\n" +
//                "4 S S S S S S S S\n" +
//                "5 S S S S S S S S\n" +
//                "6 S S S S S S S S\n" +
//                "7 S S S S S S S S");
    }
}