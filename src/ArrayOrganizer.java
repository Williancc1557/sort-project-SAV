import methodologies.Methodology;

import java.util.Arrays;

public class ArrayOrganizer extends Interface {
    private int delay;
    public Methodology methodology;

    public ArrayOrganizer(Methodology methodology, int delay) {
        this.delay = delay;
        this.methodology = methodology;
    }

    public void sort() throws InterruptedException {
        while (true) {
            methodology.handle();
            Thread.sleep(delay);
            showStep(methodology.getArray(), methodology.getStep());
        }
    }
}
