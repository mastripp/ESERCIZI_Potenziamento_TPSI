package MagazzinoConsumatore;

import java.util.Random;

class Corriere extends Thread {
    private Magazzino magazzino;
    private Random rand = new Random();

    public Corriere(Magazzino m) {
        super("Corriere");
        this.magazzino = m;
    }

    public void run() {
        int tentativiFalliti = 0;

        try {
            while (true) {
                Integer pacco = magazzino.preleva();

                if (pacco == null) {
                    tentativiFalliti++;
                    System.out.println("Magazzino vuoto (tentativo " + tentativiFalliti + ")");

                    if (tentativiFalliti >= 3) {
                        System.out.println("Corriere termina: nessun pacco in arrivo");
                        break;
                    }

                    continue;
                }

                tentativiFalliti = 0;
                
                int tempo = 2000 + rand.nextInt(2000);
                Thread.sleep(tempo);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}