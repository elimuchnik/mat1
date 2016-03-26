package mat1;

public class Edge {
	int vertex;
	double weight;

	public Edge(int a, double b) {
		vertex = a;
		weight = b;
	}

	public Edge(Edge e) {
		vertex = e.vertex;
		weight = e.weight;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
