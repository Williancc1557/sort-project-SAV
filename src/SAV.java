import Interfaces.Interface;
import Interfaces.SwingInterface.SwingInterface;
import methodologies.BobbleSort;
import methodologies.InsertionSort;
import methodologies.Methodology;
import methodologies.SelectionSort;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SAV {
    public static void main(String[] args) throws InterruptedException {
        try {
            String listType = getParamValue(args, "t").toLowerCase();
            listTypeSwitch(listType, args);
        } catch (NumberFormatException err) {
            System.out.println("Valores inválidos");
        } catch (RuntimeException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void listTypeSwitch(String listType, String[] args) throws InterruptedException {
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
                throw new RuntimeException("Invalid param 't'");
        }
    }

    public static void handleMethodology(Methodology methodology, String args[]) throws InterruptedException {
        Interface interfaceD = new SwingInterface();
        ArrayOrganizer organizer = new ArrayOrganizer(methodology, getDelay(args), interfaceD);
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
                throw new RuntimeException("Invalid param 'in'");
        }
    }

    public static Integer[] convertInputToIntList(String[] args) {
        String[] inputType = getParamValue(args, "v").split(",");

        Integer[] list = new Integer[inputType.length];
        for (int i = 0; i < list.length; i++) {
            int value = Integer.parseInt(inputType[i]);
            if (!(value > -1000 && value < 1000)) throw new RuntimeException("Invalid value " + value);
            list[i] = value;
        }

        return list;
    }

    public static Character[] getCharList(String[] args) {
        String inputType = getParamValue(args, "in").toLowerCase();

        switch (inputType) {
            case "r":
                return randomCharList(args);
            case "m":
                return convertInputToCharList(args);
            default:
                throw new RuntimeException("Invalid param 'in'");
        }
    }

    public static Character[] convertInputToCharList(String[] args) {
        char[] charArray = getParamValue(args, "v").replaceAll(",", "").toCharArray();

        validateCharList(charArray);

        Character[] characterArray = new Character[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            characterArray[i] = charArray[i];
        }

        return characterArray;

    }
    
    public static void validateCharList(char[] list) throws RuntimeException {
        String regex = "[a-zA-Z]";
        for (char c : list) {
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(Character.toString(c));

            if (!matcher.matches()) {
                throw new RuntimeException("Valores inválidos");
            }
        }
    }

    public static int getDelay(String[] args) {
        int delay = Integer.parseInt(getParamValue(args, "s"));

        if (!(delay >= 100 && delay <= 1000)) throw new RuntimeException("Invalid delay provided [100, 1000]");

        return delay;
    }

    public static int getArrayLenght(String[] args) {
        int LENGTH = Integer.parseInt(getParamValue(args, "r"));

        if (!(LENGTH > 0 && LENGTH <=40)) throw new RuntimeException("Invalid param 'r'");

        return LENGTH;
    }

    public static Integer[] randomIntList(String[] args) {
        Integer[] randomIntList = new Integer[getArrayLenght(args)];
        Random random = new Random();

        for (int i = 0; i < randomIntList.length; i++) {
            int MAX = 1000;
            int MIN = -1000;
            randomIntList[i] = random.nextInt(MAX - MIN) + MIN;
        }

        return randomIntList;
    }

    public static Character[] randomCharList(String[] args) {
        String allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random random = new Random();

        Character[] randomList = new Character[getArrayLenght(args)];
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
                System.out.println("Running with BobbleSort");
                return new BobbleSort<>(array, isBiggerToSmaller(args));
            case "i":
                System.out.println("Running with InsertionSort");
                return new InsertionSort<>(array, isBiggerToSmaller(args));
            case "s":
                System.out.println("Running with SelectionSort");
                return new SelectionSort<>(array, isBiggerToSmaller(args));
            default:
                throw new RuntimeException("Invalid param 'a'");
        }
    }

    public static Methodology selectMethodology(String[] args, Character[] array) {
        String type = getParamValue(args, "a").toLowerCase();

        switch (type) {
            case "b":
                System.out.println("Running with BobbleSort");
                return new BobbleSort<>(array, isBiggerToSmaller(args));
            case "i":
                System.out.println("Running with InsertionSort");
                return new InsertionSort<>(array, isBiggerToSmaller(args));
            case "s":
                System.out.println("Running with SelectionSort");
                return new SelectionSort<>(array, isBiggerToSmaller(args));
            default:
                throw new RuntimeException("Invalid param 'a'");
        }
    }

    public static boolean isBiggerToSmaller(String[] args) {
        String biggerToSmallerOrSmallerToBigger = getParamValue(args, "o").toLowerCase();

        return biggerToSmallerOrSmallerToBigger.equals("az");
    }

    public static String getParamValue(String[] args, String field) {
        for (String param : args) {
            String[] keyAndValue = param.split("=");
            if (keyAndValue[0].equals(field)) {
                return keyAndValue[1];
            }
        }

        switch (field) {
            case "in" -> {
                return "m";
            }
            case "a" -> {
                return "b";
            }
            case "o" -> {
                return "az";
            }
            case "s" -> {
                return "800";
            }
        }

        throw new RuntimeException("Invalid param provided");
    }
}