import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;


public class test {

    public static int ScanNum() {
        Scanner scan = new Scanner(System.in);
        return scan.nextInt();
    }

    public static int ScanBoardSize() {
        System.out.print("게임 보드의 크기 입력 (5~15) : ");
        int size;
        size = ScanNum();

        while (size < 5 || size > 15) {
            System.out.println("크기 입력 오류");
            System.out.print("게임 보드의 크기 입력 (5~15) : ");
            size = ScanNum();
        }

        return size;
    }

    public static int ScanMineNum(int size) {
        System.out.print("지뢰 개수 입력 : ");
        int mine_num = ScanNum();

        while (mine_num < size * size / 10 || mine_num > size * size * 2 / 10) {
            System.out.println("옳지 않은 개수");
            System.out.print("지뢰 개수 입력 : ");
            mine_num = ScanNum();
        }
        return mine_num;
    }

    public static String[][] MakeBoard(int size, int mine_num) {
        String[][] arr = new String[size][size];
        for (String[] strings : arr) Arrays.fill(strings, "O");

        return CountMine(RandomMinePlanting(arr,mine_num), size);
    }

    public static String[][] RandomMinePlanting(String[][] arr, int mine_num) {
        Random random = new Random();
        for (int i = 0; i < mine_num; i++) {
            int x = random.nextInt(0, arr.length);
            int y = random.nextInt(0, arr.length);
            arr[x][y] = "X";
        }
        return arr;
    }

    public static void PrintBoard(String[][] arr) {
        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }

    }

    public static String[][] CountMine(String[][] arr, int size) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                CountMineOnBlank(arr, size, i, j);
            }
        }
        return arr;
    }

    public static void CountMineOnBlank(String[][] arr, int size, int x, int y) {
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        int cnt = 0;

        for (int k = 0; k < 8; k++) {
            int next_x = x + dx[k];
            int next_y = y + dy[k];

            if (0 <= next_x && next_x < size && 0 <= next_y && next_y < size) {
                if (arr[next_x][next_y].equals("X")) {
                    cnt += 1;
                }
            }
        }
        arr[x][y] = Integer.toString(cnt);
    }

    public static void main(String[] args) {

        int size = ScanBoardSize();
        int mine_num = ScanMineNum(size);
        String[][] arr = MakeBoard(size, mine_num);
        PrintBoard(arr);

    }
}
