import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Manages a collection of animals at a single location.
 */
public class Sanctuary {
    private String name;
    private String island;
    private int capacity;
    private ArrayList<Animal> animals;

    public Sanctuary(String name, String island, int capacity) {
       this.name = name;
       this.island = island;
       this.capacity = capacity;
       animals = new ArrayList<Animal>();
    }

    public String getName() {
        return this.name;
    }

    public String getIsland() {
        return this.island;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public ArrayList<Animal> getAnimals() {
        return this.animals;
    }

    public boolean addAnimal(Animal a) {
        if((a == null) || (animals.size() >= capacity) || (!this.island.equals(a.getIsland()))){
            return false;
        }
        animals.add(a);
        return true;
    }

    public Animal removeAnimal(int animalId) {
        for(int i = 0; i < animals.size(); i++){
            if(animals.get(i).getAnimalId() == animalId){
                return animals.remove(i);
            }
        }
        return null;
    }

    public int getAnimalCount() {
        return animals.size();
    }

    public ArrayList<Animal> getAnimalsOfType(String type) {
        ArrayList<Animal> filteredAnimals = new ArrayList<Animal>();
        for (Animal a : animals) {
            if (a.getType().equals(type)) {
                filteredAnimals.add(a);
            }
        }
        return filteredAnimals;
    }

    public double getDailyFoodBudget() {
        double total = 0.0;
        for (Animal a : animals) {
            total = total + a.getDailyFoodCostTTD();
        }
        return Math.round(total * 100.0) / 100.0;
    }

    public ArrayList<Animal> getRelocatableAnimals() {
        ArrayList<Animal> relocatableAnimals = new ArrayList<Animal>();
        for (Animal a : animals) {
            if (a instanceof Relocatable) {
                relocatableAnimals.add(a);
            }
        }
        return relocatableAnimals;
    }

    public Animal getMostExpensiveAnimal() {
        Animal mostExpensive = null;
        double highestCost = 0.0;
        for(Animal a: animals){
            if(a.getDailyFoodCostTTD() > highestCost){
                highestCost = a.getDailyFoodCostTTD();
                mostExpensive = a;
            }
        }
        return mostExpensive;
    }

    public boolean transferAnimal(int animalId, Sanctuary target) {
        Animal animalToTransfer = removeAnimal(animalId);
        if(animalToTransfer == null){
            return false;
        }
        if(!(animalToTransfer instanceof Relocatable)){
            addAnimal(animalToTransfer);
            return false;
        }
        ((Relocatable) animalToTransfer).relocateTo(target.getIsland());
        target.addAnimal(animalToTransfer);
        return true;
    }

    public void printRoster() {
        for(Animal a : animals){
            System.out.println("  " + a.toString());
        }
    }

    @Override
    public String toString() {
        return "" + name + " (" + island + ") [" + getAnimalCount() + "/" + capacity + " animals]";
    }

    public void getSortedRoster(){
        Collections.sort(animals);
    }
}
