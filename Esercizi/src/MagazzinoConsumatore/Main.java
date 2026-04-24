package MagazzinoConsumatore;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Magazzino magazzino = new Magazzino();

        List<Operaio> operai = new ArrayList<>();

        for (int i = 0; i < 3; i++) {
            Operaio op = new Operaio(magazzino, "Operaio-" + i);
            operai.add(op);
            op.start();
        }

        Corriere corriere = new Corriere(magazzino);
        corriere.start();

        for (Operaio op : operai) {
            op.join();
        }
        
        corriere.join();

        System.out.println("\n--- FINE SIMULAZIONE ---");
    }
}
