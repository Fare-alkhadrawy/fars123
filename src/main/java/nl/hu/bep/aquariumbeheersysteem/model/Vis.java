package nl.hu.bep.aquariumbeheersysteem.model;

public class Vis extends Bewoner {
    private boolean algEatend;
    private boolean vreistSpeciaalVisVoer;
    public Vis (String soort, String kleur, int aantal) {
        super(soort, kleur, aantal);
        algEatend = false;
        vreistSpeciaalVisVoer = false;
    }

    public void setAlgEatend (boolean algEatend) { this.algEatend = algEatend; }

    public void setVreistSpeciaalVisVoer (boolean vreistSpeciaalVisVoer) { this.vreistSpeciaalVisVoer = vreistSpeciaalVisVoer; }

    public boolean isAlgEatend ( ) { return algEatend; }

    public boolean isVreistSpeciaalVisVoer ( ) { return vreistSpeciaalVisVoer; }
}
