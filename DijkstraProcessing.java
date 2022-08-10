package main;

import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraProcessing {

	public static void main(String[] args) {
		Graph graph = new Graph();

		graph.addNodeAndEdges("A", Arrays.asList(new Edge("B", 5), new Edge("C", 2)));
		graph.addNodeAndEdges("B", Arrays.asList(new Edge("E", 4), new Edge("D", 2)));
		graph.addNodeAndEdges("C", Arrays.asList(new Edge("B", 8), new Edge("D", 7)));
		graph.addNodeAndEdges("D", Arrays.asList(new Edge("F", 1)));
		graph.addNodeAndEdges("E", Arrays.asList(new Edge("F", 3), new Edge("D", 6)));
		graph.addNodeAndEdges("F", Arrays.asList(new Edge("F", 0)));

		String rootNodeName = "A";
		PriorityQueue<Node> nodesQueue = new PriorityQueue<>();
		Node rootNode = graph.getNode(rootNodeName);
		rootNode.setDistance(0);
		rootNode.setParentName(null);
		nodesQueue.add(rootNode);

		while (!nodesQueue.isEmpty()) {
			Node currentNode = nodesQueue.poll();
			if (currentNode.isProcessed()
					|| currentNode.getName().equals(currentNode.getEdges().first().getChildName())) {
				continue;
			}
			for (Edge currentEdge : currentNode.getEdges()) {
				Node destinationNode = graph.getNode(currentEdge.getChildName());
				int currentNodeDistance = currentNode.getDistance();
				int currentEdgeDistance = currentEdge.getDistance();
				int destinationNodeDistance = destinationNode.getDistance();
				if (currentNodeDistance + currentEdgeDistance < destinationNodeDistance) {
					destinationNodeDistance = currentNodeDistance + currentEdgeDistance;
					destinationNode.setDistance(destinationNodeDistance);
					destinationNode.setParentName(currentNode.getName());
				}
				nodesQueue.add(destinationNode);
			}
			currentNode.setProcessed(true);
		}
		System.out.println("*******************************");
		String destinationNodeName = "F";
		String path = destinationNodeName;
		Node lastNode = graph.getNode(destinationNodeName);
		int distance = lastNode.getDistance();
		while (true) {
			String previousNodeName = lastNode.getParentName();
			if (previousNodeName == null) {
				break;
			}
			path = previousNodeName + path;
			lastNode = graph.getNode(previousNodeName);

		}
		String separated = String.join("->", path.split(""));
		System.out.println(
				"The shortest distance from node " + rootNodeName + " to " + destinationNodeName + " is " + distance);
		System.out.println("Path is : " + separated);
	}

}
