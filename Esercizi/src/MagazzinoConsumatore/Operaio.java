package MagazzinoConsumatore;

import java.util.Random;

class Operaio extends Thread {
    private Magazzino magazzino;
    private Random rand = new Random();

    public Operaio(Magazzino m, String nome) {
        super(nome);
        this.magazzino = m;
    }

    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                int tempo = 1000 + rand.nextInt(2000);
                Thread.sleep(tempo);

                magazzino.deposita(i);
            }

            System.out.println(getName() + " ha finito");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}