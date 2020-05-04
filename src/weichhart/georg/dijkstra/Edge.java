package weichhart.georg.dijkstra;

import java.util.LinkedList;

public class Edge {

	public static final Edge NO_EDGE = new Edge();

	protected int Weight = Integer.MAX_VALUE;
	protected Node To = Node.TERMINAL_NODE;

	StringBuilder toStringBuilder(LinkedList<Node> observed) {
		//System.out.println("-E"+Weight+"-");
		StringBuilder sb = new StringBuilder( Integer.toString(Weight));
		if(getTo()!=Node.TERMINAL_NODE) {
			sb.append("->");
			sb.append(getTo().toStringBuilder(observed));
		}
		return sb;
	}
	
	public int getWeight() {
		return Weight;
	}

	public void setWeight(int weight) {
		Weight = weight;
	}

	public Node getTo() {
		return To;
	}

	public void setTo(Node to) {
		To = to;
	}

}
