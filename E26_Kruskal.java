import java.util.*;

public class E26_Kruskal {
	public static void main(String[] args) {
		Graph graph = new Graph(4)
			.e(0, 2, 3)
			.e(0, 3, 0)
			.e(1, 0, 4)
			.e(3, 2, 1)
			.e(3, 1, 2);

		Set<Graph.Edge> mst = new HashSet<>(mst(graph));
		Set<Graph.Edge> exp = new HashSet<>(
			Arrays.asList(
				new Graph.Edge(0, 3, 0),
				new Graph.Edge(3, 2, 1),
				new Graph.Edge(3, 1, 2)
			)
		);

		System.out.println(mst.equals(exp));
	}

	public static ArrayList<Graph.Edge> mst(Graph graph) {
		ArrayList<Graph.Edge> edges = graph.edges();
		Collections.sort(edges, (a, b) -> Double.compare(a.weight(), b.weight()));
		E25_UnionFind uf = new E25_UnionFind(graph.numVertices());

		ArrayList<Graph.Edge> mst = new ArrayList<Graph.Edge>();

		for (Graph.Edge edge: edges) {
			int vertexA = edge.from();
			int vertexB = edge.to();

			if (!uf.connected(vertexA, vertexB)) {
				mst.add(edge);
				uf.union(vertexA, vertexB);
				if (mst.size() == graph.numVertices() - 1) {
					return mst;
				}	
			}
		}

		return null;
	}
}
