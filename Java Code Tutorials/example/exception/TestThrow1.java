package example.exception;

public class TestThrow1 {


    int num=8;

    public static void main(String[] args) {
        TestThrow1 ts=new TestThrow1();
        try {
            ts.validateAge(ts.num);
        } catch ( AgeIsNotSufficentException e ) {
            System.out.println(e.getStackTrace().toString());
        }
    }

   public void validateAge(int age) throws AgeIsNotSufficentException {
       if(age<18 ){
         throw  new AgeIsNotSufficentException("You are a child now, can't vote!")   ;
       }
       else{
           System.out.println("you are eligible for voting");
       }
   }
}
