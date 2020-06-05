package nl.hu.bep.aquariumbeheersysteem.model;

import java.util.ArrayList;
import java.util.List;

public class ToeBehoren {
    protected String model;
    protected int serienummer;
    private List<ToeBehoren> toeBehorens = new ArrayList<>();

    public ToeBehoren(String model , int serienummer){
        this.model = model;
        this.serienummer = serienummer;

    }
    public void voegToebehoren(ToeBehoren s){
        toeBehorens.add(s);
    }
    public void setModel (String model) { this.model = model; }

    public void setSerienummer (int serienummer) { this.serienummer = serienummer; }

    public int getSerienummer ( ) { return serienummer; }

    public String getModel ( ) { return model; }
}
