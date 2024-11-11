package c_chess;

import java.util.Scanner;

public class ChessGame {    
    private final Board board;
    private final Player[] players;
    private int currentPlayer;
    
    public ChessGame(Board board, Player[] players, int currentPlayer) {
        this.board = board;
        this.players = players;
        this.currentPlayer = currentPlayer;
    }

    public void start(){
        while (!isGameOver()) {
            Player player = players[currentPlayer];
            System.out.println(player.getColor() + " turn");

            Move move = getPlayerMove();
            try{
                board.isMoveValid(move, player);
            } catch (InvalidMoveException e){
                System.out.println(e.getMessage());
                System.err.println("Try Again");
                continue;
            }
            
            player.makeMove(board, move);
            currentPlayer = (currentPlayer + 1)%2;

        }
    }

    private boolean isGameOver(){
        return (
            board.isCheckmate(players[0]) || board.isCheckmate(players[1]) || 
            board.isStalemate(players[0]) || board.isStalemate(players[1])
        );
    }

    private Move getPlayerMove(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source row: ");
        int sourceRow = scanner.nextInt();
        System.out.print("Enter source column: ");
        int sourceCol = scanner.nextInt();
        System.out.print("Enter destination row: ");
        int destRow = scanner.nextInt();
        System.out.print("Enter destination column: ");
        int destCol = scanner.nextInt();
        return new Move(destRow, destCol, board.getPiece(sourceRow, sourceCol));
    }

}
