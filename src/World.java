import java.util.*;



public class World {

	
	Set <String> robotNames = new TreeSet<String>();
	List <Robot> robots = new ArrayList<Robot>();
	List <String[]> directions = new LinkedList<String[]>();
	
	//global time for the world, 
	int time = 0;

	//don't use this really but spec states it is given to program
	int numberOfButtons;
	
	
	//Constructor, runs world on instantiation, could have it in a init or something
	public World (String passedDirections){
		
		//take the first character of directions which states how many buttons are to be pressed
		numberOfButtons = Integer.parseInt(passedDirections.trim().substring(0, 1));
		
		//read the directions in, exclude first character.
		readInDirections(passedDirections.trim().substring(1));
		
		//loop through building up the robots
		for(String name : robotNames){
			Robot r = new Robot(name);
			
			//pass each robot the same list of directions object
			r.setDirections(directions);
			
			//let them find their first destination
			r.findNextDestination();
			
			//add them to a collection for management
			robots.add(r);
		}
	}
	
	
	//reads in and cleans up directions, probably no need to do this in python.
	//some sort of sexy tuple parsing will be available
	private void readInDirections(String passedDirections){
		
		Scanner scanner = new Scanner(passedDirections);
		
		//no commas in spec, assuming the text is going to be properly formatted
		while(scanner.hasNext()){
			String[] lo ={scanner.next(),scanner.next()};
			directions.add(lo);		
		}
		
		//loop through the directions pulling robot names into a set
		for(String[] d : directions){
			robotNames.add(d[0]);
		}
	}
	
	
	public void start(){
		//loop through directions while there are still buttons to be pushed!
		while(!directions.isEmpty()){
			
			//increment time moving forward
			time++;

			//loop through the robots letting them know they can do an action
			for(Robot r : robots){
				r.action();
			}
		}
	}

	
	// ---- ACCESSOR ---------

	public int getTotalTime() {
		return time;
	}
	
}
