package nl.hu.bep.aquariumbeheersysteem.model;

public class Ornament {
    private String naam;
    private String kleur;
    private String omschrijving;
    private boolean kanOpLuchtPompen;

    public Ornament(String nm , String kl, String om){
        this.naam = nm;
        this.kleur = kl;
        this.omschrijving = om;
        kanOpLuchtPompen = false;

    }

    public void setNaam (String naam) { this.naam = naam; }

    public void setOmschrijving (String omschrijving) { this.omschrijving = omschrijving; }

    public void setKleur (String kleur) { this.kleur = kleur; }

    public void setKanOpLuchtPompen (boolean kanOpLuchtPompen) { this.kanOpLuchtPompen = kanOpLuchtPompen; }

    public String getNaam ( ) { return naam; }

    public String getOmschrijving ( ) { return omschrijving; }

    public String getKleur ( ) { return kleur; }

    public boolean isKanOpLuchtPompen ( ) { return kanOpLuchtPompen; }
}
