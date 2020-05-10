package weichhart.georg.dijkstra;

import java.util.ArrayList;

import weichhart.georg.network.AbstractNode;
import weichhart.georg.network.Edge;
import weichhart.georg.network.Node;

public class Main {

	// nr of nodes
	static int nodescount = 100;
	// 1-x edges
	static int edgecount = 3;
	
	public static void main(String[] args) {

		ArrayList<Node> nodes = new ArrayList<>(nodescount);
		for(int i=0; i<nodescount; ++i) {
			nodes.add(i, new Node("N"+i));
		}
		for(int i = 0;i<nodes.size();++i) {
			// 1-4 Edges per Node
			for( int e = ((int)((Math.random() * 100.0) % edgecount))+1; e>=0; --e ) {
				Edge edge = new Edge();
				edge.setWeight((int)(Math.random() * 30.0) + 1 );
				edge.setTo(nodes.get((int)(Math.random() * nodescount)));
				nodes.get((int)(Math.random() * nodescount)).addEdgeTo(edge);
			}
		}

		System.gc();
		Runtime rt = Runtime.getRuntime();
		long startM = (rt.totalMemory() - rt.freeMemory());
		long startT = System.currentTimeMillis();

		// start at 0
		Dijkstra.TransportPaths = nodes.get(0);
		AbstractNode path = Dijkstra.searchGraph(Dijkstra.TransportPaths, nodes.get(nodes.size()-1));

		long endT = System.currentTimeMillis();
		long endM = (rt.totalMemory() - rt.freeMemory());
		if(path!=null) {
			System.out.println(path.toString());
			System.out.println(path.toResult());
		} else {
			System.err.println("Dijkstra.searchGraph == null");
		}
		System.out.println("Mem / Time used: " + (endM - startM) + "B " + (endT - startT) + "ms");

	}

}
