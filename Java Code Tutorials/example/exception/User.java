package example.exception;

import java.util.Scanner;

public class User {

    public static void main(String[] args) {
        User user = new User();
        Scanner sc = new Scanner(System.in);
        String userName=sc.next();
        try {
            user.validateUser( userName);
        } catch ( InvalidUserDetailsException e ) {
            System.err.println(e.getMessage());
        }

    }

    private void validateUser(String userName) throws InvalidUserDetailsException {
        if (userName.length()>3){
            throw new InvalidUserDetailsException("Please enter valid user details");
        }
    }
}
