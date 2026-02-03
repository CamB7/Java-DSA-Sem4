//  Calculate the average temperature, and give how many days are above the average temperature
//
//	1. Take an input from the user (eg. 5)
//	2. Prompt the user to enter all the 5 numbers (temperature values)
//	3. Calculate the average temperature
//	4. Given the average temperature, how many of the numbers in the line 2 are above the average temperature?

package AverageTemperature;
import java.util.Scanner;

public class AverageTemp {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		double tempValues[];
		tempValues = new double[5];

		System.out.println("Enter 5 temperature values: ");
		for (int i = 0; i < tempValues.length; i++) {
			System.out.print("Value " + (i + 1) + ": ");
			while (!scanner.hasNextDouble()) {
				System.out.println("Error: Please enter a valid number.");
				scanner.next();
				System.out.print("Value " + (i + 1) + ": ");
			}
			tempValues[i] = scanner.nextDouble();
		}

		// Calculate average
		double sum = 0.0;
		for (double temp : tempValues) {
			sum += temp;
		}
		double average = sum / tempValues.length;

		// Count how many values are above the average
		int countAbove = 0;
		for (double temp : tempValues) {
			if (temp > average) countAbove++;
		}

		System.out.printf("Average temperature: %.2f\n", average);
		System.out.println("Number of values above average: " + countAbove);

		scanner.close();
	}
}



