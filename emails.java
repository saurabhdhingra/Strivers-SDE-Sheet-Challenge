import java.util.*;

public class emails {
    public static void main(String[] argv) {
        Scanner scan = new Scanner(System.in);
        String first, last, company;
        while (scan.nextLine() != "e") {
            first = scan.nextLine();
            last = scan.nextLine();
            company  ="paypal";
            // company = scan.nextLine();


            first = first.toLowerCase().trim();
            last = last.toLowerCase().trim();
            company = company.toLowerCase().trim();

            // Email format 1 : sdhingra@company.com
            StringBuilder email1 = new StringBuilder();
            email1.append(first.charAt(0) + last + "@" + company + ".com ");

            // Email format 2 : saurabh.dhingra@company.com
            StringBuilder email2 = new StringBuilder();
            email1.append(first + "." + last + "@" + company + ".com ");

            // Email format 3 : saurabh.dhingra@company.com
            StringBuilder email3 = new StringBuilder();
            email1.append(first + "@" + company + ".com");

            System.out.println(email1.toString() + "\n" + email2.toString() + "\n" + email3.toString());
        }
        
        scan.close();
    }
}