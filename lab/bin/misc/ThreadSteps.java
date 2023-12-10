package misc;

import java.util.Map;

public class ThreadSteps extends Thread {
	private long steps;
	private Map<String, String> map;
	private String directions;
	private String current;

	public String getCurrent() {
		return current;
	}

	public ThreadSteps(Map<String, String> map, String directions, String current) {
		this.map = map;
		this.directions = directions;
		this.current = current;
	}

	public void main() {
		step(directions, map);
	}

	public void run() {
		step(directions, map);
	}

	public long getSteps() {
		return steps;
	}

	public void step(String directions, Map<String, String> map) {
		while (!current.endsWith("Z")) {
			current = map.get(current).split(" ")[directions.charAt((int) (steps % directions.length())) == 'R' ? 1
					: 0];
			steps++;
		}
	}
}
