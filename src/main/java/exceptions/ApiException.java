package exceptions;

import java.util.Scanner;

public class ApiException extends RuntimeException{
    private final int statusCode;

    public ApiException(int statusCode, String msg){
        super(msg);
        this.statusCode = statusCode;
    }

    public int getStatusCode() {
        return statusCode;
    }
        public static void main(String[] args) {
            Scanner kb = new Scanner(System.in);
            System.out.println("Enter a number");
            try {
                long nb1 = kb.nextLong();
                if(nb1<1000000000)
                    throw new ArithmeticException();
                else System.out.println( "result : " + Math.sqrt(nb1) );
            } catch (ArithmeticException e) {
                System.out.println("This is an arithmetic exception!!");
            }
        }

}
