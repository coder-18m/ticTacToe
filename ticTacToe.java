// tictactoe

import java.util.*;

public class ticTacToe {
    public static final String XINPUT = "❌";
    public static final String OINPUT = "⭕";


    public static void main(String[] args) {

        // prompt the user to ask if they want to play vs the computer or vs another player
        //making it so you can play the computer?
        // add a randoom selection after the user has inputted a choice

        Scanner scanny = new Scanner(System.in);
        
        String[][] grid = {
                    {"open", "open", "open"},
                    {"open", "open", "open"},
                    {"open", "open", "open"}
                    };
        openScreen();
        playGame(scanny, grid);
        // coordinatePrompt(1, 2, "X's", scanny);
        
    }

    public static void openScreen() {
        System.out.println("Welcome to TicTacToe! (▀̿Ĺ̯▀̿ ̿)");
        System.out.println();
        System.out.println("Rules: ");
        System.out.println("Select an X and O player. Each coordinate entry must range from 0,2. First to get 3 in a row wins.");


        System.out.println();
    }

    public static String[][] playingGrid(String[][] grid) {
        int gridWidth = grid[0].length;

        for (int i = 0; i < gridWidth; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        System.out.println();
        return grid;

    }

    public static String playGame(Scanner scanny, String[][] grid) {
        // moves counter
        int moves = 0;

            while (moves < 9) {
                playingGrid(grid);
                if (checkColumnWin(grid) == true || checkDiagonalWin(grid) == true || checkRowsWin(grid) == true) {
                    if (checkColumnWin(grid) == true) {
                        System.out.println("Game over! Womp Womp for the loser :(");
                    }
                    if (checkDiagonalWin(grid) == true) {
                        System.out.println("Game over! Womp Womp for the loser :(");
                    }
                    if (checkRowsWin(grid) == true) {
                        System.out.println("Game over! Womp Womp for the loser :(");
                    }
                    return "Game over!";
                }
                
                // X input is hereeeeeee
                int xInputY = coordinatePrompt("X's", "y", scanny);
                int xInputX = coordinatePrompt("X's", "x", scanny);
                System.out.println();

                if (!grid[xInputY][xInputX].equals("open")) {
                    System.out.println("Womp Womp... this spot it taken please try again...");
                    xInputY = coordinatePrompt("X's", "y", scanny);
                    xInputX = coordinatePrompt("X's", "x", scanny);

                    while (!grid[xInputY][xInputX].equals("open")) {
                        System.out.println("Womp Womp... this spot it taken please try again...");
                        xInputY = coordinatePrompt("X's", "y", scanny);
                        xInputX = coordinatePrompt("X's", "x", scanny);
                    }
                } else {
                    moves++;

                }
                grid[xInputY][xInputX] = XINPUT;

                //check win conditions
                playingGrid(grid);
                if (checkColumnWin(grid) == true || checkDiagonalWin(grid) == true || checkRowsWin(grid) == true) {
                    if (checkColumnWin(grid) == true) {
                        System.out.println("Game over! Womp Womp for the loser :(");
                    }
                    if (checkDiagonalWin(grid) == true) {
                        System.out.println("Game over! Womp Womp for the loser :(");
                    }
                    if (checkRowsWin(grid) == true) {
                        System.out.println("Game over! Womp Womp for the loser :(");
                    }
                    return "Game over!";
                }

                
                // O input is hereeeeeeeee
                int oInputY = coordinatePrompt("O's", "y", scanny);
                int oInputX = coordinatePrompt("O's", "x", scanny);

                if (!grid[oInputY][oInputX].equals("open")) {
                    System.out.println("Womp Womp... this spot it taken please try again...");
                    oInputY = coordinatePrompt("X's", "y", scanny);
                    oInputX = coordinatePrompt("X's", "x", scanny);

                    while (!grid[oInputY][oInputX].equals("open")) {
                        System.out.println("Womp Womp... this spot it taken please try again...");
                        oInputY = coordinatePrompt("X's", "y", scanny);
                        oInputX = coordinatePrompt("X's", "x", scanny);
                    }
                } else {
                    moves++;
                    System.out.println(moves);
                }
                grid[oInputY][oInputX] = OINPUT;


                System.out.println("The number of moves is at " + moves);
                System.out.println();
                
            }
        
        return "";

    }

    public static int coordinatePrompt(String player, String plane, Scanner scanny) {
        System.out.print("What index " + plane + " value would you like for " + player + "? ");
        int coorValue = scanny.nextInt();

        if (0 > coorValue || coorValue > 2) {
            System.out.print("This is not within 0 to 2, please re-enter move: ");
            coorValue = scanny.nextInt();
            while (0 > coorValue || coorValue > 2) {
                System.out.print("This is not within 0 to 2, please re-enter move: ");
                coorValue = scanny.nextInt();
            }
        // System.out.print("What index x value would you like for " + player + "? ");
        // int coorXValue = scanny.nextInt();

        // if (0 > coorXValue || coorXValue > 2) {
        //     System.out.print("This is not within 0 to 2, please re-enter move: ");
        //     coorXValue = scanny.nextInt();
        //     while (0 > coorXValue || coorXValue > 2) {
        //         System.out.print("This is not within 0 to 2, please re-enter move: ");
        //         coorXValue = scanny.nextInt();
        //     }
        }
        return coorValue;
    }
    

    // =========Ending Conditions Methods ============== \(￣︶￣*\))

    public static boolean checkColumnWin(String[][] grid) {
        boolean win = false;
        
        // loop through whole array, if there are 3 matching j values that equal the same input, then there's a column win
        // for (int i = 0; i < grid.length; i++) {
        //     for (int j = 0; j < grid.length[i]; j++) {
        //         if (!gird[i][j].equals("open")) {

        //         }
                
        //     }
        // }

        // return false;
        if (grid[0][0].equals(XINPUT) && grid[1][0].equals(XINPUT) && grid[2][0].equals(XINPUT)) {
            win = true;
            return win;
        }
        if (grid[0][1].equals(XINPUT) && grid[1][1].equals(XINPUT) && grid[2][1].equals(XINPUT)) {
            win = true;
            return win;
        }

        if (grid[0][2].equals(XINPUT) && grid[1][2].equals(XINPUT) && grid[2][2].equals(XINPUT)) {
            win = true;
            return win;
        }
        if (grid[0][0].equals(OINPUT) && grid[1][0].equals(OINPUT) && grid[2][0].equals(OINPUT)) {
            win = true;
            return win;
        }
        if (grid[0][1].equals(OINPUT) && grid[1][1].equals(OINPUT) && grid[2][1].equals(OINPUT)) {
            win = true;
            return win;
        }

        if (grid[0][2].equals(OINPUT) && grid[1][2].equals(OINPUT) && grid[2][2].equals(OINPUT)) {
            win = true;
            return win;
        }

         return win;

    }

    public static boolean checkRowsWin(String[][] grid) {
        boolean win = false;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                
                if (j == 0){
                    if (grid[i][j].equals(XINPUT)) {
                        if (grid[i][j + 1].equals(XINPUT)){
                            if (grid[i][j + 2].equals(XINPUT)) {
                                win = true;
                                return win;
                                }
                            }
                        }
                        if (grid[i][j].equals(OINPUT)) {
                        if (grid[i][j + 1].equals(OINPUT)){
                            if (grid[i][j + 2].equals(OINPUT)) {
                                win = true;
                                return win;
                                }
                            }
                        }

                }
                if (j == 1 && grid[i][0].equals(XINPUT)) {
                    if (grid[i][j].equals(XINPUT)) {
                        if (grid[i][j + 1].equals(XINPUT)) {
                            win = true;
                            return win;
                        }

                    }
                }
                if (j == 1 && grid[i][0].equals(OINPUT)) {
                    if (grid[i][j].equals(OINPUT)) {
                        if (grid[i][j + 1].equals(OINPUT)) {
                            win = true;
                            return win;
                    }

                    }
                }

                if (j == 2 && grid[i][0].equals(XINPUT) && grid[i][1].equals(XINPUT)) {
                        if (grid[i][j].equals(XINPUT)) {
                            win = true;
                            return win;
                        }
                    
                }

                if (j == 2 && grid[i][0].equals(OINPUT) && grid[i][1].equals(OINPUT)) {
                        if (grid[i][j].equals(OINPUT)) {
                            win = true;
                            return win;
                        }
                    
                }
            }

        }
        
        
        return win;

    }

    public static boolean checkDiagonalWin(String[][] grid) {
        boolean win = false;

        if (grid[0][0].equals(XINPUT) && grid[1][1].equals(XINPUT) && grid[2][2].equals(XINPUT)) {
            win = true;
            return win;
        }
        if (grid[0][0].equals(OINPUT) && grid[1][1].equals(OINPUT) && grid[2][2].equals(OINPUT)) {
            win = true;
            return win;
        }

        if (grid[0][2].equals(XINPUT) && grid[1][1].equals(XINPUT) && grid[2][0].equals(XINPUT)) {
            win = true;
            return win;
        }
        if (grid[0][2].equals(OINPUT) && grid[1][1].equals(OINPUT) && grid[2][0].equals(OINPUT)) {
            win = true;
            return win;
        }
         return win;
    }

    public static boolean checkDraw(String [][] grid) {
         return false;
    }
}