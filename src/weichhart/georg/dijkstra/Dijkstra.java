package weichhart.georg.dijkstra;

import weichhart.georg.minHeap.MinHeap;
import weichhart.georg.network.AbstractEdge;
import weichhart.georg.network.AbstractNode;
import weichhart.georg.network.Node;

public class Dijkstra {

	// global variable with the possible transport ways.
	public static Node TransportPaths = null;

	public static Node findNode(Node network, String id) {
		if (network.getId().equals(id))
			return network;
		for (AbstractEdge e : network.getEdgesTo()) {
			Node nxt = findNode((Node) e.getTo(), id);
			if (nxt != null)
				return nxt;
		}
		return null;
	}

	public static AbstractNode searchGraph(Node network, String startnodeid, String endnodeid) {
		return searchGraph(findNode(network, startnodeid), endnodeid);
	}

	public static AbstractNode searchGraph(Node startnode, String endnodeid) {
		initialize(startnode);
		// all but first node have MAX distance
		startnode.setPathValue(0);

		return expand(startnode, endnodeid);
	}

	public static void initialize(Node startnode) {
		startnode.setPathValue(Integer.MAX_VALUE);
		for (AbstractEdge nxt : startnode.getEdgesTo()) {
			if (nxt.getTo().getPathValue() != Integer.MAX_VALUE)
				initialize((Node) nxt.getTo());
		}
	}

	public static AbstractNode expand(Node gr, String endnodeid) {
		MinHeap priorityQ = new MinHeap();
		priorityQ.addNodes(gr); // all nodes in graph

		while (!priorityQ.isEmpty()) {
			AbstractNode current = priorityQ.extractMin();
			if (current != AbstractNode.TERMINAL_NODE) {
				if (current.getId().equals(endnodeid))
					return current;
				for (AbstractEdge nxt : current.getEdgesTo()) {
					if (nxt.getTo().getPathValue() > (current.getPathValue() + nxt.getWeight())) {
						((Node) nxt.getTo()).setSelectedSource(current);
						((Node) nxt.getTo()).setPathValue(current.getPathValue() + nxt.getWeight());
						priorityQ.update((Node) nxt.getTo());
					}
				}
			}
		}
		return null;
	}

}
