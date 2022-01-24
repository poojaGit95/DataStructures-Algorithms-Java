import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 
 * Class to create residual graph from file data.
 * Functionality is to create a residual graph with left set and right set 
 * of nodes along with source and sink nodes.
 * Returns a residual graph with source and sink nodes in the form of adjacency list.
 * 
 * @author pooja nadagouda
 *
 */
public class ResidualGraph {

	/*
	 * Creates an adjacency list  to store bipartite graph nodes, edges, along with source and sink nodes & edges.
	 * pre: allocates memory for all nodes and edges of each node of flow graph.
	 * post: returns a residual graph of Linked_List(Linked_List).
	 * 
	 */
	public LinkedList<LinkedList<Integer>> createAdjacencyListGraph(int nodes, ArrayList<ArrayList<Integer>> edgesList) {

		// adding sink and source nodes, hence size is (nodes+2)
		LinkedList<LinkedList<Integer>> residualGraph = new LinkedList<LinkedList<Integer>>();
		int source = 0;
		int sink = nodes+1;
		int size = nodes+2;
		
		for (int i = 0; i < size; i++) {
			residualGraph.add(new LinkedList<Integer>());
		}
		
		// adding edges from source to left node items.
		for (int i = 1; i < size / 2; i++) {
			residualGraph.get(source).add(i);
		}

		// adding edges listed in file data to graph i.e., adding edges from left nodes set to right nodes set.
		int k = 1;
		for (int node = 1; node < edgesList.size(); node++) {
			residualGraph.get(k).addAll(edgesList.get(node));
			k++;
		}

		// adding edges from right node items to sink.
		int start = size / 2;
		int end = size - 1;
		for (int i = start; i < end; i++) {
			residualGraph.get(i).add(sink);
		}

		return residualGraph;
	}
	

}
