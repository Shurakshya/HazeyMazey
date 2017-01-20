/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazeymazey;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author shurakshyakharel
 */
public class Gameplay {
        Player myPlayer;
	GameMap myMap;
	int startX,startY;
	int endPoint;
	boolean isGameEnd;
	// Draw map -> Collect data from Map -> Process Data from Map -> Set player -> 
	QuestionManager qm;
	public Gameplay(Player aPlayer){
		this.myPlayer = aPlayer;
		qm = new QuestionManager();
		
	}
	
	
	public void createGame(){
		// Create map
		int[][] board =  {
				{0,2,2,2,2,0,0,0,0,0},
				{0,2,0,0,0,0,0,0,0,0},
				{0,2,2,2,0,0,0,0,0,0},
				{0,2,0,3,0,0,0,0,0,0},
				{0,2,0,0,0,0,0,0,0,0},
				{0,2,0,0,6,0,0,0,0,0},
				{0,2,0,0,0,0,0,0,0,0},
				{0,2,0,0,0,0,0,0,0,2},
				{0,2,0,0,0,0,0,0,0,2},
				{0,2,2,2,2,2,2,2,2,1},
				
		};
		
			// Choose a map then set the map to GameplayMap
		this.myMap = new GameMap(10,10,1,board);
		//this.myMap.setMap(board);
		this.myMap.drawMap(); // Test purpose
		
		// Create questions
		QuestionV2 q1 = new QuestionV2();
		q1.setQuestion("Synonym of 'Abhor'");
		q1.addAnswer("detest");
		q1.addAnswer("hate");
		q1.addAnswer("scorn");
		q1.addAnswer("despise");
		q1.addAnswer("abominate");
		
		qm.addQuestion(q1);
		
		QuestionV2 q2 = new QuestionV2();
		q2.setQuestion("Antonym of 'lethal' :");
		q2.addAnswer("safe");
		q2.addAnswer("harmless");
		q2.addAnswer("useful");
		
		qm.addQuestion(q2);
		
		QuestionV2 q3 = new QuestionV2();
		q3.setQuestion(" o u s e h s  - make the word :");
		q3.addAnswer("houses");
		
		qm.addQuestion(q3);
		
		QuestionV2 q4 = new QuestionV2();
		q4.setQuestion("What does the car loses when it turns ??");
		q4.addAnswer("speed");
		q4.addAnswer("velocity");
		q4.addAnswer("acceleration");
		
		qm.addQuestion(q4);
		
		
	}
	// Set player position to START 
	public void putPlayerOnStart(){
		
		// Get start position from map 
		for(int i = 0 ; i < this.myMap.height ; i++){
			for(int j = 0 ; j < this.myMap.width ; j++ ){
				if(this.myMap.myMap[i][j] == 1 ){
					startY = this.myMap.height - i;
					startX = j + 1; 
				}
			}
		}
		System.out.println("Start pos:" + this.startX + " - " + this.startY);
		
		
		// Set player position to starting point
		this.myPlayer.x = startX;
		this.myPlayer.y = startY;
	}
	
	// Working in progress
	public boolean playerMoveNext(){
		// Move to next position , play input a coordinate that is able to walk on the map 
		System.out.println("Input coordinate ( format x y ): ");
		Scanner aScan = new Scanner(System.in);
		
		int nextX,nextY;
		
		nextX = aScan.nextInt();
		nextY = aScan.nextInt();
		if(nextX == this.myPlayer.x && nextY == this.myPlayer.y ) {
			System.out.println("You cannot move to the same location");
			return false;
			
		}
		// Check if coordinate is accessible 
		if( this.myMap.myMap[this.myMap.height - nextY][nextX - 1] != 0 ){
			// Player can only move 1 distance away from the original coordinate
			int distX,distY;
			
			distX = this.myPlayer.x - nextX;
			distY = this.myPlayer.y - nextY;
		
			if(Math.abs(distY) <= 1 && Math.abs(distX) <= 1){
				
				// we store the value for prevx and prev y
				this.myPlayer.prevx = this.myPlayer.x;
				this.myPlayer.prevy = this.myPlayer.y;
				
				
				// Assign the nextX to player's X 
				this.myPlayer.x = nextX;
				this.myPlayer.y = nextY;
				System.out.println("Moveedddddd");
				return true;
			}	else {
				System.out.println("You cannot go such far !!");
				return false;
			}
		}	else {
			System.out.println("Your coordinate is not accessible !!!");
			return false;
		}
		//aScan.close();
	}
	
	/*
	 * Get obstable type by Coordinate;
	 * 1 - Start
	 * 2 - Normal path
	 * 3 - Hidden treasure
	 * 4 - N/A
	 * 5 - Gates
	 * 6 - Goal to Ancient Treasure
	 * */
	public void updatePlayer(){
		// Get obstacle type on player's coordinate
		int obstacleType = this.myMap.getTypeByCoor(this.myPlayer.x,this.myPlayer.y);
		
		switch(obstacleType){
		case 2:
		case 3: { // NOrmal path , random chances of getting questions here
			// Random chance
			Random ran = new Random();
			int ranNum = ran.nextInt(4); // 25 percent chance
			
			System.out.println(ranNum);
			if(ranNum == 2){
			
			boolean result = qm.askRandomQuestion();
			if(result){
				System.out.println("Your answer is correct ");
			}	else {
				System.out.println("Your answer is wrong !!");
			}
			}
			break;
		}
		case 5 : {
			boolean result = false;
			// A golden gate , your stupidity will be tested
			// CHeck if player has the Keypass then ask him
			if(this.myPlayer.keypass){
				System.out.println("You have the keypass . Do you want to use it ?");
				System.out.println("Type 'yes' or 'no'");
				
				Scanner aScann = new Scanner(System.in);
				String input=aScann.next();
				
				if(input.equalsIgnoreCase("yes")){
					// Use the keypass
					this.myPlayer.keypass = false;
					System.out.println("The gatekeeper said you can get through ");
					break;
				}	else {
					// Ask him
					result = qm.askRandomQuestion();
				}
			}	else {
				result = qm.askRandomQuestion();
			}
			
			if(result){
				System.out.println("Correcto!");
				
			}	else {
				// Print 
				System.out.println("This gate will close forever !");
				System.out.println("Let's try find another way around :(");
				
				// Make this coordinate in-accessible 
				
				// Move player back to previous coordinate
			}
		}
		break;
		}
		
		
	}
	
	
	
	
	public void playerTrapped(){
		// Ask a question to player , if the answer is correct, player can keep his item, else , he lost all his item 
	}
	
	// Make the player to dig for hidden treasure 
	public void playerDig(){
		
		// If number of digging = 0 , player cannot dig anymore 
		if(this.myPlayer.digTime == 0){
			System.out.println("You cannot dig anymore !!");
			return;
		}
		
		int obstacleType = this.myMap.getTypeByCoor(this.myPlayer.x,this.myPlayer.y);
		
		if(obstacleType == 3){
			System.out.println("Congratulations !!!! You found the Hidden Treasure !!");
			System.out.println("You got the key pass !");
			// Set found the hidden treasure true
		
			this.myPlayer.keypass = true;
			// Random rewards
			
			// Make this coordinate become normal path again 
		}	else {
			System.out.println("You spent all day digging for nothing !");
		}
		this.myPlayer.digTime--;
		// Check if current location has the hidden treasure or not , then give the player 
	}
	

	public void showPlayerStatus(){
		// Check the dig time , is user found the hidden treasure
		System.out.println("You can dig the ground for " + this.myPlayer.digTime + " time(s)");
		
	}
	
	public void showPlayerItem(){
		// Check what item the player has , if true then print out the item available
		System.out.println("You have " + this.myPlayer.changer + " Question Changer");
		//if(this.myPlayer.hasKeyPass) System.out.println("You have the Golden Key ( pass 1 question )");
		if(this.myPlayer.keypass) System.out.println("You have a key to pass a gate ");
	}
	
	public void showMapAndLocation(){
		// Draw the map and then print the current position of player
		this.myMap.drawMap();
		System.out.println("Your coordinate : " + this.myPlayer.x + " - " +  this.myPlayer.y);
	}
    
}
