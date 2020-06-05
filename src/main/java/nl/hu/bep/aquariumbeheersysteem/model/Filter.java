package nl.hu.bep.aquariumbeheersysteem.model;



public class Filter extends ToeBehoren {
    private boolean isExtem;
    private double aantalLiter;
    public Filter (String model, int serienummer , double aantalLiter) {
        super(model, serienummer);

        this.aantalLiter = aantalLiter;
        this.isExtem = false;

    }

    public void setExtem (boolean extem) { isExtem = extem; }

    public boolean isExtem ( ) { return isExtem; }

    public void setAantalLiter (double aantalLiter) { this.aantalLiter = aantalLiter; }

    public double getAantalLiter ( ) { return aantalLiter; }
}
