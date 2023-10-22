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

        System.out.print("지뢰 개수 입력 : ");
        int x_num = scan.nextInt();

        while (x_num<size*size/10 || x_num>size*size*2/10){
            System.out.println("옳지 않은 개수");
            System.out.print("지뢰 개수 입력 : ");
            x_num = scan.nextInt();
        }

        for (String[] strings : arr) Arrays.fill(strings, "O");

        Random random = new Random();
        for(int i = 0; i < x_num; i++){
            int x = random.nextInt(0,arr.length);
            int y = random.nextInt(0,arr.length);
            arr[x][y] = "X";
        }

        int [] dx = {-1,-1,-1,0,0,1,1,1};
        int [] dy = {-1,0,1,-1,1,-1,0,1};
        int cnt =0;

        for(int i = 0 ; i < arr.length ; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j].equals("O")) {
                    for (int k = 0; k < 8; k++) {
                        int next_x = i + dx[k];
                        int next_y = j + dy[k];

                        if (0 <= next_x && next_x < size && 0 <= next_y && next_y < size) {
                            if(arr[next_x][next_y].equals("X")){cnt+=1;}
                        }
                    }
                    if (cnt != 0 ){
                    arr[i][j] = Integer.toString(cnt);
                    cnt =0;}
                }
            }
        }

        for (String[] strings : arr) {
            for (String string : strings) {
                System.out.print(string);
            }
            System.out.println();
        }
    }
}