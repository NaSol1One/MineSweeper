import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MineState {
    static String noMine = "O";
    static String Mine = "X";
}
public class MineSweeper {

    public static int ScanNum() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static int ScanBoardSize() {
        final int MinBoardSize = 5 ;
        final int MaxBoardSize = 15 ;
        int size = ReceiveBoardSize(MinBoardSize,MaxBoardSize);

        while (size < MinBoardSize || size > MaxBoardSize) {
            System.out.println("크기 입력 오류");
            size = ReceiveBoardSize(MinBoardSize,MaxBoardSize);
        }

        return size;
    }

    public static int ReceiveBoardSize(int MinBoardSize, int MaxBoardSize) {
        System.out.printf("게임 보드의 크기 입력 ( %d ~ %d ) : ",MinBoardSize,MaxBoardSize);

        return ScanNum();
    }

    public static int ReceiveMineNum() {
        System.out.print("지뢰 개수 입력 : ");

        return ScanNum();
    }

    public static int ScanMineNum(int size) {
        int mine_num = ReceiveMineNum();
        final int MinMineNum = size * size / 10 ;
        final int MaxMineNum = size * size * 2 / 10 ;

        while (mine_num < MinMineNum || mine_num > MaxMineNum) {
            System.out.println("옳지 않은 개수");
            mine_num = ReceiveMineNum();
        }
        return mine_num;
    }

    public static String[][] MakeBoard(int size, int mine_num) {
        String[][] gameBoard = new String[size][size];
        for (String[] strings : gameBoard) Arrays.fill(strings, MineState.noMine);

        return CountMine(RandomMinePlanting(gameBoard,mine_num), size);
    }

    public static String[][] RandomMinePlanting(String[][] arr, int mine_num) {
        Random random = new Random();
        for (int i = 0; i < mine_num; i++) {
            int x = random.nextInt(0, arr.length);
            int y = random.nextInt(0, arr.length);
            arr[x][y] = MineState.Mine;
        }
        return arr;
    }

    public static void PrintBoard(String[][] gameBoard) {
        for (String[] strings : gameBoard) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }

    public static String[][] CountMine(String[][] gameBoard, int size) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                if (!gameBoard[i][j].equals("X")) CountMineOnBlank(gameBoard, size, i, j);
            }
        }
        return gameBoard;
    }

    public static void CountMineOnBlank(String[][] arr, int size, int x, int y) {
        final int[] xCoordinateOfSurroundingBlocks = {-1, -1, -1, 0, 0, 1, 1, 1};
        final int[] yCoordinateOfSurroundingBlocks = {-1, 0, 1, -1, 1, -1, 0, 1};
        int cnt = 0;

        for (int k = 0; k < xCoordinateOfSurroundingBlocks.length; k++) {
            int next_x = x + xCoordinateOfSurroundingBlocks[k];
            int next_y = y + yCoordinateOfSurroundingBlocks[k];

            if (CheckInRange(arr,size,next_x,next_y)) cnt += 1;
        }
        if(cnt!=0) arr[x][y] = Integer.toString(cnt);
    }

    public static boolean CheckInRange(String[][] arr ,int size, int next_x, int next_y){
        boolean CheckMine = false;
        boolean IsInRange = (0 <= next_x) && (next_x < size) && (0 <= next_y) && (next_y < size);
        if (IsInRange) {CheckMine = arr[next_x][next_y].equals(MineState.Mine);}
        return CheckMine;
    }


    public static void main(String[] args) {

        int size = ScanBoardSize();
        int mine_num = ScanMineNum(size);
        String[][] arr = MakeBoard(size, mine_num);
        PrintBoard(arr);

    }
}
