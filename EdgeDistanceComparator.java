package main;

import java.util.Comparator;

public class EdgeDistanceComparator implements Comparator<Edge> {

	@Override
	public int compare(Edge e1, Edge e2) {
		if (e1.getDistance() > e2.getDistance())
			return 1;
		if (e1.getDistance() < e2.getDistance())
			return -1;
		return 0;
	}

}
