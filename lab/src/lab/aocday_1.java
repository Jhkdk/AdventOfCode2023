package lab;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class aocday_1 {
	public static void main(String[] args) throws FileNotFoundException {
		int fin = 0;
		Scanner scan = new Scanner(new File("C:\\Users\\cnielson6\\Downloads\\eclipse-workspace\\lab\\src\\words.txt"));
		while (scan.hasNext()) {
			String l = scan.nextLine();
			//String l = "eightwo2";
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
			int num = (Integer.parseInt(l.charAt(0) + "") * 10) + Integer.parseInt(l.charAt(l.length() - 1) + "");
			fin += num;
		}
		System.out.println(fin);
	}
}