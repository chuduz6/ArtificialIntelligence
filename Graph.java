import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;


public class Graph<Vertex, Edge> {
		
		private Hashtable<Vertex, Hashtable<Vertex, Edge>> edge;
		
		private final List<Vertex> vertex;
		
		
		public Graph() {
			vertex = new ArrayList<Vertex>();
			edge = new Hashtable<Vertex, Hashtable<Vertex, Edge>>();
			
		}	
		
		private Hashtable<Vertex, Edge> checkNewVertex(Vertex v) {
			Hashtable<Vertex, Edge> result = edge.get(v);
			if (result == null) {
				result = new Hashtable<Vertex, Edge>();
				edge.put(v, result);
				vertex.add(v);
			}
			return result;
		}
		
		public List<Vertex> getVertex() {
			return this.vertex;
		}
		
		
		public void connectVertex(Vertex origin, Vertex destination, Edge distance) {
			Hashtable<Vertex, Edge> localEdge = checkNewVertex(origin);
			localEdge.put(destination, distance);
			checkNewVertex(destination);
		}
		
		public Hashtable<Vertex, Hashtable<Vertex, Edge>> getHash() {
			return edge;
		}
		
		public void clear() {
			edge.clear();
			vertex.clear();
		}
		
		
}
