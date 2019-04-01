package Humans;

import java.util.Random;
import java.lang.String;

public class Programmer extends Human {

    private static final int RAND_SIZE = 150;

    private static final int MIN_RAND = 50;

    private final String alphabet = ("QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm1234567890(){}[]<>=!,");

    public Programmer (String name) {
        super(name);
    }

    public String coding(){
        Random rand = new Random();
        int size = rand.nextInt(RAND_SIZE) + MIN_RAND;
        String code = "";
        for (int i=0; i<size; i++)
        {
            char a = alphabet.charAt(rand.nextInt(alphabet.length()));
            code+=a;
        }
        return code;
    }
}
