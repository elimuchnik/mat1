package mat1;

import java.util.ArrayList;

public class Vertex implements Comparable<Vertex> {
	int name;
	int prev;
	ArrayList<Edge> edges = new ArrayList<Edge>();
	double dist;
	boolean visit;

	public static final Double infin = Double.POSITIVE_INFINITY;
	public static final int nil = -1;

	public Vertex() {
		this.name = -1;
		dist = infin;
		visit = false;
		prev = -1;
	}

	public Vertex(Vertex v) {
		this.name = v.name;
		dist = v.dist;
		visit = v.visit;
		prev = v.prev;
		for (int i = 0; i < v.edges.size(); i++) {
			this.edges.add(v.edges.get(i));
		}
	}

	public void add_name(int name) {
		this.name = name;
	}

	public int num_of_edges() {
		return edges.size();
	}

	public int compareTo(Vertex v) {
		if (dist > v.dist)
			return 1;
		if (dist < v.dist)
			return -1;
		return 0;
	}

	

}
