import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

/**
 * A search algorithm that can find route between any two cities
 * 
 * Compilation: javac *.java
 * Execution:   java find_route input_filename origin_city destination_city 
 * 
 * @author Hoang Dat Kieu
 *
 */

public class find_route {
	

	private static Scanner fileInput;
	
	private static Scanner argInput;
	
	
	public static void main(String args[]) {
		
		String inputLine, fileName;
		String origin, destination;		
		String cityFrom, cityTo;		
		double distance;		
		Map map = new Map();		
		Problem problem = new Problem();		
		argInput = new Scanner(System.in);		
		fileName = args[0];
		origin=args[1];
		destination=args[2];
		problem.setInitialState(origin);
		problem.setGoalState(destination);
		
		try {
			fileInput = new Scanner(new File(fileName));
		} catch (FileNotFoundException e) {
			fileInput = null;
			System.out.println("The file not found!");
		}
		
		
		try {
			while (fileInput.hasNextLine()) {
				inputLine = fileInput.nextLine();
				if (!inputLine.equals("END OF INPUT") && !inputLine.equals("")) {
					String[] line = inputLine.split(" ");
					cityFrom = line[0];
					cityTo = line[1];
					distance = Double.valueOf(line[2]);
					map.connectGraph(cityFrom, cityTo, distance);
				}
			}
		} catch (RuntimeException e) {
			System.out.println("Runtime Exception");
		}
		
		fileInput.close();			
		
		
		UniformCostSearch ucs = new UniformCostSearch();
		
		boolean hasOrigin = false, hasDestination = false;
		for (int i = 0; i < map.getLocations().size(); i++) {
			if (problem.getInitialState().equals(map.getLocations().get(i))) {
				hasOrigin = true;
			}
			
			if (problem.getGoalState().equals(map.getLocations().get(i))) {
				hasDestination = true;
			}
		}
		if (hasOrigin == false || hasDestination == false) {
			if(hasOrigin==false)
			{
				System.out.println("Error! Origin city is not on map");

			}
			else
			{
				System.out.println("Error! Destination city is not on map");
			}
		} 
		else 
		{
			List<Node> path = ucs.execute(problem, map);
			if (path.size() == 0) {
				System.out.println("Distance: infinity");
				System.out.println("Route: ");
				System.out.println("None");
			} 
			else 
			{
				System.out.println("Distance: " + path.get(path.size() - 1).getPathCost() + " km");
				System.out.println("Route: ");
				for (int i = 0; i < path.size(); i++) {
					if (path.get(i).getPathCost() != 0) {
						System.out.println(path.get(i).getParentNode().getState() + " to " + path.get(i).getState() + ", " + path.get(i).getStepCost() + " km");
					}
				}
			}			
		}
	}
	
}