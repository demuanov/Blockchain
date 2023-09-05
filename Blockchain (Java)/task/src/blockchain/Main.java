package blockchain;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {


            try {
                // Parses the date
                String result = String.valueOf(LocalDate.parse("2018-01-12"));
               Block kek = new Block();

                System.out.println("Some output: " + kek);

                // Prints the date with year
                System.out.println("The date with month is: " + result);
            }
            catch (Exception e) {
                System.out.println(e);
            }

    }
}
