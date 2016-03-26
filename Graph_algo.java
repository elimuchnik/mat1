package mat1;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Graph_algo {
	Graph g;

	public Graph_algo(String f_name) {
		g = new Graph(f_name);
	}
/*
 * DiJkstra algorithm
 * this algorithm calculating distance of each vertex in the graph to 
 * the start vertex
 */
	private Vertex[] DiJkstra(ArrayList<Vertex> ver, int num) {
		Vertex ver1[] = new Vertex[ver.size()];
		for (int i = 0; i < ver1.length; i++) {
			ver1[i] = new Vertex(ver.get(i));
		}
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		Vertex start = ver1[num];//
		q.add(start);
		start.dist = 0;
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			for (int i = 0; i < u.edges.size(); i++) {
				Edge e = u.edges.get(i);
				Vertex v = ver1[e.vertex];//
				if (!v.visit) {
					if (v.dist > u.dist + e.weight) {
						v.dist = u.dist + e.weight;
						v.prev = ver1[u.name].name;//
						q.remove(v);
						q.add(v);
					}
				}
			}
			u.visit = true;
		}
		return ver1;
	}
	/*
	 * DiJkstra algorithm(overloading)
	 * like a first algorithm,but this one refers to "black list" of vertexes
	 */
	private Vertex[] DiJkstra(ArrayList<Vertex> ver, int num, int arr[]) {
		Vertex ver1[] = new Vertex[ver.size()];
		for (int i = 0; i < ver1.length; i++) {
			ver1[i] = new Vertex(ver.get(i));
		}
		for (int i = 0; i < arr.length; i++) {
			ver1[arr[i]].visit = true;
		}
		PriorityQueue<Vertex> q = new PriorityQueue<Vertex>();
		Vertex start = ver1[num];//
		q.add(start);
		start.dist = 0;
		while (!q.isEmpty()) {
			Vertex u = q.poll();
			for (int i = 0; i < u.edges.size(); i++) {
				Edge e = u.edges.get(i);
				Vertex v = ver1[e.vertex];//
				if (!v.visit) {
					if (v.dist > u.dist + e.weight) {
						v.dist = u.dist + e.weight;
						v.prev = ver1[u.name].name;//
						q.remove(v);
						q.add(v);
					}
				}
			}
			u.visit = true;
		}
		return ver1;
	}
/*
 * return distance between two vertexes
 */
	public double distanse(int a, int b) {

		Vertex v[] = DiJkstra(g.graph, a);
		return v[b].dist;
	}
/*
 * return distance between two vertexes,refers to "black list" (arr)
 */
	public double distanse(int a, int b, int arr[]) {

		Vertex v[] = DiJkstra(g.graph, a, arr);
		if (v[b].dist == Double.POSITIVE_INFINITY)
			return -1;
		return v[b].dist;
	}
/*
 * return the path between two vertexes
 */
	public String getTrack(int start, int end) {
		Vertex v[] = DiJkstra(g.graph, start);
		String ans = "";
		if (v[end].dist == Double.POSITIVE_INFINITY)
			return "no track";
		while (v[end].dist != 0) {
			ans = end + "-->" + ans;
			end = v[end].prev;
		}
		ans = start + "-->" + ans;
		return ans;

	}
	/*
	 * return the path between two vertexes,refers to "black list" (arr)
	 */
	public String getTrack(int start, int end, int[] arr) {
		Vertex v[] = DiJkstra(g.graph, start, arr);
		String ans = "";
		if (v[end].dist == Double.POSITIVE_INFINITY)
			return "no track";
		while (v[end].dist != 0) {
			ans = end + "-->" + ans;
			end = v[end].prev;
		}
		ans = start + "-->" + ans;
		return ans;

	}

	

}
