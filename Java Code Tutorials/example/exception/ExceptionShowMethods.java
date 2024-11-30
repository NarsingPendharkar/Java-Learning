package example.exception;

public class ExceptionShowMethods {

    public static void main(String[] args) {
        try {
            int one=3;
            int two=0;

            System.out.println(one/two);
        }
        catch ( ArithmeticException e ){
           // e.printStackTrace();
            //System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }

}
