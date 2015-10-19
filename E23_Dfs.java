import java.util.*;
import java.util.function.*;

public class E23_Dfs {
	public static void main(String[] args) {
		Graph graph = new Graph(5).e(0, 1).e(0, 2).e(1, 3).e(2, 4);
		ArrayList<Integer> exp = new ArrayList<>(Arrays.asList(0, 1, 3, 2, 4));

		ArrayList<Integer> act = new ArrayList<>();
		dfs(graph, 0, act::add);
		System.out.println(act.equals(exp));
	}


	public static void dfs(Graph graph, int vertex, Consumer<Integer> visitor) {
		dfs(graph, vertex, visitor, new boolean[graph.numVertices()]);
	}

	private static void dfs(Graph graph, int vertex, Consumer<Integer> visitor, boolean[] visited) {
		visitor.accept(vertex);
		visited[vertex] = true;

		for (Graph.Edge edge: graph.adjacent(vertex)) {
			int neighbour = edge.to();
			if (!visited[neighbour]) {
				dfs(graph, neighbour, visitor, visited);
			}
		}
	}
}
