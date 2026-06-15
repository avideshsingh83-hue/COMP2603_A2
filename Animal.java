import java.util.ArrayList;

/**
 * Abstract base class for all animals in the conservation system.
 */
public abstract class Animal {
    private static int nextId = 1;

    private int animalId;
    private String species;
    private String nickname;
    private String island;
    private double weightKg;
    private String healthStatus;

    // TODO M4: Declare private ArrayList<String> sightings field

    /**
     * Constructor: assigns auto-incremented ID, validates all parameters.
     * Species, nickname, island must not be null or empty.
     * weightKg must be > 0.
     * healthStatus must be "Healthy", "Injured", or "Critical".
     * TODO M4: Initialize sightings list
     */
    public Animal(String species, String nickname, String island, double weightKg, String healthStatus) {
        if(species == null){
            throw new IllegalArgumentException("Species cannot be null");
        }
        if(nickname == null){
            throw new IllegalArgumentException("Nickname cannot be null");
        }
        if(island == null){
            throw new IllegalArgumentException("Island cannot be null");
        }
        if(weightKg <= 0){
            throw new IllegalArgumentException("Weight must be greater than 0");
        }
        if(!healthStatus.equals("Healthy") && !healthStatus.equals("Injured") && !healthStatus.equals("Critical")){
            throw new IllegalArgumentException("Health status must be 'Healthy', 'Injured', or 'Critical'");
        }
        animalId = nextId;
        nextId = nextId + 1;
        // TODO M4: Initialize sightings ArrayList
    }

    public int getAnimalId() {
        return this.animalId;
    }

    public String getSpecies() {
        return this.species;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getIsland() {
        return this.island;
    }

    public double getWeightKg() {
        return this.weightKg;
    }

    public String getHealthStatus() {
        return this.healthStatus;
    }

    // TODO M2: Write setIsland(String island) method

    // TODO M4: Write getSightings() getter that returns the ArrayList<String>

    public void updateHealth(String newStatus) {
        if(newStatus.equals("Healthy") || newStatus.equals("Injured") || newStatus.equals("Critical")){
            this.healthStatus = newStatus;
        }
    }

    /**
     * Returns the animal type: "Bird", "Reptile", or "Marine".
     * TODO M2: Declare as abstract
     */
    public abstract String getType();

    /**
     * Returns the daily food cost in TTD. Varies by subclass.
     * TODO M2: Declare as abstract
     */
    public abstract double getDailyFoodCostTTD();

    @Override
    public String toString() {
        return String.format("#%03d %s '%s' (%s) [%s] %.2f kg - %s", animalId, species, nickname, island, getType(), weightKg, healthStatus);
    }

    /**
     * Two animals are equal if they have the same animalId.
     *
     * TODO M5: Implement equals
     */
    @Override
    public boolean equals(Object obj) {
        // TODO M5: Implement equality by animalId
        return false;
    }

    /**
     * TODO M5: Implement hashCode based on animalId
     */
    @Override
    public int hashCode() {
        // TODO M5: Return hash based on animalId
        return 0;
    }
}
