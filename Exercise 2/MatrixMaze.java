package task_2;

import java.util.Scanner;

public class MatrixMaze {
	
	public static int saveMazeMoves (int[][]mazeMoves ,int row , int column , int saveLocation) {
		//save player move
		mazeMoves[0][saveLocation] = row;
		mazeMoves[1][saveLocation] = column;
		saveLocation++;
		return saveLocation ;
	}
    
	public static int entryFromAbove (char[][] matrixMaze ,int[][]entryPoint ,int saveEntryPoint , int numColumn) {
		//Looking for entry from above
		for (int i = 0; i < numColumn ; i++) {
			
			if (matrixMaze [0][i] == 'v') {
				entryPoint[0][saveEntryPoint] = 0;
				entryPoint[1][saveEntryPoint] = i;
				
				saveEntryPoint++;
			}
		}
		return saveEntryPoint;
	}
    
	public static int entryFromDown (char[][] matrixMaze ,int[][]entryPoint ,int saveEntryPoint , int numColumn , int numRow) {
		//Looking for entry from down
		for (int i = 0; i < numColumn; i++) {
			
			if (matrixMaze [numRow-1][i] == '^') {
				entryPoint[0][saveEntryPoint] = numRow-1;
				entryPoint[1][saveEntryPoint] = i;
				
				saveEntryPoint++;
			}
		}
		return saveEntryPoint;
	}
	
	public static int entryFromLeft (char[][] matrixMaze ,int[][]entryPoint ,int saveEntryPoint , int numRow) {
		//Looking for entry from left
		for (int i = 0; i < numRow; i++) {
			
			if (matrixMaze [i][0] == '>') {
				entryPoint[0][saveEntryPoint] = i;
				entryPoint[1][saveEntryPoint] = 0;
				
				saveEntryPoint++;
			}
		}
		return saveEntryPoint;
	}
	
	public static int entryFromRight (char[][] matrixMaze ,int[][]entryPoint ,int saveEntryPoint , int numRow ,  int numColumn) {
		//Looking for entry from right
		for (int i = 0; i < numRow; i++) {
			
			if (matrixMaze [i][numColumn-1] == '<') {
				entryPoint[0][saveEntryPoint] = i;
				entryPoint[1][saveEntryPoint] = numColumn-1;
				
				saveEntryPoint++;
			}
		}
		return saveEntryPoint;
	}
	
	public static int lookAhead (char[][]matrixMaze,  int row , int column ,int lifePoint) {
		int move = 0;//Checking the next step
		switch (matrixMaze [row][column]) {
		case '*':
			System.out.println("BOOOOOM!!!");
			move = 5;
			break;	
		case '^':	
			System.out.println("Moving up");
			move = 1;
			break;
		case 'v':
			System.out.println("Moving down");
			move = 2;
			break;	
		case '>':
			System.out.println("Moving right");
			move = 3;
			break;	
		case '<':
			System.out.println("Moving left");
			move = 4;
			break;		
		case 'O':
			System.out.println("Empty area");
			break;	
		} return move;	
	}

	public static void checkExit (char[][]matrixMaze , int[][]entryPoint , int numRow , int numColumn ) {
		int row , column , move = 0;
		for (int i = 0; i < entryPoint[0].length; i++) {
			boolean end = false ,exitFound = false;
			int contStep = 0;
			row = entryPoint[0][i];
			column = entryPoint[1][i];
			do {
				switch (matrixMaze [row][column]) {
				case '^':	
					if (row == 0) {
						exitFound = true;
						break;
					} row--;	
					break;
				case 'v':
					if (row == numRow-1) {
						exitFound = true;
						break;
					} row++;
					break;
				case '>':
					if (column == numColumn-1) {
						exitFound = true;
						break;
					} column++;
					break;
				case '<':
					if (column == 0) {
						exitFound = true;
						break;
					} column--;
					break;	
				case '*':
					end = true;
					break;	
				case 'O':
					end = true;
					break;
				case '+':
					move = croosDirection(matrixMaze, row, column, numRow, numColumn);
					switch (move) {
					
					case 1:
						column++;
						break;
					case 2:
						row++;
						break;
					case 3:
						column--;
						break;
					case 4:
						row--;
						break;
					}
				}
				 contStep++;
				 if (contStep == 30) {
					break;
				}
			} while (exitFound != true && end != true);
			if (exitFound == true) {
			entryPoint[2][i] = contStep;	
			}
		}
	}

	public static int croosDirection (char[][]matrixMaze , int row , int column , int numRow , int numColumn) {
		//Checking which direction to go in croos
		int move;
		move = croosChackRight(matrixMaze, row, column , numColumn , numRow);
		if (move == 1 ) {
			return move;
		} 
		move = croosChackDown(matrixMaze, row, column , numRow ,numColumn);
		if (move == 2) {
			return move;
		}
		move = croosChackLeft(matrixMaze, row, column);
		if (move == 3) {
			return move;
		} 
		move = croosChackUp(matrixMaze, row, column , numColumn);
		if (move == 4) {
			return move;
		}
		return move;
	}
	
	public static int croosChackDown (char[][]matrixMaze , int row , int column , int numRow , int numColumn) {
		int move = 0 ,checker = row;
		if (checker != numRow-1) {
			if (matrixMaze [++checker][column] == 'v') {
				if (checker == numRow-1) {
					move = 5;	
				}
				row++;
				move = 2;
			} else {
				checker = row;
				if (matrixMaze [++checker][column] == '>') {
					if (column == numColumn-1) {
						move = 5;
					}
					row++;
					move = 2;
				} else {
					checker = row;
					if (matrixMaze [++checker][column] == '<') {
						if (checker == 0) {
							move = 5;
						} 
						row++;
						move = 2;	
					}
				}
			}
		}
		return move;
		}
	
	public static int croosChackUp (char[][]matrixMaze , int row , int column , int numColumn) {
		int move = 0 ,checker = row;

		if (checker != 0) {

			if (matrixMaze [--checker][column] == '^') {
				if (checker == 0) {
					move = 5;
				}
				row--;
				move = 4;	
			} else {
				checker = row;
				if (matrixMaze [--checker][column] == '>') {
					if (column == numColumn-1) {
						move = 5;
					} 
					row--;
					move = 4;	
				} else {
					checker = row;
					if (matrixMaze [--checker][column] == '<') {
						if (column == 0) {
							move = 5;
						} 
						row--;
						move = 4;
					}
				}
			}
		}
		return move;
		}
	
	public static int croosChackRight (char[][]matrixMaze , int row , int column ,int numColumn , int numRow) {
		int move = 0 ,checker = column;
		
		if (checker != numColumn) {
			checker = column;
			if (matrixMaze [row][++checker] == 'v') {	
				if (row == numRow-1) {
					move = 5;
				} 
				column++;
				move = 1;
			} else {
				checker = column;
				if (matrixMaze [row][++checker] == '>') {
					if (column == numColumn-1) {
						move = 5;
					} 
					column++;
					move = 1;
				} else {
					checker = column;
					if (matrixMaze [row][++checker] == '^') {
						if (row == 0) {
							move = 5;
						} 
						column++;
						move = 1;
					}
				}
			}
		}
		return move;
	}

	public static int croosChackLeft (char[][]matrixMaze , int row , int column) {
		int move = 0 ,checker = column;
		if (checker != 0) {
			checker = column;
			if (matrixMaze [row][--checker] == 'v') {
				if (row == 0) {
					move = 5;
				} 
				column--;
				move = 3;
			} else {
				checker = column;
				if (matrixMaze [row][--checker] == '<') {
					if (column == 0) {
						move = 5;
					}
					column--;
					move = 3;
				} else {
					checker = column;
					if (matrixMaze [row][--checker] == '^') {
						if (row == 0) {
							move = 5;
						}
						column--;
						move = 3;
					} 
				}
			}
		}
		return move;
	}

	public static int LongestWay (char[][]matrixMaze , int[][]entryPoint) {
	 //chack what is the longest way in the maze
		int longWay = 0;
	 int location = -1;
	 
		for (int i = 0; i < entryPoint.length; i++) {
			
			if (entryPoint[2][i]>longWay) {
				longWay = entryPoint[2][i];
				location = i;
			}
		}
		return location;
	}
	
	public static void printMazeSteps (int[][]mazeMoves ,int contStep) {
		//Prints all player moves
		for (int i = 0; i < contStep; i++) {
			System.out.printf("(%d,%d)" , mazeMoves[0][i] , mazeMoves[1][i]);

			if (i != contStep -1) {
				System.out.print("->");
			}
		}
	}
	
	public static void main(String[] args) {

		
		boolean exitFound = false;
		boolean takeARisk = false;
		int lifePoint, location , move, numRow , numColumn;
        int saveLocation  = 0 , contStep  = 0 , row = 0 , column = 0 , saveEntryPoint = 0;
        char playerAnswer , direction;
		char[][]matrixMaze;
		int[][] mazeMoves;
		int[][] entryPoint;
		
		
		Scanner sca = new Scanner(System.in);

		System.out.println("What size map would you like to play?");
		System.out.println("rows? (between 5-15):");
		numRow = sca.nextInt();
		System.out.println("columns? (between 5-15):");
		numColumn = sca.nextInt();
		System.out.println("How much life point?");
		lifePoint = sca.nextInt();

		entryPoint = new int [3][4*numColumn];

		if (lifePoint>=0) {
			
			if ((numRow >=5 && numRow<=15) && (numColumn >=5 && numColumn<=15)) {
				matrixMaze = new char[numRow][numColumn]; //start fill the maze
				System.out.println("Fill in the maze with the marks (v,^,<,>,O,*) [Press space between chars] ");
				for (int i = 0; i < numRow; i++) {
					
					for (int j = 0; j < numColumn; j++) {
						matrixMaze[i][j]= sca.next().charAt(0);
					}
				}
				for (int i = 0; i < matrixMaze.length; i++) {
					for (int j = 0; j < matrixMaze.length; j++) {

						if (matrixMaze[i][j] == 'V') {
							matrixMaze[i][j] = 'v';
						}
					}
				}

				//Checks the integrity of the maze that has an entry and exit
				saveEntryPoint = entryFromAbove(matrixMaze, entryPoint, saveEntryPoint ,numColumn );
				saveEntryPoint = entryFromDown(matrixMaze, entryPoint, saveEntryPoint ,numColumn , numRow);
				saveEntryPoint = entryFromLeft(matrixMaze, entryPoint, saveEntryPoint ,numRow);
				saveEntryPoint = entryFromRight(matrixMaze, entryPoint, saveEntryPoint ,numRow , numColumn);
				checkExit(matrixMaze, entryPoint , numRow , numColumn);
				location = LongestWay(matrixMaze, entryPoint);
				
				if (location != -1) {
					mazeMoves = new int [2][entryPoint[2][location]];
				} else {
					mazeMoves = new int [2][entryPoint[2][0]];
				}
				
				
				if (location != -1) {
                    
					row = entryPoint[0][location];
					column = entryPoint[1][location];
					System.out.printf("Starting at (%d,%d) with %d lives...\n" ,row , column  , lifePoint);
					saveLocation = saveMazeMoves(mazeMoves, row, column, saveLocation);


					while (lifePoint !=-1) {
                        //start play the maze
						move = lookAhead(matrixMaze, row, column, lifePoint);
						contStep++;

						if (matrixMaze[row][column] == '+') { // when see croos '+'

							System.out.println("I have reached a junction,");
							if (lifePoint == 0) {
								System.out.println("Will you take a chance to guess a direction? (yes or no)");
								playerAnswer = sca.next().charAt(0);

								if (playerAnswer =='y' || playerAnswer =='Y') {
									System.out.println("Which direction you want to continue on?");
									takeARisk = true;
									direction = sca.next().charAt(0);

									if (direction == '^') {
										if (row == 0) {
											System.out.printf("Exit on (%d,%d)\n" , row,column);
											exitFound = true;
											break;
										}
										row--;

									} else {
										if (direction == 'v') {
											if (row == numRow-1) {
												System.out.printf("Exit on (%d,%d)\n" , row,column);
												exitFound = true;
												break;
											}
											row++;

										} else {
											if (direction == '>') {
												if (column == numColumn-1) {
													System.out.printf("Exit on (%d,%d)\n" , row,column);
													exitFound = true;
													break;
												}
												column++;

											}else {
												if (direction == '<') {
													if (column == 0) {
														System.out.printf("Exit on (%d,%d)\n" , row,column);
														exitFound = true;
														break;
													}
													column--;
												}
											}
										}
									}	
								} else {
									System.out.println("You lose because you are a CHIKEN!\n");
									printMazeSteps(mazeMoves, contStep);
									break;
								}

							}	
							if (takeARisk == false) {

								System.out.println("I'm going to check the area...");
								if (column<numColumn-1) {
									column++;	
									if (matrixMaze[row][column] != '<') {
										System.out.printf("Looking to (%d,%d)\n" ,row , column);
										move = croosChackRight(matrixMaze, row, column, numColumn, numRow);
										move = lookAhead(matrixMaze, row, column,lifePoint);
									}
								}
							}
							if (move == 5 && lifePoint !=-1) { // move = 5 , When the player sees '*'
								lifePoint--;
								if (lifePoint == -1) {
									System.out.println("Game Over!!!");
									saveLocation = saveMazeMoves(mazeMoves, row, column , saveLocation);
									contStep++;
									printMazeSteps(mazeMoves, contStep);
									break;
								}
								System.out.printf("One life is gone, %d more left...\n" , lifePoint);
							}

							if ((move == 5 || move == 0) && lifePoint !=-1) { // move = 0 , When the player sees 'O' (empty area)
								column--;
								if (row<numRow-1) {
									row++;	
									if (matrixMaze[row][column] != '^') {
										System.out.printf("Looking to (%d,%d)\n" ,row , column);
										move = lookAhead(matrixMaze, row, column,lifePoint);

										if (move == 5 && lifePoint !=-1) {
											lifePoint--;
											System.out.printf("One life is gone, %d more left...\n" , lifePoint);
										}
									}
								}
							}
							if ((move == 0 || move == 5) && lifePoint !=-1) {
								row--;
								if (column != 0) {
									column--;
									if (matrixMaze[row][column] != '>') {
										System.out.printf("Looking to (%d,%d)\n" ,row , column);
										move = lookAhead(matrixMaze, row, column,lifePoint);
									}
								}
							}
							
							if ((move == 0 || move == 5) && lifePoint !=-1) {
								column++;
								if (row !=0) {
									row--;	

									if (matrixMaze[row][column] != 'v') {
										System.out.printf("Looking to (%d,%d)\n" ,row , column);
										move = lookAhead(matrixMaze, row, column,lifePoint);
									}
								}
							}
						}

						if (move == 5) { // move = 5 , When the player sees '*'
							lifePoint--;
							System.out.printf("One life is gone, %d more left...\n" , lifePoint);

						} else {
							if (move == 1) { // move = 1 , When the player sees '^'

								if (row == 0) {
									System.out.printf("Exit on (%d,%d)\n" , row,column);
									exitFound = true;
									break;
								}
								row--;

							} else {
								if (move == 2) { // move = 2 , When the player sees 'v'

									if (row == numRow-1) {
										System.out.printf("Exit on (%d,%d)\n" , row,column);
										exitFound = true;
										break;
									}
									row++;

								} else {
									if (move == 3) { // move = 3 , When the player sees '>'
										if (column == column-1) {
											System.out.printf("Exit on (%d,%d)\n" , row,column);
											exitFound = true;
											break;
										}
										column++;

									}else {
										if (move == 4) { // move = 4 , When the player sees '<'

											if (column == 0) {
												System.out.printf("Exit on (%d,%d)\n" , row,column);
												exitFound = true;
												break;
											}
											column--;
										}
									}
								}
							}
						}

						saveLocation = saveMazeMoves(mazeMoves, row, column , saveLocation);
					}

					sca.close();

					if (exitFound == true) {
						printMazeSteps(mazeMoves, contStep);
					}

				} else {
					System.out.println("The route you entered is invalid");
				}


			} else {
				System.out.println("Only possible between 5-15 \nGoodbye");
			}

		} else {
			System.out.println("You have to put positive numbers in life point!!");
		}
		
	}
}
			

