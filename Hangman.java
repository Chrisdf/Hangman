import java.util.*;
import java.io.*;


public class Hangman {

 public static void main(String[] args) throws IOException{
    	
    
    	
    	
    	int guessedWrong = 0;
    	
    	ArrayList<Puzzle> puzzleList = new ArrayList<Puzzle>();
    	ArrayList<String> answerKey = new ArrayList<String>();
    	ArrayList<String> displayedLetters = new ArrayList<String>();
    	boolean ingame = true;
    	
    	
    	
    	String hint = init(puzzleList, answerKey, displayedLetters);
    	
    	
    		
    	
    	System.out.println("Welcome to hangman!");

		renderHangman(hint, guessedWrong, displayedLetters);
		
		
		
		
    	
    	while(ingame){
    	
    	Scanner kb = new Scanner(System.in);
    	String guessedLetter = kb.next().substring(0,1).toUpperCase();
    	
    	
    	
    	guessedWrong = checkIfWrong(guessedWrong, guessedLetter, answerKey, displayedLetters);
    
    	renderHangman(hint, guessedWrong, displayedLetters);
    	
    	ingame = checkIfWon(answerKey, displayedLetters);
    	
   
    	}
    }
    	
    	
    	
    	
    	
    	
    	
    	public static void renderHangman(String hint, int guessedWrong, ArrayList<String> displayedLetters){
    		
    		switch(guessedWrong){
    			case 0:
    				System.out.println("  -|");
    				System.out.println("   |");
    				System.out.println("   |");
    				System.out.println("   |");
    				break;
    			case 1:
    				System.out.println("  -|");
    				System.out.println(" O |");
    				System.out.println("   |");
    				System.out.println("   |");
    				break;
    			case 2:
    				System.out.println("  -|");
    				System.out.println(" O |");
    				System.out.println(" | |");
    				System.out.println("   |");
    				break;
    			case 3:
    				System.out.println("  -|");
    				System.out.println(" O |");
    				System.out.println(" |\\|");
    				System.out.println("   |");
    				break;
    			case 4:
    				System.out.println("  -|");
    				System.out.println(" O |");
    				System.out.println("/|\\|");
    				System.out.println("   |");
    				break;
    			case 5:
    				System.out.println("  -|");
    				System.out.println(" O |");
    				System.out.println("/|\\|");
    				System.out.println("/  |");
    				break;

    			case 6:
    				System.out.println("  -|");
    				System.out.println(" O |");
    				System.out.println("/|\\|");
    				System.out.println("/ \\|");
    				break;
    				
    			default:
    				System.out.println();
    				System.out.println("YOU LOSE");
    			break;
    		}
    		
    		if(guessedWrong<=6){
    					
    		for(int i = 0; i<displayedLetters.size(); i++){
    			
    			System.out.print(displayedLetters.get(i) + " ");
    		
    			}
    		
    		System.out.println();
    		System.out.println();
    		System.out.println(hint);
    		
    		}
    		
    		System.out.println();
    		
    		
    	
    	
    	
    	}
    	
    	public static int checkIfWrong(int guessedWrong, String guessedLetter, ArrayList<String> answerKey, ArrayList<String> displayedLetters){
    		
    		if(answerKey.contains(guessedLetter)){
    			
    			for(int i = 0; i<answerKey.size(); i++){
    				
    				if(answerKey.get(i).equals(guessedLetter))
    					displayedLetters.set(i,guessedLetter);
    				
    				
    			}
    			
    		}
    		
    		else
    			guessedWrong++;
    			
    		return guessedWrong;
    		
    		
    		
    	}
    	
    	public static String init(ArrayList<Puzzle> puzzleList, ArrayList<String> answerKey, ArrayList<String> displayedLetters) throws IOException{
    	
    		
    	Scanner reader = new Scanner(new File("wordslist.txt"));	
    		
    	while(reader.hasNextLine()){
    		
    		puzzleList.add(new Puzzle(reader.nextLine(),reader.nextLine()));
   	
    	}	
    	
    	int random = (int)(Math.random()*puzzleList.size());
    		
    	String word = puzzleList.get(random).getPhrase().toUpperCase();
    	String hint = puzzleList.get(random).getCategory().toUpperCase();
    	
    		
    	for(int i = 0; i<word.length(); i++)
    		answerKey.add(word.substring(i,i+1));	
    		
		for(int i = 0; i<answerKey.size(); i++){
			
			if(answerKey.get(i).equals(" "))
				displayedLetters.add(" ");
			else
				displayedLetters.add("_");
			
				}
    		
    	return hint;
    	
    	}
    	
    	public static boolean checkIfWon(ArrayList<String> answerKey, ArrayList<String> displayedLetters){
    		
    		int lettersCorrect = 0;
    		
    		for(int i = 0; i<answerKey.size(); i++){
    			
    			if(answerKey.get(i).equals(displayedLetters.get(i)))
    				lettersCorrect++;
    			}
    		if(lettersCorrect == answerKey.size()){
    			System.out.println();
    			System.out.println("YOU WON");
    			return false;

    		}
    			
    			
    		else
    			return true;
    		
    		
    		
    	}
    		
    		
    
    
    
}