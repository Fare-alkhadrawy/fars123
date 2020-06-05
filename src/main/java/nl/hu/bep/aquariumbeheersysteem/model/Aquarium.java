package nl.hu.bep.aquariumbeheersysteem.model;

import java.util.ArrayList;
import java.util.List;

public class Aquarium {
    private String naam;
    private double lengte ;
    private double breedte ;
    private double hoogte ;
    private String bodemsoort;
    private String watersoot;
    private static List<Bewoner> bewoners = new ArrayList<>();
    private  List<Ornament> ornaments = new ArrayList<>();
    private List<ToeBehoren> toeBehorens = new ArrayList<>();

    public static Aquarium newAquaium = new Aquarium();
    public static Aquarium getNewAquaium(){return newAquaium;}
    public Aquarium(){}
    public Aquarium(String nm , double le, double br, double hog, String bod, String wat){
        this.naam = nm;
        this.lengte = le;
        this.breedte = br;
        this.hoogte = hog;
        this.bodemsoort = bod;
        this.watersoot = wat;

    }

    public void setNaam (String naam) { this.naam = naam; }

    public void setLengte (double lengte) { this.lengte = lengte; }

    public void setBreedte (double breedte) { this.breedte = breedte; }

    public void setHoogte (double hoogte) { this.hoogte = hoogte; }

    public void setBodemsoort (String bodemsoort) { this.bodemsoort = bodemsoort; }

    public void setWatersoot (String watersoot) { this.watersoot = watersoot; }

    public String getNaam ( ) { return naam; }

    public double getLengte ( ) { return lengte; }

    public double getBreedte ( ) { return breedte; }

    public double getHoogte ( ) { return hoogte; }

    public String getBodemsoort ( ) { return bodemsoort; }

    public String getWatersoot(){ return watersoot ; }

    public static Bewoner creatBewoner (String nm, String kl, int aan) {
        if(bewoners.stream().noneMatch(e->e.getSoortNaam().equals(nm))){
            bewoners.add(new Bewoner(nm, kl, aan));
            return new Bewoner(nm, kl, aan);
        }
        return null;
    }

    public static List<Bewoner> getBewoners ( ) {
        return bewoners;
    }
}
