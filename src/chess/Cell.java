package chess;

import java.awt.*;
import javax.swing.*;


/**
 * This is the Cell Class. It is the token class of our GUI.
 * There are total of 64 cells that together makes up the Chess Board
 *
 */
public class Cell extends JPanel implements Cloneable{
	
	//Member Variables
	private /*@ spec_public @*/ static final long serialVersionUID = 1L;
	private /*@ spec_public @*/ boolean ispossibledestination;
	private /*@ spec_public nullable @*/ JLabel content;
	private /*@ spec_public nullable @*/ Piece piece;
	/*@ spec_public @*/ int x, y;                             //is public because this is to be accessed by all the other class
	private /*@ spec_public @*/ boolean isSelected=false;
	private /*@ spec_public @*/ boolean ischeck=false;
	
	/*@ requires _x >= 0 && _x < 8;
	@ requires _y >= 0 && _y < 8; 
	@ assignable x, y;
	@ ensures x == _x;
	@ ensures y == _y;
	@*/
	public Cell(int _x,int _y)
	{		
		this.x=_x;
		this.y=_y;
		
		setLayout(new BorderLayout());
	
	 if((_x+_y)%2==0)
	  setBackground(new Color(113,198,113));
	
	 else
	  setBackground(Color.white);
	 
	}
	
	/*@ requires _x > -1 && _x < 8;
	@ requires _y > -1 && _y < 8; 
	@ assignable x, y;
	@ ensures x == _x;
	@ ensures y == _y;
	@ ensures piece == \old (pie);
	@*/
	public Cell(int _x,int _y,/*@ nullable @*/ Piece pie)
	{		
		this.x=_x;
		this.y=_y;
		
		setLayout(new BorderLayout());
	
	 if((_x+_y)%2==0)
	  setBackground(new Color(113,198,113));
	
	 else
	  setBackground(Color.white);
	 
	 if (pie != null)
		 setPiece(pie);
	}
	
	/*@ requires cell != null;
	@ ensures x == cell.x;
	@ ensures y == cell.y;
	@*/
	//A constructor that takes a cell as argument and returns a new cell will the same data but different reference
	public Cell(Cell cell) throws CloneNotSupportedException
	{
		this.x=cell.x;
		this.y=cell.y;
		setLayout(new BorderLayout());
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		if(cell.getpiece()!=null)
		{
			setPiece(cell.getpiece().getcopy());
		}
		else
			piece=null;
	}
	
	/*@ 
	@ assignable piece;
	@*/
	public void setPiece(Piece p)    //Function to inflate a cell with a piece
	{
		piece=p;
		String strPath = System.getProperty("user.dir");
		ImageIcon img=new javax.swing.ImageIcon(strPath + p.getPath());
		content=new JLabel(img);
		this.add(content);
	}
	
	public void removePiece()      //Function to remove a piece from the cell
	{
		if (piece instanceof King)
		{
			piece=null;
			this.remove(content);
		}
		else
		{
			piece=null;
			this.remove(content);
		}
	}
	
	
	public Piece getpiece()    //Function to access piece of a particular cell
	{
		return this.piece;
	}
	
	public void select()       //Function to mark a cell indicating it's selection
	{
		this.setBorder(BorderFactory.createLineBorder(Color.red,6));
		this.isSelected=true;
	}
	
	public boolean isselected()   //Function to return if the cell is under selection
	{
		return this.isSelected;
	}
	
	public void deselect()      //Function to delselect the cell
	{
		this.setBorder(null);
		this.isSelected=false;
	}
	
	public void setpossibledestination()     //Function to highlight a cell to indicate that it is a possible valid move
	{
		this.setBorder(BorderFactory.createLineBorder(Color.blue,4));
		this.ispossibledestination=true;
	}
	
	public void removepossibledestination()      //Remove the cell from the list of possible moves
	{
		this.setBorder(null);
		this.ispossibledestination=false;
	}
	
	public boolean ispossibledestination()    //Function to check if the cell is a possible destination 
	{
		return this.ispossibledestination;
	}
	
	public void setcheck()     //Function to highlight the current cell as checked (For King)
	{
		this.setBackground(Color.RED);
		this.ischeck=true;
	}
	
	public void removecheck()   //Function to deselect check
	{
		this.setBorder(null);
		if((x+y)%2==0)
			setBackground(new Color(113,198,113));
		else
			setBackground(Color.white);
		this.ischeck=false;
	}
	
	public boolean ischeck()    //Function to check if the current cell is in check
	{
		return ischeck;
	}
}