package MovieTheater;

import java.util.Scanner;

public class MovieTheater {
	private static final boolean OPEN = false;
	private static final boolean RESERVED = true;

	public static void main(String[] args) {

		boolean[][] initialSeats = {
				{RESERVED, OPEN,     OPEN,     RESERVED, OPEN},
				{OPEN,     RESERVED, RESERVED, RESERVED, OPEN},
				{OPEN,     OPEN,     RESERVED, RESERVED, RESERVED},
				{OPEN,     OPEN,     RESERVED, OPEN,     RESERVED}
		};

		boolean[][] seats = cloneSeats(initialSeats);
		String[] seatLetters = {"A","B","C","D"};
		Scanner scanner = new Scanner(System.in);

		loop:
		while (true) {
			printChart(initialSeats, seatLetters);
			System.out.println("Commands: R = reserve, C = cancel a reservation, S = Show initial seating chart, Q = quit");
			System.out.print("Enter a command: ");
			String command = scanner.nextLine().trim().toUpperCase();

			switch (command) {
				case "Q":
				case "QUIT":
					break loop;
				case "R":
					System.out.print("Enter seat to reserve (e.g. A1): ");
					handleReserve(scanner.nextLine().trim().toUpperCase(), initialSeats, seatLetters);
					break;
				case "C":
					System.out.print("Enter seat to cancel (e.g. A1): ");
					handleCancel(scanner.nextLine().trim().toUpperCase(), initialSeats, seatLetters);
					break;
				case "S":
					System.out.println("Showing initial seating chart: ");
					printChart(seats, seatLetters);
					break;

				default:
					System.out.println("Unknown command.");
			}

			System.out.println();
		}
		scanner.close();
		System.out.println("Goodbye!");
	}

	private static void handleReserve(String choice, boolean[][] seats, String[] seatLetters) {
		if (checkIsSeatValid(choice, seats)) {
			System.out.println("Invalid input. Use a letter followed by a number (e.g. A1).");
			return;
		}
		int row = choice.charAt(0) - 'A';
		int col = Integer.parseInt(choice.substring(1)) - 1;

		if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
			System.out.println("Seat out of range.");
			return;
		}

		if (seats[row][col] == OPEN) {
			seats[row][col] = RESERVED;
			System.out.println();
			System.out.println(choice + " has been reserved.");
		} else {
			System.out.println();
			System.out.println(choice + " is already reserved. Please choose another seat.");
		}
	}

	private static void handleCancel(String choice, boolean[][] seats, String[] seatLetters) {
		if (checkIsSeatValid(choice, seats)) {
			System.out.println("Invalid input. Use a letter followed by a number (e.g. A1).");
			return;
		}
		int row = choice.charAt(0) - 'A';
		int col = Integer.parseInt(choice.substring(1)) - 1;

		if (row < 0 || row >= seats.length || col < 0 || col >= seats[0].length) {
			System.out.println("Seat out of range.");
			return;
		}

		if (seats[row][col] == RESERVED) {
			seats[row][col] = OPEN;
			System.out.println();
			System.out.println(choice + " reservation canceled.");
		} else {
			System.out.println();
			System.out.println(choice + " is not reserved.");
		}
	}

	private static boolean[][] cloneSeats(boolean[][] initial) {
		boolean[][] clone = new boolean[initial.length][];
		for (int i = 0; i < initial.length; i++) {
			if (initial[i] == null) {
				clone[i] = null;
			} else {
				clone[i] = new boolean[initial[i].length];
				System.arraycopy(initial[i], 0, clone[i], 0, initial[i].length);
			}
		}
		return clone;
	}

	private static boolean checkIsSeatValid(String input, boolean[][] seats) {
		if (input == null || input.length() < 2) {
			return true;
		}
		char rowChar = input.charAt(0);
		if (rowChar < 'A' || rowChar >= 'A' + seats.length) return true;
		String num = input.substring(1);
		return !isDigit(num);
	}

	private static boolean isDigit(String str) {
		if (str == null || str.isEmpty()) {
			return false;
		}
		for (int i = 0; i < str.length(); i++) {
			if (!Character.isDigit(str.charAt(i))) return false;
		}
		return true;
	}

	private static void printChart(boolean[][] seats, String[] seatLetters) {
		System.out.println();
		System.out.println("   1   2   3   4   5");
		for (int i = 0; i < seats.length; i++) {
			System.out.print(seatLetters[i] + " ");
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print(seats[i][j] ? "[X] " : "[ ] ");
			}
			System.out.println();
		}
	}
}