import java.util.*;

public class E27_Dijkstra {
	public static void main(String[] args) {
		Graph graph = new Graph(5)
			.e(0, 1, 1)
			.e(0, 2, 3)
			.e(1, 2, 1)
			.e(1, 3, 2)
			.e(2, 3, 4)
			.e(3, 4, 3);

		E27_Dijkstra dijkstra = new E27_Dijkstra(graph, 0);

		for (int i = 0; i < graph.numVertices(); i++) {
			System.out.printf("distTo(%d) = %d -> %s\n", i, (int) dijkstra.distTo(i), dijkstra.pathTo(i));

		}
	}

	private double[] distTo;
	private Graph.Edge[] edgeTo;

	public E27_Dijkstra(Graph graph, int startVertex) {
		distTo = new double[graph.numVertices()];
		edgeTo = new Graph.Edge[graph.numVertices()];

		dijkstra(graph, startVertex);
	}

	public void dijkstra(Graph graph, int startVertex) {
		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		distTo[startVertex] = 0;

		PriorityQueue<Pair<Graph.Edge, Double>> queue = new PriorityQueue<>(
			(a, b) -> Double.compare(a.right(), b.right())
		);

		for (Graph.Edge edge: graph.adjacent(startVertex)) {
			queue.add(Pair.of(edge, edge.weight()));
		}

		while (!queue.isEmpty()) {
			Pair<Graph.Edge, Double> pair = queue.remove();
			Graph.Edge edge = pair.left();
			double dist = pair.right();
			int vertex = edge.to();

			// positive infinity means node is not yet visited
			if (distTo[vertex] == Double.POSITIVE_INFINITY) {
				edgeTo[vertex] = edge;
				distTo[vertex] = dist;
				for (Graph.Edge neighbour: graph.adjacent(vertex)) {
					queue.add(Pair.of(neighbour, dist + neighbour.weight()));
				}
			}
		}
	}

	public boolean hasPathTo(int vertex) {
		return distTo[vertex] != Double.POSITIVE_INFINITY;
	}

	public double distTo(int vertex) {
		return distTo[vertex];
	}

	public ArrayList<Graph.Edge> pathTo(int vertex) {
		if (!hasPathTo(vertex)) {
			return null;
		}

		ArrayList<Graph.Edge> path = new ArrayList<>();

		while (distTo[vertex] != 0) {
			path.add(edgeTo[vertex]);
			vertex = edgeTo[vertex].from();
		}

		Collections.reverse(path);
		return path;
	}
}
