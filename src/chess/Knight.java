package chess;

import java.util.ArrayList;

/**
 * This is the Knight Class inherited from the Piece abstract class
 *  
 *
 */
public class Knight extends Piece{
	
	//Constructor
	/*@ assignable color, id, path;
	@ requires i != null;
	@ requires p != null;
	@ requires c == 0 || c == 1;
	@ ensures this.getId() == i;
	@ ensures this.getPath() == p;
	@ ensures this.getcolor() == c; 
	@*/
	public Knight(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//Move Function overridden
	//There are at max 8 possible moves for a knight at any point of time.
	//Knight moves only 2(1/2) steps
	/*@ requires x >= 0 && x < 8;
	@ requires y >= 0 && y < 8;
	@ ensures (\forall int i;
		i >= 0 && i < \result.size();
		( ( (Cell) \result.get(i)).x == x + 2 && ( (Cell) \result.get(i)).y == y + 1)
		|| (( (Cell) \result.get(i)).x == x + 2 x && ( (Cell) \result.get(i)).y == y - 1)
		|| (( (Cell) \result.get(i)).x == x + 1 x && ( (Cell) \result.get(i)).y == y + 2)
		|| (( (Cell) \result.get(i)).x == x - 1 x && ( (Cell) \result.get(i)).y == y + 2)
		|| (( (Cell) \result.get(i)).x == x + 1 x && ( (Cell) \result.get(i)).y == y - 2)
		|| (( (Cell) \result.get(i)).x == x - 1 x && ( (Cell) \result.get(i)).y == y - 2)
		|| (( (Cell) \result.get(i)).x == x - 2 x && ( (Cell) \result.get(i)).y == y + 1)
		|| (( (Cell) \result.get(i)).x == x - 2 x && ( (Cell) \result.get(i)).y == y - 1)); 
	@*/
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{
		possiblemoves.clear();
		int posx[]={x+1,x+1,x+2,x+2,x-1,x-1,x-2,x-2};
		int posy[]={y-2,y+2,y-1,y+1,y-2,y+2,y-1,y+1};
		for(int i=0;i<8;i++)
			if((posx[i]>=0&&posx[i]<8&&posy[i]>=0&&posy[i]<8))
				if((state[posx[i]][posy[i]].getpiece()==null||state[posx[i]][posy[i]].getpiece().getcolor()!=this.getcolor()))
				{
					possiblemoves.add(state[posx[i]][posy[i]]);
				}
		return possiblemoves;
	}
}