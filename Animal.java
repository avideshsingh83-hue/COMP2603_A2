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

    private ArrayList<String> sightings;

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
        
        sightings = new ArrayList<>();
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

    public void setIsland(String island){
        this.island = island;
    }

    protected ArrayList<String> getSightings() {
        return this.sightings;
    }

    public void updateHealth(String newStatus) {
        if(newStatus.equals("Healthy") || newStatus.equals("Injured") || newStatus.equals("Critical")){
            this.healthStatus = newStatus;
        }
    }

    public abstract String getType();

    public abstract double getDailyFoodCostTTD();

    @Override
    public String toString() {
        return String.format("#%03d %s '%s' (%s) [%s] %.2f kg - %s", animalId, species, nickname, island, getType(), weightKg, healthStatus);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        if(!(obj instanceof Animal)){
            return false;
        }
        Animal other = (Animal) obj;
        return this.animalId == other.animalId;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(animalId);
    }
}
