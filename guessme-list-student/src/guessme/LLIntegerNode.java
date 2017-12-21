package guessme;

/**
 * This class defines a linked list node storing an integer.
 * You must provide the following methods:
 * - a constructor
 * - a setInfo method and a getInfo method
 * - a setLink method and a getLink method
 */
public class LLIntegerNode {
	private LLIntegerNode link;
	private int value;

	
	public LLIntegerNode (int val, LLIntegerNode link){
		this.link = link;
		this.value = val;
		
	}
	
	public void setInfo(int val){
		value = val;
	}
	
	public int getInfo(){
		return value;
	}
	
	public void setLink(LLIntegerNode link){
		this.link = link; 
	}
	
	public LLIntegerNode getLink(){
		return link;
	}

}

