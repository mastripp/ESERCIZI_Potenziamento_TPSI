package Nexus;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Aeroporto {

    private int gateNazionaliTotali;
    private int gateIntenazionaliTotali;


    private final ReentrantLock lock;
    private final Condition attendiNazionali;

    private int gateNazionaliLiberi;

    public Aeroporto(int gateIntenazionaliTotali, int gateNazionaliTotali) {
        this.gateIntenazionaliTotali = gateIntenazionaliTotali;

        this.gateNazionaliTotali = gateNazionaliTotali;
        this.lock = new ReentrantLock();
        this.attendiNazionali = lock.newCondition();
    }


    public void acquisisciGateNazionle(Volo v) throws InterruptedException {
        lock.lock();


        try {
            while (gateNazionaliLiberi == 0) attendiNazionali.await();
            gateNazionaliLiberi--;
            System.out.println("VRROM VROoom");
        } finally {
            lock.unlock();
        }

    }

    public void rilasciaGateNazionle(Volo v) throws InterruptedException{
        lock.lock();

        try {
            gateNazionaliLiberi++;
            
            attendiNazionali.signal();
        } finally {
            lock.unlock();
        }
    }


}