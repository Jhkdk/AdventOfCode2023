package aoc2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class aocday_1 {
	public static void main(String[] args) throws FileNotFoundException {
		int fin = 0;

		int num;
		for (Scanner scan = new Scanner(
				new File("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\lab\\src\\words.txt")); scan
						.hasNext(); fin += num) {
			String l = scan.nextLine();
			l = l.replaceAll("one", "o1e");
			l = l.replaceAll("two", "t2o");
			l = l.replaceAll("three", "th3ee");
			l = l.replaceAll("four", "f4ur");
			l = l.replaceAll("five", "f5ve");
			l = l.replaceAll("six", "s6x");
			l = l.replaceAll("seven", "s7ven");
			l = l.replaceAll("eight", "e8ght");
			l = l.replaceAll("nine", "n9ne");
			l = l.replaceAll("[^0-9]", "");
			num = Integer.parseInt(String.valueOf(l.charAt(0))) * 10
					+ Integer.parseInt(String.valueOf(l.charAt(l.length() - 1)));
		}

		System.out.println(fin);
	}
}