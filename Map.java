import java.util.Hashtable;
import java.util.List;

public class Map {

	private Graph<String, Double> graph;
	
	public Map() {
		graph = new Graph<String, Double>();
	}
	
	public Hashtable<String, Hashtable<String, Double>> getMap() {
		return graph.getHash();
	}
	
	public List<String> getLocations() {
		return graph.getVertex();
	}
	
	public void connectGraph(String fromLocation, String toLocation, Double distance) {
		graph.connectVertex(toLocation, fromLocation, distance);
		graph.connectVertex(fromLocation, toLocation, distance);
	}
	
	public void clear() {
		graph.clear();
	}	
	
}