package utils;  // 🔥 Se till att du har rätt package

import java.util.Random;

public class IDGenerator {
    private static final Random random = new Random();

    public static String generateShortId() {
        int id = random.nextInt(10000);
        return String.format("%04d", id);
    }
}