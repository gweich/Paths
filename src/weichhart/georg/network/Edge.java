package weichhart.georg.network;

import java.util.List;

public class Edge extends AbstractEdge {

	protected int Weight = Integer.MAX_VALUE;
	protected AbstractNode To = AbstractNode.TERMINAL_NODE;

	public StringBuilder toStringBuilder(List<AbstractNode> observed, StringBuilder sb) {
		// System.out.println("-E"+Weight+"-");
		if(sb==null)
			sb = new StringBuilder();
		sb.append(Integer.toString(Weight)).append("->");
		getTo().toStringBuilder(observed,sb);
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
