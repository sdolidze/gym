import java.util.*;
import java.util.function.*;

public class E24_Bfs {
	public static void main(String[] args) {
		Graph graph = new Graph(5).e(0, 1).e(0, 2).e(2, 4).e(1, 3).e(1, 3).e(3, 4);
		E24_Bfs bfs = new E24_Bfs(graph, 0);

		ArrayList<Integer> path = new ArrayList<>(Arrays.asList(0, 2));
		System.out.println(bfs.pathTo(4).equals(path));
	}

	private int[] distTo;
	private int[] edgeTo;
	private boolean[] visited;

	public E24_Bfs(Graph graph, int startVertex) {
		distTo = new int[graph.numVertices()];
		edgeTo = new int[graph.numVertices()];
		visited = new boolean[graph.numVertices()];

		bfs(graph, startVertex);
	}

	private void bfs(Graph graph, int startVertex) {
		Queue<Integer> queue = new LinkedList<>();

		distTo[startVertex] = 0;
		edgeTo[startVertex] = startVertex; // self loop
		visited[startVertex] = true;
		queue.add(startVertex);

		while (!queue.isEmpty()) {
			int vertex = queue.remove();

			for (Graph.Edge edge: graph.adjacent(vertex)) {
				int neighbour = edge.to();
				if (!visited[neighbour]) {
					distTo[neighbour] = distTo[vertex] + 1;
					edgeTo[neighbour] = vertex;
					visited[neighbour] = true;
					queue.add(neighbour);
				}
			}
		}
	}

	public int distTo(int vertex) {
		return distTo[vertex];
	}

	public boolean hasPathTo(int vertex) {
		return visited[vertex];
	}

	public ArrayList<Integer> pathTo(int vertex) {
		if (!hasPathTo(vertex)) {
			return null;
		}

		ArrayList<Integer> path = new ArrayList<>();

		while (edgeTo[vertex] != vertex) {
			path.add(edgeTo[vertex]);
			vertex = edgeTo[vertex];
		}

		Collections.reverse(path);
		// returns list of nodes [start, end), length of list is same as distTo
		return path;
	}
}
