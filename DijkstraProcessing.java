package main;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class DijkstraProcessing {

	public static void main(String[] args) {

		Node a = new Node("A");
		Node b = new Node("B");
		Node c = new Node("C");
		Node d = new Node("D");
		Node e = new Node("E");
		Node f = new Node("F");
		a.setEdges(new TreeSet<>(Arrays.asList(new Edge(b, 5), new Edge(c, 2))));
		b.setEdges(new TreeSet<>(Arrays.asList(new Edge(e, 4), new Edge(d, 2))));
		c.setEdges(new TreeSet<>(Arrays.asList(new Edge(b, 8), new Edge(d, 7))));
		d.setEdges(new TreeSet<>(Arrays.asList(new Edge(f, 1))));
		e.setEdges(new TreeSet<>(Arrays.asList(new Edge(f, 3), new Edge(d, 6))));
		f.setEdges(new TreeSet<>(Arrays.asList(new Edge(f, 0))));

		PriorityQueue<Node> nodesQueue = new PriorityQueue<>();
		Node rootNode = a;
		rootNode.setDistance(0);
		nodesQueue.add(rootNode);

		while (!nodesQueue.isEmpty()) {
			Node currentNode = nodesQueue.poll();
			if (currentNode.isProcessed()
					|| currentNode.getName().equals(currentNode.getEdges().first().getChild().getName())) {
				continue;
			}
			for (Edge currentEdge : currentNode.getEdges()) {
				Node destinationNode = currentEdge.getChild();
				int currentNodeDistance = currentNode.getDistance();
				int currentEdgeDistance = currentEdge.getDistance();
				int destinationNodeDistance = destinationNode.getDistance();
				if (currentNodeDistance + currentEdgeDistance < destinationNodeDistance) {
					destinationNodeDistance = currentNodeDistance + currentEdgeDistance;
					destinationNode.setDistance(destinationNodeDistance);
					destinationNode.setParent(currentNode);
				}
				nodesQueue.add(destinationNode);
			}
			currentNode.setProcessed(true);
		}
		System.out.println("*******************************");
		Node lastNode = f;
		String destinationNodeName = lastNode.getName();
		int distance = lastNode.getDistance();
		String path = destinationNodeName;

		while (true) {
			if (lastNode.getParent() == null) {
				break;
			}
			String previousNodeName = lastNode.getParent().getName();
			path = previousNodeName + path;
			lastNode = lastNode.getParent();
		}
		String separated = String.join("->", path.split(""));
		System.out.println("The shortest distance from node " + rootNode.getName() + " to " + destinationNodeName
				+ " is " + distance);
		System.out.println("Path is : " + separated);
	}

}
