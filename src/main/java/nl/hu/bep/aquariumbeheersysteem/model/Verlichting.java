package nl.hu.bep.aquariumbeheersysteem.model;

import java.sql.Time;

public class Verlichting extends ToeBehoren {
    private boolean isLed;
    private Time tijdOn;
    private Time tijdOff;

    public Verlichting (String model, int serienummer ) {
        super(model, serienummer);
    }
}
