/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazeymazey;

import java.util.Scanner;

/**
 *
 * @author shurakshyakharel
 */
public class HazeyMazey {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] gameInstruction = { 
				"Welcome to our very first game", 
				"You are a person that lost somewhere we do not know either",
				"You have to find the Ancient Treasure to win this game",
				"Game command : item,map,status,move,dig",
				"Just type to test a command and enjoy our game !!"
				};
		
		Player newPlayer = new Player();
		
		Gameplay newGameplay = new Gameplay(newPlayer);
		
		newGameplay.createGame(); // Initialize the map
		
		// Put player on the start positions
		newGameplay.putPlayerOnStart();
		
		// Print out game instruction using loops
		for(int i = 0 ; i < gameInstruction.length ; i++){
			System.out.println(gameInstruction[i]);
		}
		
		
		Scanner cmdScan = new Scanner(System.in);
		String command;
		do {
			
			if(newGameplay.isGameEnd){
				System.out.println("");
			}
			
			System.out.println("Please type a command :");
			System.out.println(gameInstruction[3]);
			command = cmdScan.next();
			
			if(command.equals("map")){
				newGameplay.showMapAndLocation();
			}	else if ( command.equals("item")){
				newGameplay.showPlayerItem();
			}	else if (command.equals("status")){
				newGameplay.showPlayerStatus();
			}	else if ( command.equals("dig")){
				newGameplay.playerDig();
			}	else if (command.equals("move")){
				boolean moved = newGameplay.playerMoveNext();
				if(moved) newGameplay.updatePlayer();
			}	else if (command.equals("exit")){
				if(!newGameplay.isGameEnd) {
					System.out.println("You quit in the middle of the game !!!");
					System.out.println("Try again next time !!");
				}
			}	else	{
				System.out.println("Invalid commands !!!");
			}
			
		} while (!command.equals("exit"));
		
		System.out.print("Somehow , you typed exit and the program ends . LoL !");
		cmdScan.close();
		
	}
    }
    

