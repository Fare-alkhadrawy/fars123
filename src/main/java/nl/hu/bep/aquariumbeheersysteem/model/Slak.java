package nl.hu.bep.aquariumbeheersysteem.model;

public class Slak extends Bewoner {

    private boolean slakEtend;

    public Slak (String soort, String kleur, int aantal) {
        super(soort, kleur, aantal);
        slakEtend = false;
    }

    public void setSlakEtend (boolean slakEtend) { this.slakEtend = slakEtend; }


    public boolean isSlakEtend ( ) { return slakEtend; }
}
