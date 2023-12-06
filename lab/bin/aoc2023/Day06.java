package aoc2023;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Day06 {

	public static void main(String[] args) throws FileNotFoundException {
		System.out.println(part1("C:\\Users\\colen\\eclipse-workspace\\aoc\\src\\words.txt"));
	}

	private static int part1(String fileName) throws FileNotFoundException {
		Scanner scan = new Scanner(new File(fileName));
		return fillMap(scan);
	}

	private static int fillMap(Scanner scan) {
		String[] string1 = filterInput(scan);
		String[] string2 = filterInput(scan);
		int total = 1;
		for (int i = 1; i < string2.length; i++) {
			total *= marginOfError(Integer.parseInt(string1[i]), Integer.parseInt(string2[i]));
		}
		return total;
	}

	private static int marginOfError(int duration, int high) {
		int min = 0;
		int max = 0;
		int i = 0;
		while(distance(duration, i)<=high) {
			i++;
		}
		min = i;
		while(distance(duration, i)>=high) {
			i++;
		}
		max = i;
		return max-min;
	}

	private static int distance(int duration, int speed) {
		return (duration-speed)*speed;
	}

	private static String[] filterInput(Scanner scan) {
		String str = scan.nextLine();
		return str.split("[ :]");
	}

}
