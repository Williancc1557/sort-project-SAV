import methodologies.BobbleSort;
import methodologies.InsertionSort;
import methodologies.Methodology;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer[] array1 = randomIntList(args);

        Character[] array2 = randomCharList(args);

        Methodology methodology = selectMethodology(args, array2);

        ArrayOrganizer organizer = new ArrayOrganizer(methodology, getDelay(args));
        organizer.sort();
    }

    public static Integer[] getInList(String[] args) {
        String delay = getParamValue(args, "s");

        return new Integer[]{1};
    }

    public static int getDelay(String[] args) {
        String delay = getParamValue(args, "s");

        return Integer.parseInt(delay);
    }

    public static Integer[] randomIntList(String[] args) {
        int LENGTH =  Integer.parseInt(getParamValue(args, "r"));
        Integer[] randomIntList = new Integer[LENGTH];

        Random random = new Random();
        for (int i = 0; i < randomIntList.length; i++) {
            int MAX = 40;
            int MIN = 1;
            randomIntList[i] = random.nextInt(MAX - MIN) + MIN;
        }

        return randomIntList;
    }

    public static Character[] randomCharList(String[] args) {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        int LENGTH =  Integer.parseInt(getParamValue(args, "r"));
        Character[] randomList = new Character[LENGTH];
        for (int i = 0; i < randomList.length; i++) {
            int indiceAleatorio = random.nextInt(allowedCharacters.length());
            randomList[i] = allowedCharacters.charAt(indiceAleatorio);
        }

        return randomList;
    }

    public static Methodology selectMethodology(String[] args, Integer[] array) {
        String type = getParamValue(args, "a").toLowerCase();

        switch (type) {
            case "b":
                return new BobbleSort<>(array, isBiggerToSmaller(args));
            case "i":
                return new InsertionSort<>(array, isBiggerToSmaller(args));
        }

        return new BobbleSort<>(array, isBiggerToSmaller(args));
    }

    public static Methodology selectMethodology(String[] args, Character[] array) {
        String type = getParamValue(args, "a").toLowerCase();

        switch (type) {
            case "b":
                return new BobbleSort<>(array, isBiggerToSmaller(args));
            case "i":
                return new InsertionSort<>(array, isBiggerToSmaller(args));
        }

        return new BobbleSort<>(array, isBiggerToSmaller(args));
    }

    public static boolean isBiggerToSmaller(String[] args) {
        String biggerToSmallerOrSmallerToBigger = getParamValue(args, "o").toLowerCase();

        boolean invertOrder = false;

        switch (biggerToSmallerOrSmallerToBigger) {
            case "az":
                invertOrder = true;
                break;
        }

        return invertOrder;
    }

    public static String getParamValue(String[] args, String field) {
        for (String param : args) {
            String[] keyAndValue = param.split("=");
            if (keyAndValue[0].equals(field)) {
                return keyAndValue[1];
            }
        }

        throw new RuntimeException("Invalid param provided");
    }
}