import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.print("게임 보드의 크기 입력 (5~15) : ");
        int size;
        size = scan.nextInt();

        while (size<5 || size>15){
            System.out.println("크기 입력 오류");
            System.out.print("게임 보드의 크기 입력 (5~15) : ");
            size = scan.nextInt();
        }

        String[][] arr = new String[size][size];
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