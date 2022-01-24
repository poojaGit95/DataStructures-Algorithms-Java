import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Class to parse the string array list data. 
 * Its functionality is to parse array list of string data into various attributes 
 * required for creating graph like nodes, edges, leftNodes, rightNodes. 
 * It includes functions to fetch
 * nodes, edges, leftNodes, RightNodes of bipartite graph.
 * 
 * 
 * @author pooja nadagouda
 *
 */

public class DataProcessor {
	
	/*
	 * Parses array list of string data to fetch total number of nodes in bipartite graph.
	 * Access to get total number of nodes in bipartite graph.
	 * pre: allocates memory to store value of total nodes.
	 * post: returns total number of nodes.
	 */
	public int getNumberOfNodes(List<String> fileData) {
		int nodes = Integer.parseInt(fileData.get(0));
		return nodes;
	}

	
	/*
	 * Parses array list of string data to fetch total number of edges in bipartite graph.
	 * Access to get total number of edges in bipartite graph.
	 * pre: allocates memory to store value of total edges.
	 * post: returns total number of edges.
	 */
	public int getNumberOfEdges(List<String> fileData, int nodes) {
		int edges = Integer.parseInt(fileData.get(nodes + 1));
		return edges;
	}

	
	/*
	 * Parses array list of string data to list of items on left side of bipartite graph.
	 * Access to get list of left set items of bipartite graph.
	 * pre: allocates memory to store items on the left side of bipartite graph.
	 * post: returns left side items of bipartite graph
	 * 
	 */
	public List<String> getLeftItemSet(List<String> fileData, int size) {
		List<String> leftSet = new ArrayList<String>();
		for (int i = 1; i <= size / 2; i++) {
			leftSet.add(fileData.get(i));
		}
		return leftSet;
	}

	
	/*
	 * Parses array list of string data to list of items on right side of bipartite graph.
	 * Access to get list of right set items of bipartite graph.
	 * pre: allocates memory to store items on the right side of bipartite graph.
	 * post: returns right side items of bipartite graph.
	 */
	public List<String> getRightItemSet(List<String> fileData, int size) {
		List<String> rightSet = new ArrayList<String>();
		for (int i = (size / 2) + 1; i <= size; i++) {
			rightSet.add(fileData.get(i));
		}
		return rightSet;
	}

	
	/*
	 * Parses array list of string data to edges of bipartite graph.
	 * Access to get list of edges of bipartite graph. 
	 * pre: allocates memory to store all edges of each node items of bipartite graph. 
	 * It removes back or cross edges if exists. 
	 * post: returns list of edges for each node on left side
	 * of bipartite graph.
	 * 
	 */
	public ArrayList<ArrayList<Integer>> getNodeEdgesList(List<String> fileData, int nodes, int edgeSize) {

		int size = nodes / 2;

		ArrayList<ArrayList<Integer>> edges = new ArrayList<ArrayList<Integer>>();
		for (int i = 0; i < size + 1; i++)
			edges.add(new ArrayList<Integer>());

		// storing edges of each node in a list i.e., edges[1] gives list of edges from node 1.
		for (int i = nodes + 2; i < nodes + edgeSize + 2; i++) {
			String str = fileData.get(i);
			String[] edge = str.split(" ");
			int start = Integer.parseInt(edge[0]);
			int end = Integer.parseInt(edge[1]);

			// validating no cross or back edges i.e. edges should go from left items to
			// right items only.
			if (start <= size && end > size) {
				edges.get(start).add(end);
			}
		}
		return edges;

	}
	
	
}
