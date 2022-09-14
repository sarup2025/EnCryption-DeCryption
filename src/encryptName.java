import java.util.Scanner;

public class encryptName {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your first name: ");
        String text = in.nextLine();
        System.out.print("Enter last two digit of your roll no: ");
        int r = in.nextInt();
        in.close();
        int key;
        if (r % 26 == 0) {
            key = 14;
        } else {
            key = r % 26;
        }

        System.out.println("Name You have entered : " + text);
        System.out.println("Key based on Your Roll.No : " + key);
        System.out.println("Encrypted Text : " + encrypt(text, key));

    }

    public static StringBuffer encrypt(String text, int key) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < text.length(); i++) {
            if (Character.isUpperCase(text.charAt(i))) {
                char ch = (char) (((int) text.charAt(i) + key - 65) % 26 + 65);
                result.append(ch);
            } else {
                char ch = (char) (((int) text.charAt(i) + key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}