import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Class to represent main method. .
 * Functionality is to start of execution of main method. 
 * 
 * @author pooja nadagouda
 *
 */

public class Main {

	/* 
	 * Main class to begin execution.
	 * pre: allocates memory for list left items, right items of bipartite graph, 2D matrix for flow graph.
	 * post: None
	 * 
	 */
	public static void main(String[] args) {
		
		// Reading data from file
		FileParser file = new FileParser();
		List<String> fileData = file
				.readDataFromFile("program3data.txt");
		

		// Parsing the string file data into graph attributes.
		DataProcessor dataProcessor = new DataProcessor();
		int nodes = dataProcessor.getNumberOfNodes(fileData);
		int edgeSize = dataProcessor.getNumberOfEdges(fileData, nodes);
		ArrayList<ArrayList<Integer>> edges = dataProcessor.getNodeEdgesList(fileData, nodes, edgeSize);
		
		
		// adding the left and right nodes to a list w.r.t their numbering i.e., 
		// 1st left element = 1, so on till last node on right = number of nodes.
		// Hence adding zero at the start to match the numbering
		List<String> leftRightItemsSet = new ArrayList<String>();
		leftRightItemsSet.add("0");
		leftRightItemsSet.addAll(dataProcessor.getLeftItemSet(fileData, nodes));
		leftRightItemsSet.addAll(dataProcessor.getRightItemSet(fileData, nodes));
		

		// Creating residual graph by adding source, sink nodes & edges.
		ResidualGraph graph = new ResidualGraph();
		LinkedList<LinkedList<Integer>> residualGraph = graph.createAdjacencyListGraph(nodes, edges);
		
		
		
		// Computing maximum network flow for this graph to max get bipartite matches.
		BipartiteMatching bipartiteMatching_new = new BipartiteMatching();
		bipartiteMatching_new.maxBipartiteMatching(residualGraph, leftRightItemsSet);
	}

}
