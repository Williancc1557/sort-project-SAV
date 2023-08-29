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
    }

    public void sort() throws InterruptedException {
        while (!methodology.isOrganized()) {
            interfaceD.showStep(methodology.getArray(), methodology.getStep(), milisecondTimeOfExecution);

            long initialTime = System.nanoTime();

            methodology.handle();

            Thread.sleep(delay);
            long endTime = System.nanoTime();
            getMilisecondTimeOfExecution(initialTime, endTime);
        }
    }

    public void getMilisecondTimeOfExecution(long initialTime, long endTime)  {
        milisecondTimeOfExecution += (double) (endTime - initialTime) / 1_000_000_000.0;
    }
}
