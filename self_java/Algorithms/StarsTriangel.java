import java.util.Scanner;


public class StarsTriangel {
    public static void main(String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            int width = scan.nextInt();
            scan.close();
            if (width <= 0) {
                throw new NegativeOr0Input("ERROR");
            } else {
                for (int row = 0; row < width; row++) {
                    for (int col = 0; col < width - row; col++) {
                        if (col > row - 1) {
                            System.out.print("*");
                        } else {
                            System.out.print(" ");
                        }
                    }
                    System.out.println();
                }
            }
        } catch (NegativeOr0Input e){
            System.out.println("ERROR");
        }
    }

    public static class NegativeOr0Input extends Exception{
        public NegativeOr0Input(String messege){
            super(messege);
        }
    }
}