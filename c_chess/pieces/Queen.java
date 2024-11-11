package c_chess.pieces;

import c_chess.Board;
import c_chess.Color;

public class Queen extends Piece {

    public Queen(Color color, int row, int col){
        super(color, row, col);
    }
    
    @Override
    public boolean canMove(Board board, int destRow, int destCol) {
        //TODO: To be implemented
        return true;
    }


}
