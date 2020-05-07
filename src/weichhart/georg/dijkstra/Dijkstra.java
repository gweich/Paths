package weichhart.georg.dijkstra;

import weichhart.georg.minHeap.MinHeap;
import weichhart.georg.network.AbstractEdge;
import weichhart.georg.network.AbstractNode;
import weichhart.georg.network.Node;

/**
 * 
 * https://en.wikipedia.org/wiki/Dijkstra%27s_algorithm
 * Dijkstra's algorithm uses a data structure for storing and querying partial solutions sorted by distance from the start. 
 * While the original algorithm uses a min-priority queue and runs in time O(|V|+|E| log |V|) (where |V| is the number of nodes and 
 * |E| is the number of edges), it can also be implemented in O(V^2) using an array.
 * 
 * 
 * 
 * @author gweich
 *
 */
public class Dijkstra {

	// global variable with the possible transport ways.
	public static Node TransportPaths = null;

	public static Node findNode(Node network, String id) {
		if (network.getId().equals(id))
			return network;
		for (AbstractEdge e : network.getEdges()) {
			Node nxt = findNode((Node) e.getTo(), id);
			if (nxt != null)
				return nxt;
		}
		return null;
	}

	public static AbstractNode searchGraph(Node network, String startnodeid, String endnodeid) {
		return searchGraph(findNode(network, startnodeid), findNode(network, endnodeid));
	}

	public static AbstractNode searchGraph(Node startnode, Node endnode) {
		initialize(startnode);
		// all but first node have MAX distance
		startnode.setPathValue(0);

		return expand(startnode, endnode);
	}

	public static void initialize(Node startnode) {
		startnode.setPathValue(Integer.MAX_VALUE);
		startnode.setSelectedSource(AbstractNode.TERMINAL_NODE);
		for (AbstractEdge nxt : startnode.getEdges()) {
			if (nxt.getTo().getPathValue() != Integer.MAX_VALUE)
				initialize((Node) nxt.getTo());
		}
	}

	public static AbstractNode expand(Node gr, Node endnode) {
		MinHeap priorityQ = new MinHeap();
		priorityQ.addAllNodes(gr); // all nodes in graph

		while (!priorityQ.isEmpty()) {
			AbstractNode current = priorityQ.extractMin();
			if (current != AbstractNode.TERMINAL_NODE) {
				if (current == endnode)
					return current;
				for (AbstractEdge nxt : current.getEdges()) {
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
