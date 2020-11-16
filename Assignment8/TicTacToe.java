package Assignment8;

import java.util.*;

public class TicTacToe {
    private static ArrayList<Integer> playerPositions = new ArrayList<>();
    private static ArrayList<Integer> cpuPositions = new ArrayList<>();

    public static void main(String[] args) {
        char[][] gameBoard = {
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
                {'-', '+', '-', '+', '-'},
                {' ', '|', ' ', '|', ' '},
        };

        printGameBoard(gameBoard);


        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter your placement (1-9): ");
            int playerPos = scanner.nextInt();
            // write your code here

            while (playerPositions.contains(playerPos) || cpuPositions.contains(playerPositions)) {
                   // || playerPositions.contains(playerPositions)
                    //||playerPositions.contains(cpuPos)) {
                System.out.println("Invalid position, enter another placement (1-9)");
                playerPos = scanner.nextInt();
            }

            placePiece(gameBoard, playerPos, "player");
            Random random = new Random();
            int cpuPos = random.nextInt(9) + 1;
            while (playerPositions.contains(cpuPos) || cpuPositions.contains(cpuPos)) {
                // || cpuPositions.contains(cpuPositions)
                cpuPos = random.nextInt(9) + 1;
            }
            placePiece(gameBoard, cpuPos, "cpu");
            printGameBoard(gameBoard);
            String check = checkWinner();
            if (!check.equals("")) {
                System.out.println(checkWinner());
                break;
            }
        }
    }

    public static void printGameBoard(char[][] gameBoard) {
        for (char[] ch : gameBoard) {
            for (char c : ch) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static void placePiece(char[][] gameBoard, int pos, String user) {

        char symbol = ' ';
        if (user.equals("player")) {
            symbol = 'X';
            playerPositions.add(pos);
        } else if (user.equals("cpu")) {
            symbol = 'O';
            cpuPositions.add(pos);
        }

        // write your code here
        if (pos > 1 || pos > 9) {
            System.out.println("Invalid position");
        }
        int row = (pos - 1) / 3 * 2;
        int col = (pos - 1) % 3 * 2;
        gameBoard[row][col] = symbol;
    }

    public static String checkWinner() {
        // write your code here
        List<Integer> row1 = Arrays.asList(1, 2, 3);
        List<Integer> row2 = Arrays.asList(4, 5, 6);
        List<Integer> row3 = Arrays.asList(7, 8, 9);
        List<Integer> col1 = Arrays.asList(1, 4, 7);
        List<Integer> col2 = Arrays.asList(2, 5, 8);
        List<Integer> col3 = Arrays.asList(3, 6, 9);
        List<Integer> cross1 = Arrays.asList(1, 5, 9);
        List<Integer> cross2 = Arrays.asList(7, 5, 3);

        List<List<Integer>> checkWiner = new ArrayList<>();
        checkWiner.add(row1);
        checkWiner.add(row2);
        checkWiner.add(row3);
        checkWiner.add(col1);
        checkWiner.add(col2);
        checkWiner.add(col3);
        checkWiner.add(cross1);
        checkWiner.add(cross2);

        for (List<Integer> list : checkWiner) {
            if (playerPositions.containsAll(list)) {
                return "Congratulations you won!";
            } else if (cpuPositions.containsAll(list)) {
                return "CPU wins! Sorry:(";
            } else if (playerPositions.size() + cpuPositions.size() == 9) {
                return "CAT!";
            }
        }
        return "";
    }
}

