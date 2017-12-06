package chess;

import java.util.ArrayList;


/**
 * This is the Piece Class. It is an abstract class from which all the actual pieces are inherited.
 * It defines all the function common to all the pieces
 * The move() function an abstract function that has to be overridden in all the inherited class
 * It implements Cloneable interface as a copy of the piece is required very often
 */
public abstract class Piece implements Cloneable{

	//Member Variables
	private /*@ spec_public @*/ int color;
	private /*@ spec_public nullable @*/ String id=null;
	private /*@ spec_public nullable @*/ String path;
	protected /*@ spec_public nullable @*/ ArrayList<Cell>  possiblemoves = new ArrayList<Cell>();  //Protected (access from child classes)
	public abstract ArrayList<Cell> move(Cell pos[][],int x,int y);  //Abstract Function. Must be overridden
	
	//Id Setter
	/*@ public initially this.id != null; @*/
	
	/*@ 
	@ requires id != null;
 	@ assignable this.id;
 	@*/
	public void setId(String id)
	{
		this.id=id;
	}
	
	//Path Setter
	/*@ 
	@ requires path != null;
 	@ assignable this.path;
 	@ ensures this.path == path;
 	@*/	
	public void setPath(String path)
	{
		this.path=path;
	}
	
	//Color Setter
	/*@ 
	@ requires c == 0 || c == 1;
 	@ assignable this.color;
 	@ ensures this.color == c;
 	@*/
	public void setColor(int c)
	{
		this.color=c;
	}
	
	//Path getter
	/*@
 	@ ensures \result == this.path;
 	@*/	
	public /*@ pure @*/ String getPath()
	{
		return path;
	}
	
	//Id getter
	/*@
 	@ ensures \result == this.id;
 	@*/		
	public /*@ pure @*/ String getId()
	{
		return id;
	}
	
	//Color Getter
	/*@
 	@ ensures \result == this.color;
 	@*/		
	public /*@ pure @*/ int getcolor()
	{
		return this.color;
	}
	
	//Function to return the a "shallow" copy of the object. The copy has exact same variable value but different reference
	/*@ 
 	@ ensures \result.getcolor() == this.getcolor() && \result.getId() == this.getId() && \result.getPath() == this.getPath();
 	@*/	
	public /*@ pure @*/ Piece getcopy() throws CloneNotSupportedException
	{
		return (Piece) this.clone();
	}
}