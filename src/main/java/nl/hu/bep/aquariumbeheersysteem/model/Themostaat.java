package nl.hu.bep.aquariumbeheersysteem.model;

public class Themostaat extends ToeBehoren {
    private double minTemp;
    private double maxTemp;
    private double huidigTemp;
    public Themostaat (String model, int serienummer, double min, double max, double huidigTemp) {
        super(model, serienummer);
        this.minTemp = min;
        this.maxTemp = max;
        this.huidigTemp = huidigTemp;

    }

    public double getHuidigTemp ( ) { return huidigTemp; }

    public double getMaxTemp ( ) { return maxTemp; }

    public double getMinTemp ( ) { return minTemp; }

    public void setMaxTemp (double maxTemp) { this.maxTemp = maxTemp; }

    public void setMinTemp (double minTemp) { this.minTemp = minTemp; }

    public void setHuidigTemp (double huidigTemp) { this.huidigTemp = huidigTemp; }
}
