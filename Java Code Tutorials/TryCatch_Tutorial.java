import java.util.InputMismatchException;
import java.util.Scanner;

public class TryCatch_Tutorial {
    public static void main(String[] args)  {

            int a=10;
            int b=0;

            try {
                System.out.println(a/b);
            } catch ( ArithmeticException e ) {
                System.err.println("error occued");
                System.out.println(e.getMessage());
            }finally {
                System.out.println("a by 2 is : " + a/2);
            }


    }
}
