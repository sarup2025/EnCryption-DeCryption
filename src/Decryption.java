import java.util.Scanner;
public class Decryption {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter Your Encrypted name: ");
        String ctext = in.next();
//        System.out.print("Enter last two digits of Your roll no: ");
//        int r = in.nextInt();
//        int key = 0;
        int key;
        for (key = 0; key <= 26; key++) {
            key = key % 26;
        }
        System.out.println("Encrypted name You have entered : " + ctext);
        System.out.println("Key based on the digits of Your Roll.No : " + key);
        System.out.println("Decrypted name : " + decrypt(ctext, 26 - key));
    }
    public static StringBuffer decrypt(String ctext, int key) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < ctext.length(); i++) {
            if (Character.isUpperCase(ctext.charAt(i))) {
                char ch = (char) (((int) ctext.charAt(i) + key - 65) % 26 + 65);
                result.append(ch);
            }
            else
            {
                char ch = (char)(((int)ctext.charAt(i) + key - 97) % 26 + 97);
                result.append(ch);
            }
        }
        return result;
    }
}
