/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazeymazey;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author shurakshyakharel
 */
public class QuestionManager {
        private ArrayList<QuestionV2> questCollect;
	
	public QuestionManager() {
		questCollect = new ArrayList<QuestionV2>();
	}

	public void addQuestion(QuestionV2 q){
		this.questCollect.add(q);
	}
	
	public boolean askRandomQuestion(){
		
		//boolean result = false;
		
		// Find random question
		Random rand = new Random();
		int randomNum = rand.nextInt((this.questCollect.size() - 1  - 0) + 1);
		
		// Get the question from the collection with index "randomNum"
		QuestionV2 question = questCollect.get(randomNum);
		
		// Ask the player that question , store the return value ( true / false ) to the RESULT
		boolean result = question.askPlayer();
		
		// Return the value RESULT
		return result;
	}
	
	
	public static void main(String args[]){
		
		// Create a object q1 ( it's class is QuestionV2 )
		QuestionV2 q1 = new QuestionV2();
		q1.setQuestion("");
		q1.addAnswer("Tri");
		
		// Create question no2
		QuestionV2 q2 = new QuestionV2();
		q2.setQuestion("Synonym of Good");
		q2.addAnswer("Well");
		q2.addAnswer("Nice");
		
		q2.askPlayer();
	}
    
}
