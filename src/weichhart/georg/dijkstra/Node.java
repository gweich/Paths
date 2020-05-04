package weichhart.georg.dijkstra;

import java.util.LinkedList;

public class Node {

	public static final Node TERMINAL_NODE = new Node("!");

	protected LinkedList<Edge> EdgesTo = new LinkedList<Edge>();
	protected int PathValue = Integer.MAX_VALUE;
	protected Node SelectedSource = Node.TERMINAL_NODE;
	
	protected String id; 
	
	public Node(String id) {
		this.id = id;
	}

	public LinkedList<Edge> getEdgesTo() {
		return EdgesTo;
	}

	public void setEdgesTo(LinkedList<Edge> edgesTo) {
		EdgesTo = edgesTo;
	}
	
	public boolean addEdgeTo(Edge to) {
		return EdgesTo.add(to);
	}
	
	public String getId() {
		return id;
	}

	public int getPathValue() {
		return PathValue;
	}

	public void setPathValue(int pathValue) {
		PathValue = pathValue;
	}

	public Node getSelectedSource() {
		return SelectedSource;
	}

	public void setSelectedSource(Node selectedSource) {
		SelectedSource = selectedSource;
	}

}
