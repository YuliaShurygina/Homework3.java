//Шахматную доску размером NxN обойти конём так, чтобы фигура в каждой клетке была строго один раз.
//Пример для доски 5х5 решение может выглядеть так.
//25 14 3 8 19 4 9 18 13 2 15 24 1 20 7 10
//5 22 17 12 23 16 11 6 21
class chessHorse {
    public static void printBoard(int [][] matrix) {
        
        System.out.println();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf(" %2d ", matrix[i][j]);
            }
            System.out.println();
        }  
    }
    public static boolean setHorse(int x, int y, int[][] matrix, int[][] steps, int n) {
        // проверка параметров
        if ((x < 0) || (x >= matrix.length) || (y < 0) || (y >= matrix.length)){
            return false;
        }
        if (matrix[x][y] != 0){
            return false;
        }
        //следующий ход
        n++;
        matrix[x][y] = n;
        // стоп
        if (n == matrix.length*matrix.length){
            return true; 
        }
        
        for (int i = 0; i < steps.length; i++){
            if (setHorse(x + steps[i][0], y + steps[i][1], matrix, steps, n)){
                return true;
            }
        }
        n--;
        matrix[x][y] = 0;
        return false;           
    }
    public static void main(String [] args) {
        long time = System.currentTimeMillis();
        int number = 5;// размер доски
        int n = 0;
        int [][] chessBoard = new int[number][number];
        int [][] moves = {{1, -2}, {2, -1}, {2, 1}, {1, 2}, {-1, 2}, {-2, 1}, {-2, -1}, {-1, -2}};
        setHorse(1, 1, chessBoard, moves, n);
        printBoard(chessBoard);
        System.out.println();
        System.out.printf("Время выполнения программы в мс: %2d", System.currentTimeMillis() - time);
    }
}