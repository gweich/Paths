package weichhart.georg.dijkstra;

import weichhart.georg.minHeap.MinHeap;
import weichhart.georg.network.AbstractEdge;
import weichhart.georg.network.AbstractNode;

public class Dijkstra {

	// global variable with the possible transport ways.
	public static AbstractNode TransportPaths = null;

	public static AbstractNode findNode(AbstractNode network, String id) {
		if (network.getId().equals(id))
			return network;
		for (AbstractEdge e : network.getEdgesTo()) {
			AbstractNode nxt = findNode(e.getTo(), id);
			if (nxt != null)
				return nxt;
		}
		return null;
	}

	public static AbstractNode searchGraph(AbstractNode network, String startnodeid, String endnodeid) {
		return searchGraph(findNode(network, startnodeid), endnodeid);
	}

	public static AbstractNode searchGraph(AbstractNode startnode, String endnodeid) {
		initialize(startnode);
		// all but first node have MAX distance
		startnode.setPathValue(0);

		return expand(startnode, endnodeid);
	}

	public static void initialize(AbstractNode startnode) {
		startnode.setPathValue(Integer.MAX_VALUE);
		for (AbstractEdge nxt : startnode.getEdgesTo()) {
			if (nxt.getTo().getPathValue() != Integer.MAX_VALUE)
				initialize(nxt.getTo());
		}
	}

	public static AbstractNode expand(AbstractNode gr, String endnodeid) {
		MinHeap priorityQ = new MinHeap();
		priorityQ.addNodes(gr); // all nodes in graph

		while (!priorityQ.isEmpty()) {
			AbstractNode current = priorityQ.extractMin();
			if (current.getId().equals(endnodeid))
				return current;
			for (AbstractEdge nxt : current.getEdgesTo()) {
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
