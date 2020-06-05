package nl.hu.bep.aquariumbeheersysteem.model;

import java.util.ArrayList;
import java.util.List;

public class Bewoner {
    private String soortNaam;
    private String kleurNaam;
    private int aantal;
    private boolean groepsDier;

    public static Bewoner newBewoner = new Bewoner();
    public static Bewoner getNewBewoner(){return newBewoner;}

    public Bewoner(){}
    public Bewoner (String soort, String kleur, int aantal){
        this.soortNaam = soort;
        this.kleurNaam = kleur;
        this.aantal = aantal;
        this.groepsDier = false;

    }

    public void setSoortNaam (String soortNaam) { this.soortNaam = soortNaam; }

    public void setKleurNaam (String kleurNaam) { this.kleurNaam = kleurNaam; }

    public void setAantal (int aantal) { this.aantal = aantal; }

    public void setGroepsDier (boolean groepsDier) { this.groepsDier = groepsDier; }

    public boolean isGroepsDier ( ) { return groepsDier; }

    public String getSoortNaam ( ) { return soortNaam; }

    public String getKleurNaam ( ) { return kleurNaam; }

    public int getAantal ( ) { return aantal; }
}
