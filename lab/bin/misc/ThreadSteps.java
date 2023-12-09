package misc;

import java.util.Map;

public class ThreadSteps extends Thread {
	private int steps;
	private Map<String,String> map;
	private String directions;
	private String current;
	public ThreadSteps(Map<String,String> map, String directions, String current) {
		this.map = map;
		this.directions = directions;
		this.current = current;
	}
	
	public void main() {
		steps = step(directions, map, current);
	}
	
	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
		this.steps = steps;
	}

	public static int step(String directions, Map<String, String> map, String current) {
		int steps = 0;
		while (!current.contains("ZZZ")) {
			current = map.get(current).split(" ")[directions.charAt(steps % directions.length()) == 'R' ? 1 : 0];
			steps++;
		}
		return steps;
	}
}
