package c_chess;

import c_chess.pieces.Piece;

public class Move {
    private final int destRow;
    private final int destCol;
    private final Piece piece;
    
    public Move(int destRow, int destCol, Piece piece) {
        this.destRow = destRow;
        this.destCol = destCol;
        this.piece = piece;
    }

    public int getDestRow() {
        return destRow;
    }

    public int getDestCol() {
        return destCol;
    }

    public Piece getPiece() {
        return piece;
    }

}
