// На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга.
public class chessQueen {
    public static void printBoard(int [][] matrix) {
        
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == -1){
                    System.out.printf(" Ф ");
                }else {
                    System.out.printf(" . ");
                } 
            }
            System.out.println();
        }  
    }
    public static void setQueen(int i, int j, int [][] matrix) {
        for (int x = 0; x < 8; x ++) {
            ++ matrix[x][j];
            ++ matrix[i][x];
            int foo;
            foo = j - i + x;
            if (foo >=  0 && foo < 8){
                ++ matrix[x][foo];   
            }
            foo = j + i - x;
            if (foo >=  0 && foo < 8){
                ++ matrix[x][foo];
            }
        }
        matrix[i][j] = -1;     
    }

    public static void resetQueen(int i, int j, int [][] matrix) {
        for (int x = 0; x < 8; x ++) {
            -- matrix[x][j];
            -- matrix[i][x];
            int foo;
            foo = j - i + x;
            if (foo >=  0 && foo < 8){
                -- matrix[x][foo];   
            }
            foo = j + i - x;
            if (foo >=  0 && foo < 8){
                -- matrix[x][foo];
            }
        }
        matrix[i][j] = 0;     
    }
    public static boolean tryQueen(int i, int [][] matrix) {
        boolean result = false;
        for (int j = 0; j < 8; j ++) {
            if (matrix[i][j] == 0){
                setQueen(i, j, matrix);
                if (i == 7){
                    result = true;
                }else {
                    if (!(result = tryQueen(i+1, matrix))){
                        resetQueen(i,j, matrix);
                    }
                }
            }
            if (result){
                break;
            }
        }
        return result;
        
    }
   
    public static void main(String [] args) {
        int [][] chessBoard = new int[8][8];
        tryQueen(0, chessBoard);
        printBoard(chessBoard);
    }
}
