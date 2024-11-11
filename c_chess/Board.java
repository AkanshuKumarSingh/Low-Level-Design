package c_chess;

import java.util.Queue;

import c_chess.pieces.Bishop;
import c_chess.pieces.King;
import c_chess.pieces.Knight;
import c_chess.pieces.Pawn;
import c_chess.pieces.Piece;
import c_chess.pieces.Queen;
import c_chess.pieces.Rook;

public class Board {
    final Piece board[][];

    public Board(){
        board = new Piece[8][8];
        initializeBoard();
    }
        
    private void initializeBoard() {
        board[0][0] = new Rook(Color.WHITE, 0,0);
        board[0][1] = new Knight(Color.WHITE, 0,1);
        board[0][2] = new Bishop(Color.WHITE, 0,2);
        board[0][3] = new Queen(Color.WHITE, 0,3);
        board[0][4] = new King(Color.WHITE, 0,4);
        board[0][5] = new Rook(Color.WHITE, 0,7);
        board[0][6] = new Knight(Color.WHITE, 0,6);
        board[0][7] = new Bishop(Color.WHITE, 0,5);
        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(Color.WHITE, 1, i);
        }

        board[7][0] = new Rook(Color.WHITE, 7,0);
        board[7][1] = new Knight(Color.WHITE, 7,1);
        board[7][2] = new Bishop(Color.WHITE, 7,2);
        board[7][3] = new Queen(Color.WHITE, 7,3);
        board[7][4] = new King(Color.WHITE, 7,4);
        board[7][5] = new Rook(Color.WHITE, 7,7);
        board[7][6] = new Knight(Color.WHITE, 7,6);
        board[7][7] = new Bishop(Color.WHITE, 7,5);
        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.WHITE, 6, i);
        }
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }

    public boolean isMoveValid(Move move, Player player) {
        // TODO: Implement checkmate logic
        return true;
    }

    public boolean isCheckmate(Player player) {
        // TODO: Implement checkmate logic
        return false;
    }

    public boolean isStalemate(Player player) {
        // TODO: Implement stalemate logic
        return false;
    }


}
