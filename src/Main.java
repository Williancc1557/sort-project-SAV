import methodologies.BobbleSort;
import methodologies.Methodology;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        Integer[] array1 = randomIntList();

        Character[] array2 = randomCharList();

        Methodology methodology = selectMethodology(args, array1);

        ArrayOrganizer organizer = new ArrayOrganizer(methodology, 1000);
        organizer.sort();
    }

    public static Integer[] randomIntList() {
        Integer[] randomIntList = new Integer[7];

        Random random = new Random();
        for (int i = 0; i < randomIntList.length; i++) {
            int MAX = 40;
            int MIN = 1;
            randomIntList[i] = random.nextInt(MAX - MIN) + MIN;
        }

        return randomIntList;
    }

    public static Character[] randomCharList() {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        Character[] randomList = new Character[7];
        for (int i = 0; i < randomList.length; i++) {
            int indiceAleatorio = random.nextInt(allowedCharacters.length());
            randomList[i] = allowedCharacters.charAt(indiceAleatorio);
        }

        return randomList;
    }


    public static Methodology selectMethodology(String[] args, Integer[] array) {
        String type = getParamValue(args, "o").toLowerCase();

        switch (type) {
            case "b":
                return new BobbleSort<>(array, isBiggerToSmaller(args));
        }

        return new BobbleSort<>(array, isBiggerToSmaller(args));
    }

    public static Methodology selectMethodology(String[] args, Character[] array) {
        String type = getParamValue(args, "o").toLowerCase();

        switch (type) {
            case "b":
                BobbleSort bobbleSort = new BobbleSort<>(array, isBiggerToSmaller(args));
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