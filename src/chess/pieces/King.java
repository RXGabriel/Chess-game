package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece {
    private ChessMatch chessMatch;

    public King(Board board, Color color, ChessMatch chessMatch) {
        super(board, color);
        this.chessMatch = chessMatch;
    }

    @Override
    public String toString() {
        return "K";
    }

    private boolean canMove(Position position){
        ChessPiece piece = (ChessPiece) getBoard().piece(position);
        return piece == null || piece.getColor() != getColor();
    }
    //
    private boolean testRookCastling(Position position){
        ChessPiece piece = ((ChessPiece) getBoard().piece(position));
        return piece instanceof Rook && piece.getColor() == getColor() && piece.getMoveCount() == 0;
    }


    @Override
    public boolean[][] possibleMoves() {
        boolean[][] matrix = new boolean[getBoard().getRows()][getBoard().getColums()];

        Position p = new Position(0,0);

        //above
        p.setValues(position.getRow() - 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //below
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //left
        p.setValues(position.getRow() , position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(position.getRow(), position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //nw
        p.setValues(position.getRow() - 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //ne
        p.setValues(position.getRow() - 1, position.getColumn() + 1);
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //sw
        p.setValues(position.getRow() + 1, position.getColumn() - 1);
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //se
        p.setValues(position.getRow() + 1, position.getColumn());
        if (getBoard().positionExists(p) && canMove(p)){
            matrix[p.getRow()][p.getColumn()] = true;
        }

        //Castling
        if (getMoveCount() == 0 && !chessMatch.getCheck()){
            Position castlingKingSide = new Position(position.getRow(),position.getColumn() + 3);
            if (testRookCastling(castlingKingSide)){
                Position p1 = new Position(position.getRow(),position.getColumn() + 1);
                Position p2 = new Position(position.getRow(),position.getColumn() + 2);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null){
                    matrix[position.getRow()][position.getColumn() + 2] = true;
                }
            }


            Position castlingQueenSide = new Position(position.getRow(),position.getColumn() - 4);
            if (testRookCastling(castlingQueenSide)){
                Position p1 = new Position(position.getRow(),position.getColumn() - 1);
                Position p2 = new Position(position.getRow(),position.getColumn() - 2);
                Position p3 = new Position(position.getRow(),position.getColumn() - 3);

                if (getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null){
                    matrix[position.getRow()][position.getColumn() - 2] = true;
                }
            }
        }
        return matrix;
    }
}
