package main;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.SortedSet;
import java.util.TreeSet;

public class Graph {

	private Map<String, Node> graph;
	
	public Graph() {
		this.graph = new HashMap<>();
	}

	public Map<String, Node> getGraph() {
		return graph;
	}

	public void setGraph(Map<String, Node> graph) {
		this.graph = graph;
	}
	
	public void addNodeAndEdges(String nodeName, List<Edge> edges) {
		SortedSet<Edge> set = new TreeSet<>(edges);
		getGraph().put(nodeName, new Node(nodeName, set));
	}
	 
	public Node getNode(String name) {
		return getGraph().get(name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(graph);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Graph other = (Graph) obj;
		return Objects.equals(graph, other.graph);
	}

	@Override
	public String toString() {
		return "Graph [graph=" + graph + "]";
	}

}
