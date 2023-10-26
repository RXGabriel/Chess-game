package boardgame;

public abstract class Piece {
    protected Position position;
    private final Board board;

    public Piece(Board board) {
        this.board = board;
        position = null;
        //
    }
    protected Board getBoard() {
        return board;
    }
    public abstract boolean[][] possibleMoves();
    public boolean possibleMove(Position position){
        return possibleMoves()[position.getRow()][position.getColumn()];
    }
    public boolean isThereAnyPossibleMove(){
        boolean[][] matrix = possibleMoves();

        //TODO
        for (boolean[] booleans : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                if (booleans[j]) {
                    return true;
                }
            }
        }
        return false;
    }

}
