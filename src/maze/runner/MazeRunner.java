package maze.runner;

import java.util.Scanner;

public class MazeRunner 
{
    public static void main(String[] args) 
    {
        Scanner userInput = new Scanner(System.in);
        
        System.out.print("How many rows are in the maze? ");
        int rows = userInput.nextInt();
        System.out.print("How many columns are in the maze? ");
        int cols = userInput.nextInt();
        
        int[][] boardArray = new int[rows][cols];
        for(int i = 0; i < boardArray.length; i++)
        {
            System.out.print("Enter the danger in row " 
                    + i + ", separated by spaces: ");
            for(int j = 0; j < boardArray[0].length; j++)
            {
                boardArray[i][j] = userInput.nextInt();
            }
        }
        
        System.out.print("Enter the starting x coordinate: ");
        int xStart = userInput.nextInt();
        System.out.print("Enter the starting y coordinate: ");
        int yStart = userInput.nextInt();
        
        int playerPosition = Integer.MAX_VALUE;
        boardArray[xStart][yStart] = playerPosition;
        
        for(int i = 0; i < boardArray.length; i++)
        {
            for(int j = 0; j < boardArray[0].length; j++)
            {
                if(boardArray[i][j] == playerPosition)
                {
                    System.out.print("* ");
                }
                else
                {
                    System.out.print(boardArray[i][j] + " ");
                }
            }
            System.out.println("");
        }

        boolean continuePath = true;
        int sum = 0;
        while(continuePath)
        {
            for(int i = 0; i < boardArray.length; i++)
            {
                for(int j = 0; j < boardArray[0].length; j++)
                {
                    if((boardArray[0][j] < playerPosition) || 
                       (boardArray[i][0] < playerPosition) || 
                       (boardArray[rows][j] < playerPosition) || 
                       (boardArray[i][cols] < playerPosition))
                    {
                        System.out.println("Moving to " + i + "," 
                                + j + "(danger level " 
                                + boardArray[i][j] + ")");
                        sum += boardArray[i][j];
                        boardArray[i][j] = playerPosition;
                        if(boardArray[i][j] == playerPosition)
                        {
                            System.out.print("* ");
                        }
                        else
                        {
                            System.out.print(boardArray[i][j] + " ");
                        }
                        System.out.println("Exited the world at " 
                                + i + "," + j);
                        System.out.println("Total danger faced: " + sum);
                        continuePath = false;
                    }
                    else if((boardArray[i+1][j] < playerPosition) ||
                            (boardArray[i-1][j] < playerPosition) ||
                            (boardArray[i][j+1] < playerPosition) ||
                            (boardArray[i][j-1] < playerPosition))
                    {
                        System.out.println("Moving to " + i + "," 
                                + j + "(danger level " 
                                + boardArray[i][j] + ")");
                        sum += boardArray[i][j];
                        boardArray[i][j] = playerPosition;
                        if(boardArray[i][j] == playerPosition)
                        {
                            System.out.print("* ");
                        }
                        else
                        {
                            System.out.print(boardArray[i][j] + " ");
                        }
                    }
                }
            }
        }
    }  
}