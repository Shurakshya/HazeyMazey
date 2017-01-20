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
    public class GameMap {
        int width,height;
	int size;
	int[][] myMap;
	
	public GameMap(int width, int height, int size, int[][] aMap){
		this.width = width;
		this.height = height;
		this.size = size;
		this.myMap = aMap;
	}
	
	public void setMap(int[][] aMap){
		this.myMap = aMap;
	}
	
	// Draw map 
	public void drawMap(){
		// Print number lines horizontally
		for (int i = 0; i < this.height + 1; ++i) {
		
		if( this.height - i != 0) {
			// Draw line number
			System.out.print(this.height - i );
			
			// Draw a vertical line
			System.out.print("|");
			
			// Draw line || map object
			// Complicated check here , check if it is a gates || route || blah blah
			
			for( int k = 0 ; k < this.width ; ++k){
				// Check if current location of Player is here
				if(this.myMap[i][k] == 1){
					System.out.print("**");
				}	else if ( this.myMap[i][k] == 2){
					System.out.print("##");
				}	else if ( this.myMap[i][k] == 3)	{
					System.out.print("XX");
				}	else if (this.myMap[i][k] == 5){
					System.out.print("GG");
				}	else if (this.myMap[i][k] == 6) {
					System.out.print("$$");
				}
				else {
					System.out.print("--");
				}
				
			}
		
		}	else	{

			for(int o = 0 ; o < this.size + 1 ; ++o){
				System.out.print("-");
			}
			
			for(int j = 1 ; j < this.width + 1 ; ++j){
				System.out.print(j);
				
				for(int h = 0 ; h < this.size ; ++h){
					System.out.print("-");
				}
			}
		}
		
		
		System.out.print("\n");
		}
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
	
        public int getTypeByCoor(int x, int y){
		return this.myMap[this.height - y][ x - 1 ];
	}
    
    }
