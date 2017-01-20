/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazeymazey;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 *
 * @author shurakshyakharel
 */
public class QuestionV2 {
        private String question;
	private ArrayList answer;
	
	public QuestionV2(){
		this.question = "";
		this.answer = new ArrayList();
	}
	
	public void setQuestion(String question){
		this.question = question;
	}
	
	public void addAnswer(String answer){
		this.answer.add(answer);
	}
	
	// Ask player this question
	public boolean askPlayer(){
		// Assume that result is false
		boolean result = false;
		
		// Ask - print out the question
		System.out.println(this.question);
		
		// Get user input 
		Scanner s = new Scanner(System.in);
		
		String myInput = s.next();
		
		// Loop through all answers
	for(int i = 0 ; i < answer.size() ; i++){
			// If input equals to a specific answer 
		    if(myInput.equalsIgnoreCase(answer.get(i).toString())){
		    	result = true;
		    	break;
		    }	
	}		
		 
		return result; 
	}
	
	// Example to create a Object Q2 with class name "QuestionV2"
	public static void main(String arg[]){
		QuestionV2 q2 = new QuestionV2();
		
		q2.setQuestion("Synonym of 'Good' ?");
		q2.addAnswer("Well");
		q2.addAnswer("Good");
		q2.addAnswer("Yeah");
		
		if(q2.askPlayer() == true ){
			System.out.println("True");
		}	else {
			System.out.println("False");
		}
		
	}          
    
}
