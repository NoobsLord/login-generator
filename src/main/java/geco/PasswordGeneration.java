package geco;

import java.util.Random;

public class PasswordGeneration {
    String[] alphabet = {"a","b","c","d","e","f","g",
            "h","i","j","k","l","m","n","o","p","q",
            "r","s","t","u","v","w","x","y","z",
            "1","2","3","4","5","6","7","8","9","0",
            "-","_","=","+","/","#",".",",",";",":",
            "&","{","}","(",")","[","]","@","?","!","§","%"};

    int rnd;

    public String getRandomPassword(){
        String str = "";
            for (int i = 0; i < 8; i++){
                rnd = new Random().nextInt(alphabet.length);
                str+=alphabet[rnd];
            }
            System.out.println(str);
        return str;
    }
}
