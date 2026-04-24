package MagazzinoConsumatore;

import java.util.LinkedList;
import java.util.Queue;

class Magazzino {
    private final int CAPACITA = 4;
    private Queue<Integer> coda = new LinkedList<>();

    public synchronized void deposita(int pacco) throws InterruptedException {
        while (coda.size() == CAPACITA) {
            wait();
        }

        coda.add(pacco);
        System.out.println(Thread.currentThread().getName() + " deposita pacco " + pacco);

        notifyAll();
    }

    public synchronized Integer preleva() throws InterruptedException {
        if (coda.isEmpty()) {
            wait(4000);

            if (coda.isEmpty()) {
                return null;
            }
        }

        int pacco = coda.poll();
        System.out.println(Thread.currentThread().getName() + " preleva pacco " + pacco);

        notifyAll();
        return pacco;
    }
}
