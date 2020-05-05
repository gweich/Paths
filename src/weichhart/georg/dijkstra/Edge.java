package weichhart.georg.dijkstra;

import java.util.LinkedList;

import weichhart.georg.minHeap.AbstractEdge;
import weichhart.georg.minHeap.AbstractNode;
import weichhart.georg.minHeap.AbstractNode.TerminalNode;

public class Edge implements AbstractEdge {

	protected int Weight = Integer.MAX_VALUE;
	protected AbstractNode To = TerminalNode.TERMINAL_NODE;

	public StringBuilder toStringBuilder(LinkedList<AbstractNode> observed) {
		// System.out.println("-E"+Weight+"-");
		StringBuilder sb = new StringBuilder(Integer.toString(Weight));
		if (getTo() != TerminalNode.TERMINAL_NODE) {
			sb.append("->");
			sb.append(getTo().toStringBuilder(observed));
		}
		return sb;
	}

	@Override
	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	@Override
	public AbstractNode getTo() {
		return To;
	}

	public void setTo(Node to) {
		To = to;
	}

}
