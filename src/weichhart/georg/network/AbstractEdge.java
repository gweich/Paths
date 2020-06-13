package weichhart.georg.network;

import java.util.List;

public class AbstractEdge {
	public static final AbstractEdge NO_EDGE = new AbstractEdge();
	
	protected AbstractEdge() {
	}

	public AbstractNode getTo() {
		return AbstractNode.TERMINAL_NODE;
	}

	public int getWeight() {
		return Integer.MIN_VALUE;
	}

	public StringBuilder toStringBuilder(List<AbstractNode> observed, StringBuilder sb) {
		sb.append('x');
		return sb;
	}
}
