import Interfaces.Interface;
import Interfaces.TerminalInterface;
import methodologies.Methodology;

public class ArrayOrganizer {
    public Interface interfaceD;
    private int delay;
    public Methodology methodology;

    public ArrayOrganizer(Methodology methodology, int delay, Interface interfaceD) {
        this.delay = delay;
        this.methodology = methodology;
        this.interfaceD = interfaceD;
    }

    public void sort() throws InterruptedException {
        while (!methodology.isOrganized()) {
            methodology.handle();
            Thread.sleep(delay);
            interfaceD.showStep(methodology.getArray(), methodology.getStep());
        }
    }
}
