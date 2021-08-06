package Coditation_Assignment;
import java.util.*;

public class Main {
	
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter 1 for default/hard coded input \n2 for user input: ");
		int choice = sc.nextInt();
		char[][] board = {{'1', '0', '0', '1'},
				  {'1', '0', '1', '0'},
				  {'0', '1', '1', '0'},
				  {'0', '0', '0', '1'}};
		
		char live = '1', dead = '0';
		
		int rows=0, cols=0;
		
		switch(choice) {
		case 1:
			userInputBoard(false, board, rows, cols, live, dead);
			break;
			
		case 2:
			System.out.print("Enter symbol or value to define the state \nLive = ");
			live = sc.next().charAt(0);
			System.out.print("Dead = ");
			dead = sc.next().charAt(0);
			
			System.out.print("Enter board dimentions\nNo. of Rows = ");
			rows = sc.nextInt();
			System.out.print("No. of Columns = ");
			cols = sc.nextInt();
			
			if (rows * cols > 100)
			{
				System.out.print("Maximum number of cells is 100\nPlease try again");
				throw new IllegalArgumentException("Maximum number of cells is 100");
			}
			userInputBoard(true,board, rows, cols, live, dead);
			break;
		default:
			System.out.print("Invalid choice entered");
			throw new IllegalArgumentException("Invalid input");
		}
		sc.close();
		
	}
	
	
	
	static void userInputBoard(boolean inputFlag, char[][] inputBoard, int rows, int cols, char live, char dead) {
		
		try (Scanner sc1 = new Scanner(System.in)) {
			if(inputFlag) {
			System.out.println("Enter each row in space separated format:");
			inputBoard = new char[rows][];
			for(int i = 0; i < rows; i++) {
				String temp = sc1.nextLine();
				String[] currRow = temp.split(" ");
				if(currRow.length != cols) {
					System.out.print("number of cells in previous row is not equal to "+cols);
					throw new IllegalArgumentException("Invalid Input");
				}
				else {
					char[] row = new char[currRow.length];
					for(int ele = 0; ele < currRow.length; ele++)
						row[ele] = currRow[ele].charAt(0);
					
					inputBoard[i] = row;
				}
			}
			
			}
			
			GameOfCells obj = new GameOfCells(live, dead);
			char[][] nextGen = obj.getNextGenerationBoard(inputBoard);
			
			System.out.println("Input Board:");
			obj.printBoard(inputBoard);
			System.out.println("Live is represented as "+live+"\nDead is represented as "+dead+"\n\n");
			
			int gen = 1;
			boolean flag = true;
			
				while(flag) {
					System.out.println("Generation "+gen);
					obj.printBoard(nextGen);
					int choice = 0;
					
					System.out.print("Press \n1 to continue\n2 to exit\n3 to search element\nchoice = ");
					if(sc1.hasNextInt()) {
						choice = sc1.nextInt();
					}
					else
						choice = 5;
					
					switch(choice) {
					case 1:
						break;
					case 2:
						flag = false;
						break;
					case 3:
						System.out.print("Enter cell name in row_column format: ");
						String name = sc1.next();
						System.out.println("State of cell "+name+": "+obj.getCellState(nextGen, name));
						break;
					default:
						System.out.print("Invalid choice entered");
						flag = false;
					}
					
					if(flag) {
						gen++;
						nextGen = obj.getNextGenerationBoard(nextGen);
					}
					System.out.println("");
				}
		}
	}
}
