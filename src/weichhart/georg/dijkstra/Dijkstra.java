package weichhart.georg.path;

public class Dijkstra {

	// global variable with the possible transport ways.
	public static Node TransportPaths = null;
	
	public static Node findNode(Node network, String id) {
		if(network.id.equals(id))
			return network;
		for(Edge e : network.getEdgesTo()) {
			Node nxt = findNode(e.To,id);
			if(nxt != null) 
				return nxt;
		}
		return null;
	}
	
	public static Node searchGraph(Node network, String startnodeid, String endnodeid) {
		return searchGraph(findNode(network, startnodeid), endnodeid);
	}
	
	public static Node searchGraph(Node startnode, String endnodeid) {
		initialize(startnode);
		// all but first node have MAX distance
		startnode.setPathValue(0);

		return expand(startnode, endnodeid);
	}

	public static void initialize(Node startnode) {
		startnode.PathValue = Integer.MAX_VALUE;
		for (Edge nxt : startnode.getEdgesTo()) {
			if(nxt.getTo().PathValue != Integer.MAX_VALUE)
				initialize(nxt.getTo());
		}
	}

	public static Node expand(Node gr, String endnodeid) {
		MinHeap priorityQ = new MinHeap();
		priorityQ.addNodes(gr); // all nodes in graph

		while (!priorityQ.isEmpty()) {
			Node current = priorityQ.extractMin();
			if(current.id.equals(endnodeid))
				return current;
			for (Edge nxt : current.getEdgesTo()) {
				if (nxt.getTo().getPathValue() > (current.getPathValue() + nxt.getWeight())) {
					nxt.getTo().setSelectedSource(current);
					nxt.getTo().setPathValue(current.getPathValue() + nxt.getWeight());
					priorityQ.update(nxt.getTo());
				}
			}
		}
		return null;
	}

}
