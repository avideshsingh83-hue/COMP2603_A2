public class Bird extends Animal implements Trackable, Relocatable {
    private double wingspanCm;
    private boolean canFly;

    public Bird(String species, String nickname, String island, double weightKg, String healthStatus, 
        double wingspanCm, boolean canFly) {
        super(species, nickname, island, weightKg, healthStatus);
        this.wingspanCm = wingspanCm;
        this.canFly = canFly;
    }

    public double getWingspanCm() {
        return this.wingspanCm;
    }

    public boolean canFly() {
        return this.canFly;
    }

    public String getType(){
        return "Bird";
    }

    public double getDailyFoodCostTTD(){
        return 15.0 + getWeightKg() * 50.0;
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

    // --- Relocatable methods ---
    // TODO M6: Implement canRelocateTo(String targetIsland)
    //          Birds can always be relocated; return true

    // TODO M6: Implement getRelocationCost()
    //          Returns 500.0 + weightKg * 100.0

    // TODO M6: Implement relocateTo(String island)
    //          Updates the island using setIsland()
}
