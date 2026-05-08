package Nexus;

import java.security.PublicKey;

public class Volo extends Thread {

    private static final int MAX_ITERATION = 2;
    private Aeroporto aeroporto;
    private TipoVolo type;

    public Volo(String name, Aeroporto aeroporto, TipoVolo type) {
        this.aeroporto = aeroporto;
        this.type = type;
        setName(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < MAX_ITERATION; i++) {
            try {

                sleep(2000);

                if (type == TipoVolo.NAZIONALE) {
                    aeroporto.acquisisciGateNazionle(this);
                }

                sleep(4500);

                if (type == TipoVolo.NAZIONALE) {
                    aeroporto.rilasciaGateNazionle(this);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}