import Interfaces.Interface;
import Interfaces.SwingInterface.SwingInterface;
import Interfaces.TerminalInterface;
import methodologies.Methodology;

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
                handleMethodology(methodologyInt, args);
            }
            case "c" -> {
                Character[] arrayChar = ConvertValues.getCharList(args);
                Methodology methodologyChar = ConvertValues.selectMethodology(args, arrayChar);
                handleMethodology(methodologyChar, args);
            }
            default -> throw new RuntimeException("Invalid param 't'");
        }
    }

    public static void handleMethodology(Methodology methodology, String[] args) throws InterruptedException {
        try {
            String listType = ConvertValues.getParamValue(args, "i").toLowerCase();

            Interface interfaceD;

            if (listType.equals("t")) {
                interfaceD = new TerminalInterface();
            } else {
                interfaceD = new SwingInterface();
            }

            ArrayOrganizer organizer = new ArrayOrganizer(methodology, ConvertValues.getDelay(args), interfaceD);
            organizer.sort();
        } catch (RuntimeException err) {
            Interface interfaceD = new SwingInterface();
            ArrayOrganizer organizer = new ArrayOrganizer(methodology, ConvertValues.getDelay(args), interfaceD);
            organizer.sort();
        }
    }
}