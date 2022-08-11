package main;

import java.util.Comparator;
import java.util.Objects;

public class Edge implements Comparator<Edge>, Comparable<Edge> {

	private Node child;
	private int distance;

	public Edge(Node child, int distance) {
		this.child = child;
		this.distance = distance;
	}

	public Node getChild() {
		return child;
	}

	public void setChild(Node child) {
		this.child = child;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	@Override
	public int compare(Edge e1, Edge e2) {
		if (e1.getDistance() > e2.getDistance())
			return 1;
		if (e1.getDistance() < e2.getDistance())
			return -1;
		return 0;
	}

	@Override
	public int compareTo(Edge e) {
		if (this.getDistance() > e.getDistance())
			return 1;
		if (this.getDistance() < e.getDistance())
			return -1;
		return 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(child, distance);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Edge other = (Edge) obj;
		return Objects.equals(child, other.child) && distance == other.distance;
	}

	@Override
	public String toString() {
		return "Edge [child=" + child + ", distance=" + distance + "]";
	}

}
