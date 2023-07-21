package Stewart.mycompany;

import java.util.Random;

public class NumberGenerator {
    
    //setting the max number generated number to 24 and no number below 1
    private static final int MIN = 1;
    private static final int MAX = 24;

    //making the random number generator
    private final Random random = new Random();

    //generating the number
    public int generateRandomNumber() {
        return random.nextInt(MAX - MIN + 1) + MIN;
    }
}


