package boardgame;

public class Board {
    private int rows;
    private int colums;
    private Piece[][] pieces;

    public Board(int rows, int colums) {
        if (rows < 1 || colums < 1) {
            throw new RuntimeException("Error creating board, there must be at least 1 row and 1 column");
        }

        this.rows = rows;
        this.colums = colums;

        pieces = new Piece[rows][colums];
    }

    public int getRows() {
        return rows;
    }
    public int getColums() {
        return colums;
    }

    public Piece piece(int rows,int colums){
        return pieces[rows][colums];
    }

    public Piece piece(Position position){
        return pieces(position.getRow(),position.getColumn());
    }

    private Piece pieces(int row, int column) {
        return null;//TODO
    }

    public void placePiece(Piece piece, Position position){
        pieces[position.getRow()][position.getColumn()] = piece;

        piece.position = position;
    }
}
