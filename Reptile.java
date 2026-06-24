public class Reptile extends Animal implements Trackable {
    private boolean isVenomous;
    private double lengthCm;

    public Reptile(String species, String nickname, String island, double weightKg, String healthStatus, 
        boolean isVenomous, double lengthCm) {
        super(species, nickname, island, weightKg, healthStatus);
        this.isVenomous = isVenomous;
        this.lengthCm = lengthCm;
    }

    public boolean isVenomous(){
        return this.isVenomous;
    }

    public double getLengthCm(){
        return this.lengthCm;
    }

    public String getType(){
        return "Reptile";
    }

    public double getDailyFoodCostTTD(){
        return 25.0 + getWeightKg() * 2.0;
    }

    @Override
    public void logSighting(String date, String location) {
        String sighting = date + " at " + location;
        getSightings().add(sighting);
    }

    @Override
    public int getSightingCount() {
        return getSightings().size();
    }

    @Override
    public String getLastSighting() {
        if (getSightings().isEmpty()) {
            return "No sightings recorded";
        }
        return getSightings().get(getSightings().size() - 1);
    }
    
}
