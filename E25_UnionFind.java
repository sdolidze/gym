import java.util.*;

public class E25_UnionFind {
	public static void main(String[] args) {
		E25_UnionFind uf = new E25_UnionFind(4);
		System.out.println(!uf.connected(0, 3));
		uf.union(0, 3);
		System.out.println(uf.connected(0, 3));
		System.out.println(!uf.connected(2, 3));
		uf.union(0, 2);
		System.out.println(uf.connected(2, 3));
		System.out.println(!uf.connected(1, 3));
	}

	private int[] xs;

	// weighted quick union with path compression is the best (not this one)
	public E25_UnionFind(int size) {
		xs = new int[size];

		for (int i = 0; i < xs.length; i++) {
			xs[i] = i;
		}
	}

	public void union(int a, int b) {
		int colorA = xs[a];
		int colorB = xs[b];
		
		for (int i = 0; i < xs.length; i++) {
			if (xs[i] == colorB) {
				xs[i] = colorA;
			}
		}
	}

	public boolean connected(int a, int b) {
		return xs[a] == xs[b];
	}

	public int size() {
		return xs.length;
	}
}
