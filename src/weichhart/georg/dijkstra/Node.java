package weichhart.georg.dijkstra;

import java.util.LinkedList;

import weichhart.georg.minHeap.AbstractEdge;
import weichhart.georg.minHeap.AbstractNode;

public class Node implements AbstractNode {

	protected LinkedList<AbstractEdge> EdgesTo = new LinkedList<>();
	protected int PathValue = Integer.MAX_VALUE;
	protected AbstractNode SelectedSource = TerminalNode.TERMINAL_NODE;

	protected String id;

	public Node(String id) {
		this.id = id;
	}

	public String toString() {
		StringBuilder result = toStringBuilder(new LinkedList<AbstractNode>());
		return result.toString();
	}

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
		// System.out.println(id);
		StringBuilder sb = new StringBuilder(id);
		if (!observed.contains(this)) {
			observed.add(this);
			for (AbstractEdge e : getEdgesTo()) {
				if (e != AbstractEdge.NoEdge.NO_EDGE)
					sb.append("-").append(e.toStringBuilder(observed));
			}
		} else
			sb.append("|");
		return sb;
	}

	@Override
	public String toResult() {
		StringBuilder sb = new StringBuilder(getId());
		if (getSelectedSource() != TerminalNode.TERMINAL_NODE) {
			sb.append("-");
			sb.append(getSelectedSource().toResult());
		}
		return sb.toString();
	}

	@Override
	public LinkedList<AbstractEdge> getEdgesTo() {
		return EdgesTo;
	}

	public void setEdgesTo(LinkedList<AbstractEdge> edgesTo) {
		EdgesTo = edgesTo;
	}

	public boolean addEdgeTo(AbstractEdge to) {
		return EdgesTo.add(to);
	}

	@Override
	public String getId() {
		return id;
	}

	@Override
	public int getPathValue() {
		return PathValue;
	}

	@Override
	public void setPathValue(int pathValue) {
		PathValue = pathValue;
	}

	public AbstractNode getSelectedSource() {
		return SelectedSource;
	}

	@Override
	public void setSelectedSource(AbstractNode selectedSource) {
		SelectedSource = selectedSource;
	}

}
