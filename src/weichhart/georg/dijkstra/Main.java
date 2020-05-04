package weichhart.georg.dijkstra;

public class Main {

	public static void main(String[] args) {

		// input
				Node n01 = new Node("0:1");
				// output
				Node n31 = new Node("3:1");
				// transport
				Node n11 = new Node("1:1");
				Node n21 = new Node("2:1");
				// plotter
				Node n10 = new Node("1:0");
				Node n20 = new Node("2:0");
				Node n12 = new Node("1:2");
				Node n22 = new Node("2:2");
				
				// input
				Edge e = new Edge();
				e.setWeight(1);
				e.setTo(n11);
				n01.addEdgeTo(e);
				
				// output
				e = new Edge();
				e.setWeight(1);
				e.setTo(n21);
				n31.addEdgeTo(e);

				
				// transport 1
				e = new Edge();
				e.setWeight(1);
				e.setTo(n01);
				n11.addEdgeTo(e);
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
				e.setTo(n21);
				n11.addEdgeTo(e);
				
				//transport 2
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
				e.setTo(n11);
				n21.addEdgeTo(e);
				e = new Edge();
				e.setWeight(1);
				e.setTo(n31);
				n21.addEdgeTo(e);
				
				// plotter 1
				e = new Edge();
				e.setWeight(1);
				e.setTo(n11);
				n10.addEdgeTo(e);

				// plotter 3
				e = new Edge();
				e.setWeight(1);
				e.setTo(n11);
				n12.addEdgeTo(e);

				
				//plotter 2
				e = new Edge();
				e.setWeight(1);
				e.setTo(n21);
				n20.addEdgeTo(e);

				//plotter 4
				e = new Edge();
				e.setWeight(1);
				e.setTo(n21);
				n22.addEdgeTo(e);

				
				Dijkstra.TransportPaths = n01;
				
				System.gc();
			    Runtime rt = Runtime.getRuntime();
			    long startM = (rt.totalMemory() - rt.freeMemory());
			    long startT = System.currentTimeMillis();
			    
				Node path = Dijkstra.searchGraph(Dijkstra.TransportPaths, n01.getId(), n22.getId());
				
			    long endT = System.currentTimeMillis();
			    long endM = (rt.totalMemory() - rt.freeMemory()) ;
				System.out.println(path.toString());
				System.out.println ("Mem / Time used: " + (endM-startM) + "B " + (endT-startT) + "ms");

	}

}
