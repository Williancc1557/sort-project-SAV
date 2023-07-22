import methodologies.BobbleSort;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Integer[] array1 = {3, 2, 5, 4, 1};

        BobbleSort bobbleSort = new BobbleSort<>(array1);


        Character[] array2 = {'a', 'c', 'b', 'd', 'e'};

        BobbleSort bobbleSortChar = new BobbleSort<>(array2);


        ArrayOrganizer organizer = new ArrayOrganizer(bobbleSort, 1000);
        organizer.sort();
    }
}