import java.util.*;

public class Graph {
    public static class Edge {
            private final int from;
            private final int to;
            private final double weight;

            public Edge(int from, int to, double weight) {
                this.from = from;
                this.to = to;
                this.weight = weight;
            }

            public int from() {
                return this.from;
            }

            public int to() {
                return to;
            }

            public double weight() {
            	return weight;
            }

            @Override
            public String toString() {
            	return String.format("(%d -> %d = %.02f)", from, to, weight);
            }

            @Override
            public int hashCode() {
            	return toString().hashCode();
            }

            @Override
            public boolean equals(Object that) {
            	return toString().equals(that.toString());
            }
    }

	private ArrayList<Edge>[] xs;
	private int numEdges;

	@SuppressWarnings("unchecked")
	public Graph(int numVertices) {
		xs = (ArrayList<Edge>[]) new ArrayList[numVertices];
		numEdges = 0;

		for (int i = 0; i < xs.length; i++) {
			xs[i] = new ArrayList<>();
		}
	}

	public void addEdge(Edge edge) {
		xs[edge.from()].add(edge);
		numEdges++;
	}

	public Graph e(int f, int t, double w) {
		addEdge(new Edge(f, t, w));
		return this;
	}

	public Graph e(int f, int t) {
		e(f, t, 0.0);
		return this;
	}

	public ArrayList<Edge> adjacent(int vertex) {
		return xs[vertex];
	}

    public ArrayList<Edge> edges() {
        ArrayList<Edge> allEdges = new ArrayList<>();

        for (ArrayList<Edge> edges: xs) {
            for (Edge edge: edges) {
            	allEdges.add(edge);
            }
        }

        return allEdges;
    }

	public int numVertices() {
		return xs.length;
	}

	public int numEdges() {
		return numEdges;
	}
}
