package SportelloBancario;

class Sportello {
    private int cassieriLiberi = 2;

    public synchronized boolean accedi() throws InterruptedException {
        long timeout = 5000;
        long start = System.currentTimeMillis();

        while (cassieriLiberi == 0) {
            long elapsed = System.currentTimeMillis() - start;
            long restante = timeout - elapsed;

            if (restante <= 0) {
                return false;
            }

            wait(restante);
        }

        cassieriLiberi--;
        return true;
    }

    public synchronized void lascia() {
        cassieriLiberi++;
        notifyAll();
    }
}