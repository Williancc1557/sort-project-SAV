import methodologies.BobbleSort;
import methodologies.InsertionSort;
import methodologies.Methodology;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String listType = getParamValue(args, "t").toLowerCase();

        switch (listType) {
            case "n":
                Integer[] arrayInt = getIntList(args);
                Methodology methodologyInt = selectMethodology(args, arrayInt);
                handleMethodology(methodologyInt, args);
                break;
            case "c":
                Character[] arrayChar = getCharList(args);
                Methodology methodologyChar = selectMethodology(args, arrayChar);
                handleMethodology(methodologyChar, args);
                break;
            default:
                throw new RuntimeException("Invalid parameter 't'");
        }

    }

    public static void handleMethodology(Methodology methodology, String args[]) throws InterruptedException {
        ArrayOrganizer organizer = new ArrayOrganizer(methodology, getDelay(args));
        organizer.sort();
    }

    public static Integer[] getIntList(String[] args) {
        String inputType = getParamValue(args, "in").toLowerCase();

        switch (inputType) {
            case "r":
                return randomIntList(args);
            case "m":
                return convertInputToIntList(args);
            default:
                throw new RuntimeException("Invalid param '1'");
        }
    }

    public static Integer[] convertInputToIntList(String[] args) {
        String[] inputType = getParamValue(args, "v").split(",");

        Integer[] list = new Integer[inputType.length];
        for (int i = 0; i < list.length; i++) {
            list[i] = Integer.parseInt(inputType[i]);
        }

        return list;
    }


    public static Character[] getCharList(String[] args) {
        String inputType = getParamValue(args, "in").toLowerCase();

        switch (inputType) {
            case "r":
                return randomCharList(args);
            case "m":
                //
            default:
                throw new RuntimeException("Invalid param 'i'");
        }
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