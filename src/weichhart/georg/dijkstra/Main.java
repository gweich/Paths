package weichhart.georg.dijkstra;

import weichhart.georg.network.AbstractNode;
import weichhart.georg.network.Edge;
import weichhart.georg.network.Node;

public class Main {

	public static void main(String[] args) {

		// first
		Node n01 = new Node("0:1");
		// last
		Node n31 = new Node("3:1");

		Node n11 = new Node("1:1");
		Node n21 = new Node("2:1");
		Node n10 = new Node("1:0");
		Node n20 = new Node("2:0");
		Node n12 = new Node("1:2");
		Node n22 = new Node("2:2");

		// start
		Edge e = new Edge();
		e.setWeight(1);
		e.setTo(n11);
		n01.addEdgeTo(e);
		// back
//		e = new Edge();
//		e.setWeight(1);
//		e.setTo(n01);
//		n11.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n10);
		n11.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n12);
		n11.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n20);
		n21.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n22);
		n21.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n31);
		n21.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n11);
		n10.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n20);
		n10.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n10);
		n20.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n11);
		n12.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n22);
		n12.addEdgeTo(e);
		e = new Edge();
		e.setWeight(1);
		e.setTo(n12);
		n22.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n21);
		n20.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n21);
		n22.addEdgeTo(e);

		e = new Edge();
		e.setWeight(1);
		e.setTo(n21);
		n31.addEdgeTo(e);

		Dijkstra.TransportPaths = n01;

		System.gc();
		Runtime rt = Runtime.getRuntime();
		long startM = (rt.totalMemory() - rt.freeMemory());
		long startT = System.currentTimeMillis();

		AbstractNode path = Dijkstra.searchGraph(Dijkstra.TransportPaths, n01.getId(), n31.getId());

		long endT = System.currentTimeMillis();
		long endM = (rt.totalMemory() - rt.freeMemory());
		System.out.println(path.toString());
		System.out.println(path.toResult());
		System.out.println("Mem / Time used: " + (endM - startM) + "B " + (endT - startT) + "ms");

	}

}
