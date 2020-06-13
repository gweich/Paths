package weichhart.georg.network;

import java.util.LinkedList;

public class Node extends AbstractNode {

	protected AbstractNode SelectedSource = TERMINAL_NODE;

	protected String id = "!";

	protected int PathValue = Integer.MAX_VALUE;

	public Node(String id) {
		this.id = id;
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public int getPathValue() {
		return PathValue;
	}

	public void setPathValue(int pathValue) {
		PathValue = pathValue;
	}

	public void setEdgesTo(LinkedList<AbstractEdge> edgesTo) {
		EdgesTo = edgesTo;
	}

	public boolean addEdgeTo(AbstractEdge to) {
		return EdgesTo.add(to);
	}

	public AbstractNode getSelectedSource() {
		return SelectedSource;
	}

	public void setSelectedSource(AbstractNode selectedSource) {
		SelectedSource = selectedSource;
	}

	public String toResult() {
		StringBuilder sb = new StringBuilder(getId());
		if (getSelectedSource() != TERMINAL_NODE) {
			sb.append("-");
			for(AbstractEdge e : getSelectedSource().EdgesTo) {
				if(e.getTo().equals(this))
					sb.append(e.getWeight());
			}
			sb.append("->");
			sb.append(((Node) getSelectedSource()).toResult());
		}
		return sb.toString();
	}

}
