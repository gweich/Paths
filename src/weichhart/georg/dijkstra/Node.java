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

	
	public String toString() {
		StringBuilder result = toStringBuilder(new LinkedList<Node>());
		return result.toString();
	}
	
	public StringBuilder toStringBuilder(LinkedList<Node> observed) {
		//System.out.println(id);
		StringBuilder sb = new StringBuilder(id);
		if(!observed.contains(this)) {
			observed.add(this);
			for(Edge e : getEdgesTo()) {
				if(e!=Edge.NO_EDGE)
					sb.append("-").append(e.toStringBuilder(observed));
			}
		} else 
			sb.append("|");
		return sb;
	}
	
	public String toResult() {
		StringBuilder sb = new StringBuilder( getId());
		if(getSelectedSource()!=null) {
			sb.append("-");
			sb.append(getSelectedSource().toResult());
		}
		return sb.toString();
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
