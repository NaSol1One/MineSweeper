import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String[][] arr = new String[5][5];

        for(int i = 0; i < arr.length; i++)
            Arrays.fill(arr[i], "O");

        for(int i = 0 ; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j]);
            }
            System.out.println();
        }
    }
}