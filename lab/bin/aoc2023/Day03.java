package aoc2023;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Deque;
import java.util.LinkedList;
import java.io.FileNotFoundException;
import java.io.File;

public class Day03 {
	static ArrayList<ArrayList<String>> grid = new ArrayList<>();

	public static void main(String[] args) throws FileNotFoundException {
		int num = 0;
		int fin = 0;

		Scanner scan = new Scanner(new File("words.txt"));
		// filling array by splitting code into lines and splitting those into values
		while (scan.hasNextLine()) {
			grid.add(new ArrayList<>(Arrays.asList(scan.nextLine().split(""))));
		}
		// cycling through 2d arraylist
		fin = cycle(fin);
		System.out.println(fin);
	}

	private static int cycle(int fin) {
		int num;
		for (int x = 0; x < grid.size(); x++) {
			for (int y = 0; y < grid.get(x).size(); y++) {
				//checks if gear, returns if it is, and removes the numbers
				if(grid.get(x).get(y).matches("[*]")) {
					fin += checkNumPerim(x, y);
				}
			}
		}
		for (int x = 0; x < grid.size(); x++) {
			for (int y = 0; y < grid.get(x).size(); y++) {
				// checks if its a number, then checks if it has a symbol in its perimeter
				if (grid.get(x).get(y).matches("[0-9]")) {
					num = getFullNum(x, y);
					if (checkPerim(x, y, (num + "").length())) {
						fin += num;
					}
					y += (num + "").length();
				}
			}
		}
		return fin;
	}

	// takes in x and y of first char in number, gives back if surrounded by
	// anything not a period or a number
	public static boolean checkPerim(int x, int y, int length) {
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < length + 1; j++) {
				try {
					if (grid.get(x + i).get(y + j).matches("[^0-9.]")) {
						return true;
					}
				} catch (IndexOutOfBoundsException e) {
				}
			}
		}
		return false;
	}

	public static int checkNumPerim(int x, int y) {
		int adj = 0;
		ArrayList<Integer> array = new ArrayList<>();
		for (int i = -1; i < 2; i++) {
			for (int j = -1; j < 1 + 1; j++) {
				try {
					if (grid.get(x + i).get(y + j).matches("[0-9]")) {
						adj++;
						array.add(getFullNum(x+i, y+j));
					}
				} catch (IndexOutOfBoundsException e) {
				}
			}
		}
		if (adj == 2) {
			return array.get(0) * array.get(1);
		}
		return 0;
	}

	public static int getFullNum(int x, int y) {
		Deque<String> deck = new LinkedList<>();
		int i = y;
		try {
			while (grid.get(x).get(i).matches("[0-9]")) {
				deck.add(grid.get(x).get(i));
				grid.get(x).set(i, ".");
				i++;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		i = y - 1;
		try {
			while (grid.get(x).get(i).matches("[0-9]")) {
				deck.push(grid.get(x).get(i));
				grid.get(x).set(i, ".");
				i--;
			}
		} catch (IndexOutOfBoundsException e) {
		}
		int num = 0;
		while (!deck.isEmpty()) {
			num = num * 10 + Integer.parseInt(deck.pop());
		}
		return num;
	}
}
