import Interfaces.Interface;
import Interfaces.SwingInterface.SwingInterface;
import Interfaces.TerminalInterface;
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
            String listType = ConvertValues.getParamValue(args, "t").toLowerCase();
            listTypeSwitch(listType, args);
        } catch (NumberFormatException err) {
            System.out.println("Valores inválidos");
        } catch (RuntimeException err) {
            System.out.println(err.getMessage());
        }
    }

    public static void listTypeSwitch(String listType, String[] args) throws InterruptedException {
        switch (listType) {
            case "n" -> {
                Integer[] arrayInt = ConvertValues.getIntList(args);
                Methodology methodologyInt = ConvertValues.selectMethodology(args, arrayInt);
                ConvertValues.handleMethodology(methodologyInt, args);
            }
            case "c" -> {
                Character[] arrayChar = ConvertValues.getCharList(args);
                Methodology methodologyChar = ConvertValues.selectMethodology(args, arrayChar);
                ConvertValues.handleMethodology(methodologyChar, args);
            }
            default -> throw new RuntimeException("Invalid param 't'");
        }
    }
}