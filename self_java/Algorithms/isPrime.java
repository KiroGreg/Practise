import java.util.Scanner;

public class isPrime {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Print starting and finish values: ");
        int counter = 0;
        int start = sc.nextInt();
        int finish = sc.nextInt();
        sc.close();
        for (int i = start; i <= finish; i++) {
            System.out.println(i + " is" + (isPrime(i) ? " " : " NOT ") + "a prime digit");
            counter += isPrime(i) ? 1 : 0;
        }
        System.out.println("A number of prime digits between " + start + " and " + finish + " is " + counter);

    }

    public static boolean isPrime(int digit) {
        if (digit <= 2) {
            return (digit == 2);
        }
        for (int i = 2; i <= digit / 2; i++) {
            if (digit % i == 0) {
                return false;
            }
        }
        return true;
//        int counter = 0;
//        for (int i = 2; i < digit; i++) {
//            counter+= digit%i==0?1:0;
//            if(counter==2){
//                break;
//            }
//        }
//        return (counter==2);
    }
}

