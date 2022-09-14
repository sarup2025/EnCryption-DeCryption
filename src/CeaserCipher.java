import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.*;
class basic1 {
    String allChar="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    int indexOfChar(char c)
    {
        for(int i=0;i< allChar.length();i++)
        {
            if(allChar.charAt(i)==c)
                return i;
        }
        return -1;
    }
    char charAtIndex(int pos)
    {
        return allChar.charAt(pos);
    }
}
class Ceaser1
{
    basic1 b=new basic1();
    String Encrypt(String plainText,int key)
    {
        plainText=plainText.toUpperCase();
        String cipherText="";

        for(int i=0;i< plainText.length();i++){
            int index=b.indexOfChar(plainText.charAt(i));
            if(index==-1)
            {
                cipherText+=plainText.charAt(i);
                continue;
            }
            if((index+key)%26==0) {
                cipherText+=b.charAtIndex(index+key);
            }
            else {
                cipherText+=b.charAtIndex((index+key)%26);
            }
        }
        return cipherText;
    }
    String Decrypt(String cipherText,int key) {cipherText=cipherText.toUpperCase();
        String decryptedText="";
        for(int i=0;i< cipherText.length();i++) {
            int index=b.indexOfChar(cipherText.charAt(i));
            if(index==-1) {
                decryptedText+=cipherText.charAt(i);
                continue;
            }
            if((index-key)>=0) {
                decryptedText+=b.charAtIndex(index-key);
            }
            else {
                decryptedText+=b.charAtIndex((index-key)+26);
            }
        }
        return decryptedText;
    }
    void bruteForce(String cipherText) throws FileNotFoundException {
        cipherText = cipherText.toUpperCase();
        int key = 0;
        String decryptedText = null;
        try {
            PrintStream ps = new PrintStream(new File("Output.text"));
            System.setOut(ps);
            for (int k = 0; k < 26; k++) {
                decryptedText = "";
                key = k;
                for (int i = 0; i < cipherText.length(); i++) {
                    int index = b.indexOfChar(cipherText.charAt(i));
                    if (index == -1) {
                        decryptedText += cipherText.charAt(i);
                        continue;
                    }
                    if ((index - key) >= 0) {
                        decryptedText += b.charAtIndex(index - key);
                    } else {
                        decryptedText += b.charAtIndex((index - key) + 26);
                    }
                }
            System.out.println("Decrypted Text Using key " + key + ":" + decryptedText);
                ps.println();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
class CeaserCipher{
    public static void main(String args[])throws Exception {
        Scanner scn=new Scanner(System.in);
        String plainText,cipherText;
        int key;
        System.out.println("Enter Encrypted Text:");
        plainText=scn.nextLine();
        System.out.println("Enter key for Decryption:");
        key=scn.nextInt();
        Ceaser1 cipher=new Ceaser1();
        cipherText=cipher.Encrypt(plainText,key);
        System.out.println("Decrypted Text is:"+cipherText);
        String decryptedText=cipher.Decrypt(cipherText,key);
        System.out.println("Encrypted Ciphertext is:"+decryptedText);
        System.out.println("Do you want to apply brute force on Ciphertext? press 1 to continue otherwise press anykey");
        int choice=scn.nextInt();
        if(choice==1)
            cipher.bruteForce(cipherText);
    }
}  
