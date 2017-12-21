package guessme;

/**
 * A LinkedList-based implementation of the Guess-A-Number game
 */
public class LinkedListGame {

	// TODO: declare data members as necessary
int numguesses;
boolean isover;
LinkedList guesses;
int guess;
LinkedList candidates;




	/********************************************************
	 * NOTE: for this project you must use linked lists
	 * implemented by yourself. You are NOT ALLOWED to use
	 * Java arrays of any type, or any class in the java.util
	 * package (such as ArrayList).
	 *******************************************************/	 
	
	/********************************************************
	 * NOTE: you are allowed to add new methods if necessary,
	 * but DO NOT remove any provided method, and do NOT add
	 * new files (as they will be ignored by the autograder).
	 *******************************************************/
	
	// LinkedListGame constructor method
	public LinkedListGame() {
		this.guess = 1000;
		this.candidates = new LinkedList();

		reset();
		
	}
	
	
	// Resets data members and game state so we can play again
	public void reset() {
		this.numguesses = 0;
		this.isover = false;
		this.guesses = new LinkedList();
		guess = 1000;
		this.candidates = new LinkedList();
		
		for(int i = 1000; i < 10000; i++){
			candidates.append(i);
		}
	}

	// Returns true if n is a prior guess; false otherwise.
	public boolean isPriorGuess(int n) {
		if(guesses == null){
			return false;
		}
			//LLIntegerNode current = guesses;
		if(guesses.contains(n)){
			return true;
		}
		
		return false;
	}
	
	// Returns the number of guesses so far.
	public int numGuesses() {
		// TODO
		return numguesses;
	}
	
	/**
	 * Returns the number of matches between integers a and b.
	 * You can assume that both are 4-digits long (i.e. between 1000 and 9999).
	 * The return value must be between 0 and 4.
	 * 
	 * A match is the same digit at the same location. For example:
	 *   1234 and 4321 have 0 match;
	 *   1234 and 1114 have 2 matches (1 and 4);
	 *   1000 and 9000 have 3 matches (three 0's).
	 */
	public static int numMatches(int a, int b) {
		int count = 0;
		
		for(int i = 0; i < 4; i++){
			if((a % 10) == (b % 10)){
				count++;
			}
				a  /= 10;
				b /= 10;
		}
		
		return count; 
		
	}
	
	/**
	 * Returns true if the game is over; false otherwise.
	 * The game is over if the number has been correctly guessed
	 * or if no candidate is left.
	 */
	public boolean isOver() {
		return isover;
	}
	
	/**
	 * Returns the guess number and adds it to the list of prior guesses.
	 * The insertion should occur at the end of the prior guesses list,
	 * so that the order of the nodes follow the order of prior guesses.
	 */	
	public int getGuess() {
		numguesses++;
		
		if(guesses == null){
			guesses = new LinkedList();
		}
		guesses.append(guess);
		
		return guess;
	}
	
	/**
	 * Updates guess based on the number of matches of the previous guess.
	 * If nmatches is 4, the previous guess is correct and the game is over.
	 * Check project description for implementation details.
	 * 
	 * Returns true if the update has no error; false if no candidate 
	 * is left (indicating a state of error);
	 */
	public boolean updateGuess(int nmatches) {	
		if(nmatches == 4){
			isover = true;
			return true;
		}
		
		LinkedList updated = new LinkedList();
		LLIntegerNode newnode = candidates.head();
		
		while(newnode != null){
			if(numMatches(newnode.getInfo(), guess) == nmatches){
				updated.append(newnode.getInfo());
			}
			
			newnode = newnode.getLink();
		}
		
		candidates = updated;
		if(candidates.head() != null){
		guess = candidates.head().getInfo();
		return true;
		}
		
		
			
	return false;
	}

		
	
	
	// Returns the head of the prior guesses list.
	// Returns null if there hasn't been any prior guess
	public LLIntegerNode priorGuesses() {
		if(guesses == null){
			return null;
		}
		
		return guesses.head();
		
		}
	
	/**
	 * Returns the list of prior guesses as a String. For example,
	 * if the prior guesses are 1000, 2111, 3222, in that order,
	 * the returned string should be "1000, 2111, 3222", in the same order,
	 * with every two numbers separated by a comma and space, except the
	 * last number (which should not be followed by either comma or space).
	 *
	 * Returns an empty string if here hasn't been any prior guess
	 */
	public String priorGuessesString() {
		String current= "";
		LLIntegerNode newnode = guesses.head();

		if(guesses.head() == null){
			return "";
		}

		while(newnode.getLink()!= null){
			current = current+newnode.getInfo() + ", ";
			newnode = newnode.getLink();
		}
		current = current + newnode.getInfo();
		return current;
	}
}
