package SportelloBancario;

import java.util.Random;

class Cliente extends Thread {
    private Sportello sportello;
    private static int serviti = 0;
    private static int rinunciati = 0;

    public Cliente(Sportello s, String nome) {
        super(nome);
        this.sportello = s;
    }

    public void run() {
        try {
            boolean ottenuto = sportello.accedi();

            if (!ottenuto) {
                System.out.println(getName() + " rinuncia (troppa attesa)");
                incrementaRinunciati();
                return;
            }

            System.out.println(getName() + " è servito");
            
            int tempo = 2000 + new Random().nextInt(2000);
            Thread.sleep(tempo);

            System.out.println(getName() + " ha finito");
            incrementaServiti();

            sportello.lascia();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static synchronized void incrementaServiti() {
        serviti++;
    }

    private static synchronized void incrementaRinunciati() {
        rinunciati++;
    }

    public static int getServiti() {
        return serviti;
    }

    public static int getRinunciati() {
        return rinunciati;
    }
}