import methodologies.Methodology;

public class ArrayOrganizer extends Interface {
    private int delay;
    public Methodology methodology;

    public ArrayOrganizer(Methodology methodology, int delay) {
        this.delay = delay;
        this.methodology = methodology;
    }

    public void sort() throws InterruptedException {
        while (!methodology.isOrganized()) {
            methodology.handle();
            Thread.sleep(delay);
            showStep(methodology.getArray(), methodology.getStep());
        }
    }
}
