package nl.hu.bep.aquariumbeheersysteem.model;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

public class Eigenaar implements Principal {
    private String voornaam;
    private String achternaam;
    private String role;
    private static List<Eigenaar> eigenaars = new ArrayList<>();
    private static List<Aquarium> aquariums = new ArrayList<>();

    private static Eigenaar myEigenaar = new Eigenaar();

    public static Eigenaar getMyEigenaar ( ) {
        return myEigenaar;
    }


    public Eigenaar (String vNm, String password) {
        this.voornaam = vNm;
        this.achternaam = password;
        this.role = "user";
        if (!eigenaars.contains(this)) eigenaars.add(this);
    }

    private Eigenaar ( ) {
        aquariums.add(new Aquarium("fars", 20, 20, 20, "gewoon", "vles"));
        aquariums.add(new Aquarium("fa", 2, 2, 2, "gewo", "vl"));
        aquariums.add(new Aquarium("abeer", 30, 30, 30, "gewoon", "vles"));
        aquariums.add(new Aquarium("sedra", 40, 40, 40, "gewoon", "vles"));
    }

    public static String validateLogin (String voornaam, String password) {
        Eigenaar found = getUserByName(voornaam);
        if (found!= null) return password.equals(found.achternaam) ? found.getRole() :null;
        return null;
    }

    public void setAchternaam (String achternaam) {
        this.achternaam = achternaam;
    }

    public List<Aquarium> getAquariums ( ) {
        return aquariums;
    }

    public boolean addAquarium (Aquarium newAquarium) {
        if (getAquariumByName(newAquarium.getNaam()) != null) {
            return false;
        } else {
            return aquariums.add(newAquarium);
        }
    }

    public Aquarium getAquariumByName (String name) {
        for (Aquarium aquarium : aquariums) {
            if (aquarium.getNaam().equals(name)) {
                return aquarium;
            }
        }

        return null;
    }


    public void setVoornaam (String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam ( ) {
        return achternaam;
    }

    public String getVoornaam ( ) {
        return voornaam;
    }

    public static Aquarium creatAquaium (String nm, double le, double br, double hog, String bod, String wat) {
        if (aquariums.stream().noneMatch(e -> e.getNaam().equals(nm))) {
            aquariums.add(new Aquarium(nm, le, br, hog, bod, wat));
            return new Aquarium(nm, le, br, hog, bod, wat);
        }
        return null;
    }

//    public static Eigenaar creatEigenaar (String nm , String pwd){
//        if(eigenaars.stream().noneMatch(e->e.getName().equals(nm))){
//            eigenaars.add(new Eigenaar(nm, pwd));
//            return new Eigenaar(nm,pwd);}
//        return null;
//    }

    public static List<Aquarium> getAquarium ( ) {
        return aquariums;
    }

    public static Aquarium getAquarium (String naam) {
        return aquariums.stream().filter(e -> e.getNaam().equals(naam)).findFirst().orElse(null);
    }

    public static boolean removeAquarium (String name) {
        for (Aquarium a : aquariums) {
            if (a.getNaam().equals(name)) {
                if (name != null) return aquariums.remove(aquariums.indexOf(Eigenaar.getAquarium(name))) != null;
            }
        }

        return false;
    }
    public static Eigenaar getEigenaar (String naam) {
        return eigenaars.stream().filter(e -> e.getName().equals(naam)).findFirst().orElse(null);
    }

    public static boolean removeEigenaar (String name) {
        for (Eigenaar a : eigenaars) {
            if (a.getName().equals(name)) {
                if (name != null) return eigenaars.remove(eigenaars.indexOf(Eigenaar.getEigenaar(name))) != null;
            }
        }

        return false;
    }
    public static List<Eigenaar>getEigenaars(){
        return eigenaars;
    }

    public void setAdmin ( ) {
        role = "admin";
    }

    @Override
    public String getName ( ) {
        return voornaam;
    }

    public String getRole ( ) {
        return role;
    }

    public static Eigenaar getUserByName (String name) {
        return eigenaars.stream().filter(e -> e.voornaam.equals(name)).findFirst().orElse(null);
    }

}
