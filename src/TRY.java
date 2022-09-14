import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

class basic{
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
class Ceaser{
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
        cipherText=cipherText.toUpperCase();
        for(int k=0;k< 26;k++) {
            String decryptedText="";
            int key=k;
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

            String s = "Decrypted Text Using key" + key + ":" + decryptedText;
            System.out.println(s);
            try{
                PrintStream ps = new PrintStream(new File("Ps.text"));
                System.setOut(ps);
                for (int i = 0; i < 26 ; i++) {
                    ps.println(s);


                }

            }
            catch (FileNotFoundException ft){
                System.out.println(ft);
            }

        }
    }
}public class TRY {
}
