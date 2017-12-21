package guessme;

public class LinkedList {
	private LLIntegerNode head;
	private LLIntegerNode tail;
	private int size;
		
	public LinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	/**
	 * 
	 * @return the number of elements in this list
	 */
	
	public LLIntegerNode head(){
		return head;
	}
	
	
	public int size() {
		if (head == null) {
			return size;
		}
		LLIntegerNode current = head;
		while(current.getLink() != null){
			size++;
			current = current.getLink();
			
		}
		return size;
	}
	
	/**
	 * 
	 * @param e the element search for
	 * @return true iff the list contains an element of whose value equals that of e
	 */
	public boolean contains(int n) {
		LLIntegerNode current = head;
		while (current != null) {
			if (current.getInfo() == n) {
				return true;
			}
			current = current.getLink();
		}
		return false;
	}
	/**
	 * Appends the element e to the end of the list.
	 * 
	 * @param e the value to append
	 */
	public void append(Integer n) {
		LLIntegerNode newnode = new LLIntegerNode(n, null);
		if(tail == null) {
			head = newnode;
		}
		else{
		 tail.setLink(newnode);	
	}
		tail = newnode;
	}
}
