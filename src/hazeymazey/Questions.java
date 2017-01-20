/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazeymazey;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author shurakshyakharel
 */
public class Questions {
    String[][] quiz = {
		{"1 + 1 = ?","2"},
		{"Where is it ?","Finland"},
		{"Synonym of 'Encourage' ","Inspiration"},
		{"Antonym of 'Smart'","Dumb"}
	};
	
	
	// Question with multiple possible answers
	public boolean popQuestion(){
		System.out.println("asdlkfjasdklfjaskldf");
		// Pop random question
		// Look for a random number between 0 ( min ) and quiz.length - 1 ( max )
		Random rand = new Random();
		int randomNum = rand.nextInt((this.quiz.length - 1  - 0) + 1);
		// PRINT IT OUT
		String question = this.quiz[randomNum][0];
		System.out.println(question);
		// Use scanner to get the input
		Scanner s = new Scanner(System.in);
		// Check if the answer is correct or not
		String answer = this.quiz[randomNum][1];
		
		String input = s.nextLine(); // Player input
		//s.close();
		if( input.equals(answer) ) {
			System.out.println("Trueeeee answer");
			return true;
		}	else {
			return false;
		}
	}
    
}
