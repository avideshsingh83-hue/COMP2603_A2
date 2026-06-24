public class Marine extends Animal implements Trackable, Relocatable {
    private double maxDepthM;
    private int tankSizeLitres;

    public Marine(String species, String nickname, String island, double weightKg, String healthStatus,
                  double maxDepthM, int tankSizeLitres) {
        super(species, nickname, island, weightKg, healthStatus);
        this.maxDepthM = maxDepthM;
        this.tankSizeLitres = tankSizeLitres;
    }

    public double getMaxDepthM(){
        return this.maxDepthM;
    }

    public int getTankSizeLitres(){
        return this.tankSizeLitres;
    }

    public String getType(){
        return "Marine";
    }

    public double getDailyFoodCostTTD(){
        return 50.0 + getWeightKg() * 3.0;
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
   
    @Override
    public boolean canRelocateTo(String targetIsland) {
        if(targetIsland.equals(getIsland())){
            return false;
        }
        return true;
    }

    @Override
    public double getRelocationCost() {
        return 2000.0 + tankSizeLitres * 5.0;
    }

    @Override
    public void relocateTo(String island) {
        setIsland(island);
    }
    
}
