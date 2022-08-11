package main;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Node implements Comparable<Node>, Comparator<Node> {

	private static final int INFINITY = Integer.MAX_VALUE;

	private int distance;
	private String name;
	private boolean processed;
	private Node parent;
	private SortedSet<Edge> edges = new TreeSet<>(new EdgeDistanceComparator());

	public Node(String name) {
		this.name = name;
		this.distance = INFINITY;
		this.processed = false;
		this.parent = null;
	}

	public Node(String name, SortedSet<Edge> edges) {
		this.name = name;
		this.edges = edges;
		this.distance = INFINITY;
		this.processed = false;
	}

	@Override
	public int compare(Node n1, Node n2) {
		if (n1.getDistance() > n2.getDistance())
			return 1;
		if (n1.getDistance() < n2.getDistance())
			return -1;
		return 0;
	}

	@Override
	public int compareTo(Node n) {
		if (this.getDistance() > n.getDistance())
			return 1;
		if (this.getDistance() < n.getDistance())
			return -1;
		return 0;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public SortedSet<Edge> getEdges() {
		return edges;
	}

	public void setEdges(SortedSet<Edge> edges) {
		this.edges = edges;
	}

	@Override
	public int hashCode() {
		return Objects.hash(distance, name, parent, processed);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		return distance == other.distance && Objects.equals(name, other.name) && Objects.equals(parent, other.parent)
				&& processed == other.processed;
	}

	@Override
	public String toString() {
		return "Node [distance=" + distance + ", name=" + name + ", processed=" + processed + ", parent=" + parent
				+ "]";
	}

}
