package methodologies;

public class SelectionSort <T extends Comparable<T>> implements  Methodology {
    private T[] array;
    private int step = 0;
    private int index = 0;
    private boolean invertOrder;

    public SelectionSort(T[] array) {
        this.array = array;
        this.invertOrder = false;
    }

    public SelectionSort(T[] array, boolean invertOrder) {
        this.array = array;
        this.invertOrder = invertOrder;
    }

    @Override
    public void handle() {
        int n = array.length;

        int minIndex = index;

        for (int j = index + 1; j < n; j++) {
            boolean validation = !invertOrder ?
                    array[j].compareTo(array[minIndex]) > 0 :
                    array[minIndex].compareTo(array[j]) > 0;
            if (validation) {
                minIndex = j;
            }
        }

        T temp = array[minIndex];
        array[minIndex] = array[index];
        array[index] = temp;


        increaseStep();
        index++;
    }

    @Override
    public T[] getArray() {
        return array;
    }

    @Override
    public int getIndex() {
        return index;
    }

    @Override
    public void increaseStep() {
        this.step++;
    }

    @Override
    public int getStep() {
        return step;
    }

    public boolean isOrganized() {
        for (int i = 0; i < array.length - 1; i++) {
            T firstElement = array[i];
            T secondElement = array[i + 1];

            boolean validation = invertOrder ?
                    firstElement.compareTo(secondElement) > 0 :
                    secondElement.compareTo(firstElement) > 0;

            if (validation) return false;
        }

        return true;
    }
}
