import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Class to perform bipartite matching through network flow.
 * Functionality includes constructing level graphs, bipartite matching, displaying bipartite matches.
 * It outputs the maximum matches possible and one of the matches in the bipartite graph. 
 * 
 * @author pooja nadagouda
 *
 */
public class BipartiteMatching {


	/*
	 * Performs Breadth-First Search to get level graph from current residual graph.
	 * pre: allocates memory for constructing a level graph from residual graph.
	 * post: returns level graph.
	 */
	private LinkedList<LinkedList<Integer>> BFS(LinkedList<LinkedList<Integer>> residualGraph, int source, int sink) {
		int size = residualGraph.size();
		LinkedList<LinkedList<Integer>> levelGraph = new LinkedList<LinkedList<Integer>>();

		boolean visited[] = new boolean[size];
		for (int i = 0; i < size; i++) {
			levelGraph.add(new LinkedList<Integer>());
			visited[i] = false;
		}

		Queue<Integer> queue = new LinkedList<>();
		queue.add(source);

		while (!queue.isEmpty()) {

			int node = queue.poll();
			visited[node] = true;
			
			for (int edge : residualGraph.get(node)) {
				if (!levelGraph.get(node).contains(edge) && edge!=source && visited[edge]==false) {
					levelGraph.get(node).add(edge);
				}

				if (!queue.contains(edge) && visited[edge] == false) {
					queue.add(edge);
				}
			}
		}
		
		// Return empty level graph since no path to sink.
		if (visited[sink] == false) {
			levelGraph.clear();
		}
		
		return levelGraph;
	}

	

	/*
	 * 
	 * Performs bipartite matching by computing maximum network flow from source to sink nodes.
	 * pre: allocates memory for constructing a level graph from residual graph.
	 * post: None
	 * 
	 */
	public void maxBipartiteMatching(LinkedList<LinkedList<Integer>> residualGraph, List<String> leftRightItemsSet) {
		LinkedList<Integer> path = new LinkedList<Integer>();
		int source = 0;
		int sink = residualGraph.size() - 1;
		int size = residualGraph.size();
		int[] matches = new int[size / 2];

		while (true) {

			//Constructing level graph from residual graph using breadth-first search.
			LinkedList<LinkedList<Integer>> levelGraph = BFS(residualGraph, source, sink);

			
			//If sink not found during BFS display the bipartite matchings done.
			if (levelGraph.isEmpty()) {
				printBipartiteMatches(matches, leftRightItemsSet);
				break;
			}

			//Initializing location to source node, path to empty.
			int current = source;
			path.clear();
			path.add(source);
			

			while (!levelGraph.get(source).isEmpty()) {
				if (current == sink) {
					for (int i = path.size() - 1; i > 0; i--) {
						levelGraph.get(path.get(i - 1)).remove(path.get(i));
						residualGraph.get(path.get(i - 1)).remove(Integer.valueOf(path.get(i)));
						residualGraph.get(path.get(i)).add(path.get(i - 1));

						if (path.get(i - 1) != source && path.get(i) != sink && path.get(i - 1) < size / 2
								&& path.get(i) >= size / 2) {
							matches[path.get(i - 1)] = path.get(i);
						}
					}
					path.clear();
					path.add(source);
					current = source;
				} else {
					
					// when stuck retreat i.e deleting all incoming edges 
				    // for this node which has no outgoing edges and clearing last edge in path.
					if (levelGraph.get(current).isEmpty()) {
						int end = path.removeLast();
						for (int i = 0; i < levelGraph.size(); i++) {
							if (levelGraph.get(i).contains(end)) {
								levelGraph.get(i).remove(Integer.valueOf(end));
							}
						}
						current = path.peekLast();
						
					} else {
						//Advancing along first edge in Level graph that leaves current location.
						current = levelGraph.get(current).getFirst();
						path.add(current);
					}
				}
			}
		}
	}

	
	/*
	 * Displays the maximum possible number of bipartite matches, and displays one of the possible matches.
	 * pre: None
	 * post: displays the matches formed in bipartite matching.
	 * 
	 */
	private void printBipartiteMatches(int[] matches, List<String> leftRightItemsSet) {
		int count=0;
		for (int i = 0; i < matches.length; i++) {
			if (matches[i] != 0) {
				System.out.println(leftRightItemsSet.get(i) + "/" + leftRightItemsSet.get(matches[i]));
				count++;
			}
		}
		System.out.println(count + " Total matches");
	}
	
}
