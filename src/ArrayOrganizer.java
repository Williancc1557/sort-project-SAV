import Interfaces.Interface;
import methodologies.Methodology;

public class ArrayOrganizer {
    public Interface interfaceD;
    private final int delay;
    public Methodology methodology;
    private double milisecondTimeOfExecution;

    public ArrayOrganizer(Methodology methodology, int delay, Interface interfaceD) {
        this.delay = delay;
        this.methodology = methodology;
        this.interfaceD = interfaceD;
        this.milisecondTimeOfExecution = 0;
    }

    @SuppressWarnings("unchecked")
    public void sort() throws InterruptedException {
        while (!methodology.isOrganized()) {
            interfaceD.showStep(methodology.getArray(), methodology.getStep(), milisecondTimeOfExecution);

            long initialTime = System.nanoTime();

            methodology.handle();

            long endTime = System.nanoTime();
            getMilisecondTimeOfExecution(initialTime, endTime);
            Thread.sleep(delay);
        }
    }

    public void getMilisecondTimeOfExecution(long initialTime, long endTime)  {
        this.milisecondTimeOfExecution += (double) ((endTime - initialTime) / 1_000_000.0);
    }
}
