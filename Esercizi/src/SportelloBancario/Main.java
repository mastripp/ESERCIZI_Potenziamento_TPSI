package SportelloBancario;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Sportello sportello = new Sportello();

        List<Cliente> clienti = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            Cliente c = new Cliente(sportello, "Cliente-" + i);
            clienti.add(c);
            c.start();
        }

        for (Cliente c : clienti) {
            c.join();
        }

        System.out.println();
        System.out.println("--- RISULTATI ---");
        System.out.println("Serviti: " + Cliente.getServiti());
        System.out.println("Rinunciati: " + Cliente.getRinunciati());
    }
}