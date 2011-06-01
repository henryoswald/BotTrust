import java.util.*;


public class Robot {
	
	//List of directions for all robots
	List <String[]> directions = new LinkedList<String[]>();
	
	//current target destination robot is trying to get to
	int destination;
	
	//current location in corridor of robot
	int location = 1;
	
	//name of the robot (e.g. orange)
	String name;
	
	//constructor just setting the name
	public Robot(String name){
		this.name = name;
	}
	
	//main decision making function of class deciding what the robot should do.
	public void action(){
		//if the button can be pushed robot removes button from list and waits
		if(canPushButton()){
			//remove robots destination from list in the directions
			directions.remove(0);
			
			//find next destination
			findNextDestination();
		}else{
			move();
		}
	}

	//checks to see if the robot is allowed to push the button
	public boolean canPushButton(){
		//look to see if robot is sitting at destination and if it is next in directions
		if(directions.size()!=0 && destination==location &&  
				directions.get(0)[0].contains(name)){
			return true;
		}else{
			return false;
		}
	}

	//loop through the directions finding the first occurrence of the robots name
	public void findNextDestination(){
		for(String[] d : directions){
			//position 0 = robot name, position 1 = location
			if(d[0].contains(name)){
				destination = Integer.parseInt(d[1]);
				return;
			}
		}
	}

	//changes the location of the robot, either forward or backwards
	public void move(){
		//check to see if the destination is in front or behind
		if(destination>location){
			location ++;
		}else if(destination<location){
			location --;
		}
	}
	
	//give the robot the directions to work with
	public void setDirections(List<String[]> d) {
		directions = d;
	}	
}
