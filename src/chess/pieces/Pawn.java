package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece {
    private ChessMatch chessMatch;

    public Pawn(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "P";
    }

    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColums()];

        Position p = new Position(0,0);

        if (getColor() == Color.WHITE){
            p.setValues(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());

            if (getBoard().positionExists(p) && !getBoard().thereISAPiece(p)
                    && getBoard().positionExists(p2) && !getBoard().thereISAPiece(p2)
                    && getMoveCount() == 0){
                matrix[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() - 1, position.getColumn() - 1);

            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() - 1, position.getColumn() + 1);

        }else {

            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionExists(p) && !getBoard().thereISAPiece(p)
                    && getBoard().positionExists(p2) && !getBoard().thereISAPiece(p2)
                    && getMoveCount() == 0){
                matrix[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionExists(p) && isThereOpponentPiece(p)){
                matrix[p.getRow()][p.getColumn()] = true;
            }


            p.setValues(position.getRow() + 1, position.getColumn() + 1);
        }

        if (getBoard().positionExists(p) && !getBoard().thereISAPiece(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        return matrix;
    }
}
