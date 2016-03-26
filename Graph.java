package mat1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Graph {
	ArrayList<Vertex> graph = new ArrayList<Vertex>();

	public Graph(String f_name) {
		read(f_name);
	}
 /**
  * @param f_name
  * read data from text file and full the data structure(graph)
  */
	public void read(String f_name) {
		try {
			FileReader fr = new FileReader(f_name);
			BufferedReader br = new BufferedReader(fr);
			String str_line;
			str_line = br.readLine();
			int num_of_Vertex = Integer.parseInt(str_line);
			str_line = br.readLine();
			int num_of_Edge = Integer.parseInt(str_line);
			// /graph = new Vertex[num_of_Vertex];
			for (int i = 0; i < num_of_Vertex; i++) {
				graph.add(new Vertex());
				graph.get(i).name = i;// ///////////////
			}
			StringTokenizer stk;
			for (int i = 0; i < num_of_Edge; i++) {
				str_line = br.readLine();
				stk = new StringTokenizer(str_line);
				int from = Integer.parseInt(stk.nextToken());
				int to = Integer.parseInt(stk.nextToken());
				double val = Double.parseDouble(stk.nextToken());
				graph.get(from).edges.add(new Edge(to, val));
			}
			br.close();
		}

		catch (IOException ex) {
			System.out.println("Error reading file\n" + ex);
			System.exit(2);
		}
	}
/*
 * return number of vertexes in current graph
 */
	public int num_of_vert() {
		return graph.size();
	}
/*
 * return number of edges in current graph
 */
	public int num_of_edges() {
		int ans = 0;
		for (int i = 0; i < graph.size(); i++) {
			ans = ans + graph.get(i).num_of_edges();
		}
		return ans;
	}
/*
 * add a new vertex to the graph
 */
	public void add(Vertex v) {
		graph.add(v);
	}

	

}
