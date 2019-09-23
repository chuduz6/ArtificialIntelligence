import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;
import java.util.Enumeration;

public class Node {

	private Object state;
	
	private Node parentNode;
	
	private Double pathCost;
	
	private int depth;
	
	private Double stepCost;
	
	
	public Node(Object state) {
		this.state = state;
		this.pathCost = new Double(0);
		this.depth = 0;
		this.stepCost = new Double(0);
	}
	
	
	public Node(Object state, Node parentNode) {
		this.state = state;
		this.pathCost = new Double(0);
		this.depth = parentNode.getDepth() + 1;
		this.stepCost = new Double(0);
		this.parentNode = parentNode;
		
	}
	
	
	public Object getState() {
		return state;
	}
	
	
	public Node getParentNode() {
		return parentNode;
	}
	
	
	public double getPathCost() {
		return pathCost.doubleValue();
	}
	
	
	public int getDepth() {
		return depth;
	}
	
	
	public double getStepCost() {
		return stepCost.doubleValue();
	}
	
	public void setStepCost(Double stepCost) {
		this.stepCost = stepCost;
	}
	
	
	public void addToPathCost(Double stepCost) {
		this.pathCost = new Double(parentNode.pathCost.doubleValue() + stepCost.doubleValue());
	}
	
	public boolean isRootNode() {
		return parentNode == null;
	}
	
	
	public List<Node> getPathFromRoot() {
		Node current = this;
		LinkedList<Node> list = new LinkedList<Node>();
		while (!current.isRootNode()) {
			list.addFirst(current);
			current = current.getParentNode();
		}
		list.addFirst(current);
		return list;
	}
	
	public static List<Node> expand(Node node, Problem problem, Map map) {
		List<Node> nodes = new ArrayList<Node>();
		Enumeration<String> keys = map.getMap().get(node.getState()).keys();
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();
			double distance = map.getMap().get(node.getState()).get(key);
			Node child = new Node(key, node);
			child.setStepCost(distance);
			child.addToPathCost(distance);
			nodes.add(child);
		}
		return nodes;
	
	}	
}
