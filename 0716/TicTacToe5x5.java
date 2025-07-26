import java.util.Scanner;

public class TicTacToe5x5 {
    private static final int SIZE = 5;
    private static final char EMPTY = '.';
    private static final char PLAYER_X = 'X';
    private static final char PLAYER_O = 'O';

    static char[][] initializeBoard() {
        char[][] board = new char[SIZE][SIZE];
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = EMPTY;
            }
        }
        return board;
    }

    static void printBoard(char[][] board) {
        System.out.println("\n  圈圈叉叉 5x5 棋盤");
        System.out.print("   ");
        for (int col = 0; col < SIZE; col++) {
            System.out.print(col + " ");
        }
        System.out.println();
        
        for (int row = 0; row < SIZE; row++) {
            System.out.print(row + "  ");
            for (int col = 0; col < SIZE; col++) {
                System.out.print(board[row][col] + " ");
            }
            System.out.println();
        }
    }

    static boolean placePiece(char[][] board, int row, int col, char player) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
            System.out.println("⚠️ 無效座標，請重新輸入。");
            return false;
        }
        if (board[row][col] != EMPTY) {
            System.out.println("⚠️ 位置已被佔用，請重新輸入。");
            return false;
        }
        board[row][col] = player;
        return true;
    }

    static char checkWinner(char[][] board) {
        // 檢查所有行、列與對角線是否有連續5個相同符號
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                char player = board[row][col];
                if (player == EMPTY) continue;

                // 水平
                if (col <= SIZE - 5 && 
                    player == board[row][col+1] &&
                    player == board[row][col+2] &&
                    player == board[row][col+3] &&
                    player == board[row][col+4]) {
                    return player;
                }

                // 垂直
                if (row <= SIZE - 5 && 
                    player == board[row+1][col] &&
                    player == board[row+2][col] &&
                    player == board[row+3][col] &&
                    player == board[row+4][col]) {
                    return player;
                }

                // 主對角線
                if (row <= SIZE - 5 && col <= SIZE - 5 &&
                    player == board[row+1][col+1] &&
                    player == board[row+2][col+2] &&
                    player == board[row+3][col+3] &&
                    player == board[row+4][col+4]) {
                    return player;
                }

                // 反對角線
                if (row <= SIZE - 5 && col >= 4 &&
                    player == board[row+1][col-1] &&
                    player == board[row+2][col-2] &&
                    player == board[row+3][col-3] &&
                    player == board[row+4][col-4]) {
                    return player;
                }
            }
        }
        return EMPTY;
    }

    static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                if (board[row][col] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = initializeBoard();
        char currentPlayer = PLAYER_X;

        System.out.println("=== 5x5 圈圈叉叉遊戲開始！===");
        printBoard(board);

        while (true) {
            System.out.printf("玩家 %c 請輸入座標 (row col): ", currentPlayer);
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (placePiece(board, row, col, currentPlayer)) {
                printBoard(board);

                char winner = checkWinner(board);
                if (winner != EMPTY) {
                    System.out.printf("\n🎉 玩家 %c 獲勝！\n", winner);
                    break;
                } else if (isBoardFull(board)) {
                    System.out.println("\n🤝 平手！棋盤已滿。");
                    break;
                }

                currentPlayer = (currentPlayer == PLAYER_X) ? PLAYER_O : PLAYER_X;
            }
        }

        scanner.close();
    }
}
