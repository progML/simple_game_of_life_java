import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Grid grid = new Grid();
        boolean[][] map = grid.initGrid();
        System.out.println("Введите N: ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        input.close();
        while (n > 0) {
            boolean[][] temp = map;
            map = grid.updateGrid(temp);
            n--;
        }
    }

}
