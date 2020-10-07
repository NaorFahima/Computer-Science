package task_2;

import java.util.Scanner;

public class MurblePuzzle {
	
	public static void printPuzzle(char[] puzzle) {//print puzzle
		for (char printPuzzle: puzzle ) {
			System.out.print(printPuzzle + "|");		
		}
		
	}
	
	public static int shiftRight(char[] puzzle , int emptyLocation ) { 
		//Replaces the empty space with the object closest to it on the left
		
		if (puzzle[emptyLocation-1] == 'X') {
			puzzle[emptyLocation] = 'X';
		} else {
			puzzle[emptyLocation] = '0';
		}
		puzzle[emptyLocation-1] = ' ';
		
		System.out.print("  SR");
		System.out.println();
		printPuzzle(puzzle);
		emptyLocation--;
		return emptyLocation;
	}

	public static int shiftLeft(char[] puzzle , int emptyLocation ) { 
		//Replaces the empty space with the object closest to it on the right
		
		if (puzzle[emptyLocation+1] == 'X') {
			puzzle[emptyLocation] = 'X';
		} else {
			puzzle[emptyLocation] = '0';
		}
		
		puzzle[emptyLocation+1] = ' ';
		
		System.out.print("  SL");
		System.out.println();
		printPuzzle(puzzle);
		emptyLocation++;
		return emptyLocation;
	}
	
	public static int jumpRight(char[] puzzle , int emptyLocation ) {
        //Replaces the empty space with the object away from it, one place to the left
		if (puzzle[emptyLocation-2] == 'X') {
			puzzle[emptyLocation] = 'X';
		} else {
			puzzle[emptyLocation] = '0';
		}

		puzzle[emptyLocation-2] = ' ';
		
		System.out.print("  JR");
		System.out.println();
		printPuzzle(puzzle);
		emptyLocation = emptyLocation -2;
		return emptyLocation;

	}
	
	public static int jumpLeft(char[] puzzle , int emptyLocation ) {
        //Replaces the empty space with the object away from it, one place to the right
		
		if (puzzle[emptyLocation+2]== 'X') {
			puzzle[emptyLocation] = 'X';
		} else {
			puzzle[emptyLocation] = '0';
		}

		puzzle[emptyLocation+2] = ' ';
		
		System.out.print("  JL");
		System.out.println();
		printPuzzle(puzzle);
		emptyLocation = emptyLocation + 2;
		return emptyLocation;

	}
	
	public static int solvePuzzel (char[] puzzle , int emptyLocation , int sizePuzzle ,int focter ) {
        
		for (int j = 0; j < (sizePuzzle-focter); j++) {
			if (sizePuzzle%2 == 0) {
				if ((sizePuzzle-focter)%2 == 0) {
					emptyLocation = jumpLeft(puzzle, emptyLocation);
				} else {
					emptyLocation = jumpRight(puzzle, emptyLocation);
				}

			} else {
				if ((sizePuzzle-focter)%2 == 0) {
					emptyLocation = jumpRight(puzzle, emptyLocation);
				} else {
					emptyLocation = jumpLeft(puzzle, emptyLocation);
				}
			}
			
			
		}
		
		return emptyLocation;
	}	
		
	
	
	public static void main(String[] args) {
		
		int sizePuzzle;
		int emptyLocation , focter = 1;
		char [] puzzle;
		
		Scanner sca = new Scanner(System.in);
		
		System.out.println("What size puzzle you want to play?");
		sizePuzzle = sca.nextInt();
		
		sca.close();
		emptyLocation  = 2*sizePuzzle;
		puzzle = new char [2*sizePuzzle+1];
		
		for (int i = 0; i < puzzle.length-1; i = i + 2 ) {
			puzzle[i] = '0';
		}
		for (int i = 1; i < puzzle.length; i = i + 2) {
			puzzle[i] = 'X';
		}
		printPuzzle(puzzle);
	    
		if (sizePuzzle%2 == 0) {
			
			for (int i = 0; i < (sizePuzzle/2) ; i++) {

				emptyLocation = shiftRight(puzzle, emptyLocation);
				emptyLocation = solvePuzzel(puzzle, emptyLocation, sizePuzzle, focter);
				focter++;
				emptyLocation = shiftLeft(puzzle, emptyLocation);
				emptyLocation = solvePuzzel(puzzle, emptyLocation, sizePuzzle, focter);
				focter++;

			}
			
		} else {
			for (int i = 0; i < (sizePuzzle/2) ; i++) {

				emptyLocation = shiftRight(puzzle, emptyLocation);
				emptyLocation = solvePuzzel(puzzle, emptyLocation, sizePuzzle, focter);
				focter++;
				emptyLocation = shiftLeft(puzzle, emptyLocation);	
				emptyLocation = solvePuzzel(puzzle, emptyLocation, sizePuzzle, focter);
				focter++;

			}	
			    shiftRight(puzzle, emptyLocation);
		}
	}
}
		
	

