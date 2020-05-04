package weichhart.georg.path;

public class Edge {

	public static final Edge NO_EDGE = new Edge();

	protected int Weight = Integer.MAX_VALUE;
	protected Node To = Node.TERMINAL_NODE;

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
