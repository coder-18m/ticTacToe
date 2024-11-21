import java.util.*;

public class ticTacToe {
    public static final String XINPUT = "❌";
    public static final String OINPUT = "⭕";


    public static void main(String[] args) {
        
        Scanner scanny = new Scanner(System.in);
        
        String[][] grid = {
                    {"open", "open", "open"},
                    {"open", "open", "open"},
                    {"open", "open", "open"}
                    };

        ticTacToe(scanny, grid);
        
    }
    public static String ticTacToe(Scanner scanny, String[][] grid) {
        int moves = 0;

        // grid[2][0] = "x";
        int gridWidth = grid[0].length;
        System.out.println("Welcome to TicTacToe (づ￣ 3￣)づ");
        System.out.println();
            // System.out.print(Arrays.toString(grid[i]));
            for (int j = 0; j < gridWidth; j++) {
                System.out.println(Arrays.toString(grid[j]));
            }

        // while not 3 Os in a row/diagonal or 3 X in a row/diagonal or 9 moves have been made--> do all this
        // print the available spaces for a move.. if not available reprint
        // dont allow inputs to change once inputed
        
        while (moves < 9){
            // check if 3 x in a row
            // check if 3 o in a row

            // ask for the coordinate inputs 
            System.out.println();
            System.out.print("What index x value would you like the X's? ");
            int xLength = scanny.nextInt();
            System.out.println();

            System.out.print("What index y value would you like the X's? ");
            int xWidth = scanny.nextInt();
            System.out.println();

            // System.out.print("Enter X to play: ");
            // String xInput = scanny.next();

            System.out.println();

            if (!grid[xLength][xWidth].equals("open")) {
                System.out.println();
                System.out.println("Womp womp...This spot is taken! Please pick a new spot...");
                System.out.print("What index x value would you like the X's? ");
                xLength = scanny.nextInt();
                System.out.println();

                System.out.print("What index y value would you like the X's? ");
                xWidth = scanny.nextInt();
                grid[xLength][xWidth] = XINPUT;
                System.out.println();
            }

            grid[xLength][xWidth] = XINPUT;

            //check checkWin
            if (checkWin(grid) == true) {
                System.out.println("Game over! X's win!");
                for (int j = 0; j < gridWidth; j++) {
                    System.out.println(Arrays.toString(grid[j]));
                }
                return "Game Over!";
            }

            moves++;

            //----------FOR O's--------------

            // System.out.print(Arrays.toString(grid[i]));
            for (int j = 0; j < gridWidth; j++) {
                System.out.println(Arrays.toString(grid[j]));
            }
            System.out.println();
            System.out.print("What index y value would you like the O's? ");
            int oLength = scanny.nextInt();
            System.out.println();

            System.out.print("What index y value would you like the O's? ");
            int oWidth = scanny.nextInt();
            System.out.println();

            // System.out.print("Enter O to play: ");
            // String oInput = scanny.next();
            System.out.println();

            if (!grid[oLength][oWidth].equals("open")) {
                System.out.println();
                System.out.println("Womp womp...This spot is taken! Please pick a new spot...");
                System.out.print("What index y value would you like the O's? ");
                oLength = scanny.nextInt();
                System.out.println();

                System.out.print("What index y value would you like the O's? ");
                oWidth = scanny.nextInt();
                System.out.println();

                grid[oLength][oWidth] = OINPUT;
            }

            grid[oLength][oWidth] = OINPUT;

            //checkWin
            if (checkWin(grid) == true) {
                System.out.println("Game over! O's win!");
                System.out.println();
                for (int j = 0; j < gridWidth; j++) {
                    System.out.println(Arrays.toString(grid[j]));
                }
                return "Game Over!";
            }


            moves++;

            for (int j = 0; j < gridWidth; j++) {
                System.out.println(Arrays.toString(grid[j]));
            }
        }

        return "Draw!";
    }

    

    public static boolean checkWin(String[][] grid) {
        boolean win = false;
        // check diagonals
        // start at corners and check grid[0][0], g[1][1], g[2][2] and in reverse for each
            // grid[0][2], grid [1][1], grid[2][0]
            // if these are filled, --> print winners
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

        for (int i = 0; i < grid.length; i++) {

            // Check in columns
            if (i == 0) {
                
                if (grid[i].equals(XINPUT)) {
                    if (grid[i + 1].equals(XINPUT)){
                        if (grid[i + 2].equals(XINPUT)){
                            win = true;
                            return win;
                        }
                    }
                }
                if (grid[i].equals(OINPUT)) {
                    if (grid[i + 1].equals(OINPUT)){
                        if (grid[i + 2].equals(OINPUT)){
                            win = true;
                            return win;
                        }
                    }
                }
            }

            if (i == 1 && grid[i - 1].equals(OINPUT)) {
                if (grid[i].equals(XINPUT)) {
                    if (grid[i + 1].equals(XINPUT)) {
                        win = true;
                        return win;
                    }
                }
            }
            if (i == 1 && grid[i - 1].equals(OINPUT)) {
                if (grid[i].equals(XINPUT)) {
                    if (grid[i + 1].equals(OINPUT)) {
                        win = true;
                        return win;
                    }
                }
            }

            if (i == 2 && grid[i - 1].equals(XINPUT) && grid[i - 2].equals(XINPUT)) {
                if (grid[i].equals(XINPUT)) {
                    win = true;
                    return win;
                }
            }
            if (i == 2 && grid[i - 1].equals(OINPUT) && grid[i - 2].equals(OINPUT)) {
                if (grid[i].equals(OINPUT)) {
                    win = true;
                    return win;
                }
            }




            // Check in rows
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
}