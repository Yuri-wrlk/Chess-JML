package chess;

import java.util.ArrayList;

/**
 * This is the Rook class inherited from abstract Piece class
 *
 */
public class Rook extends Piece{
	
	//Constructor
	/*@ requires i != null;
	@ requires p != null;
	@ requires c == 0 || c == 1;
	@ ensures this.getId() == i;
	@ ensures this.getPath() == p;
	@ ensures this.getcolor() == c; 
	@*/
	public Rook(String i,String p,int c)
	{
		setId(i);
		setPath(p);
		setColor(c);
	}
	
	//Move function defined
	/*@ requires x >= 0 && x < 8;
	@ requires y >= 0 && y < 8;
	@ ensures (\forall int i;
		i >= 0 && i < \result.size();
		( ( (Cell) \result.get(i)).x > x && ( (Cell) \result.get(i)).y == y)
		|| (( (Cell) \result.get(i)).x == x && ( (Cell) \result.get(i)).y < y)
		|| (( (Cell) \result.get(i)).x < x && ( (Cell) \result.get(i)).y == y)
		|| (( (Cell) \result.get(i)).x == x && ( (Cell) \result.get(i)).y > y)); 
	@*/
	public ArrayList<Cell> move(Cell state[][],int x,int y)
	{
		//Rook can move only horizontally or vertically
		possiblemoves.clear();
		int tempx=x-1;
		while(tempx>=0)
		{
			if(state[tempx][y].getpiece()==null)
				possiblemoves.add(state[tempx][y]);
			else if(state[tempx][y].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx--;
		}
		tempx=x+1;
		while(tempx<8)
		{
			if(state[tempx][y].getpiece()==null)
				possiblemoves.add(state[tempx][y]);
			else if(state[tempx][y].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[tempx][y]);
				break;
			}
			tempx++;
		}
		int tempy=y-1;
		while(tempy>=0)
		{
			if(state[x][tempy].getpiece()==null)
				possiblemoves.add(state[x][tempy]);
			else if(state[x][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy--;
		}
		tempy=y+1;
		while(tempy<8)
		{
			if(state[x][tempy].getpiece()==null)
				possiblemoves.add(state[x][tempy]);
			else if(state[x][tempy].getpiece().getcolor()==this.getcolor())
				break;
			else
			{
				possiblemoves.add(state[x][tempy]);
				break;
			}
			tempy++;
		}
		return possiblemoves;
	}
}
