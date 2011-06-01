import java.io.*;
import java.util.*;


public class testClass {
	static int numberOfCases;
	static List<String> fileLines= new ArrayList<String>();
	static List<World> testCases = new ArrayList<World>();
	
	//main method to run program
	public static void main(String[] args) {

		try {
			//read in the text file with instruction
			Scanner scan = new Scanner(new File("instructions.txt"));
			
			//read file into an array list
			while(scan.hasNextLine()){
				fileLines.add(scan.nextLine());
			}
			
			//take first line of file stating number of cases
			numberOfCases = Integer.parseInt(fileLines.remove(0));

			//loop around the fileLines building the cases
			for(String instructions : fileLines){
				World testCase = new World(instructions);
				testCases.add(testCase);
			}
			
			//start the worlds off
			for(World testCase : testCases){
				testCase.start();
			}	
			
			//print out the results
			int i = 1;
			for(World testCase : testCases){
				System.out.printf("Case #%d: %d \n", i++, testCase.getTotalTime());
			}
		
		} catch (FileNotFoundException e) {
			System.err.println("Can't read file in");
		}
		
	}
}
