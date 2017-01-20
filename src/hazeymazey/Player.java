/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hazeymazey;

/**
 *
 * @author shurakshyakharel
 */
public class Player {
        int x;
        int y;
	int changer;
	int prevx;
	int prevy;
	boolean keypass;
	int digTime;
        boolean hasMapFragment,hasChanger;
	boolean hasHidden;
	
	
	public Player(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Player(){     
		this.x = 0;
		this.y = 0;
		this.digTime = 3;
                this.changer = 0;
		this.prevx = 0;
		this.prevy=0;
		this.keypass= false;
	}
	
	
	public int getDigTime(){
		return this.digTime;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}
	
	public int getX(){
		return this.x;
	}
	
	public int getY(){ 
		return this.y; }
	
	public boolean getMapFragment(){
		return this.hasMapFragment;
	}
	
	public boolean getChanger(){
		return this.hasChanger;
	}
	

	public boolean getHidden(){
		return this.hasHidden;
	}
	

	public void removeDig(){
		this.digTime -= 1;
	}
	public void setMapFragment(){
		this.hasMapFragment = true;
	}
	
	public void setChanger(){
		this.hasChanger = true;
	}
	

	
	public void lostItem(){
		this.hasMapFragment = false;
		this.hasChanger = false;
	//	this.hasKeyPass = false;
	}
}