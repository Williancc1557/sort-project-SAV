package methodologies;


public class BobbleSort <T extends Comparable<T>> implements Methodology {
    private T[] array;
    private int step = 0;
    private int index = 0;
    private boolean invertOrder;

    public BobbleSort(T[] array, boolean invertOrder) {
        this.array = array;
        this.invertOrder = invertOrder;
    }

    @Override
    public void handle() {
        if (index + 1 == array.length)  this.index = 0;

        T firstElement = array[index];
        T secondElement = array[index + 1];

        boolean validation = !invertOrder ?
                firstElement.compareTo(secondElement) > 0 :
                secondElement.compareTo(firstElement) > 0;

        if (validation) {
            array[index] = secondElement;
            array[index + 1] = firstElement;
        }

        increaseStep();
        index++;
    }

    @Override
    public T[] getArray() {
        return array;
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

            boolean validation = !invertOrder ?
                    firstElement.compareTo(secondElement) > 0 :
                    secondElement.compareTo(firstElement) > 0;

            if (validation) return false;
        }

        return true;
    }
}
