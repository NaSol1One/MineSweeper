import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[5][5];
        int x_num = 2;

        for(int i = 0; i < arr.length; i++)
            Arrays.fill(arr[i], "O");

        Random random = new Random();
        for(int i = 0; i < x_num; i++){
            int x = random.nextInt(0,arr.length);
            int y = random.nextInt(0,arr.length);
            arr[x][y] = "X";
        }

        for(int i = 0 ; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}