import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Sanctuary caroni = new Sanctuary("Caroni Bird Sanctuary", "Trinidad", 20);
        Sanctuary blueLagoon = new Sanctuary("Blue Lagoon Marine Park", "Jamaica", 15);

        Bird ruby = new Bird("Scarlet Ibis", "Ruby", "Trinidad", 0.35, "Healthy", 60.0, true);
        Bird blaze = new Bird("Scarlet Ibis", "Blaze", "Trinidad", 0.40, "Healthy", 58.0, true);
        Bird dusty = new Bird("Cocrico", "Dusty", "Trinidad", 0.25, "Injured", 30.0, true);
        Reptile brutus = new Reptile("Spectacled Caiman", "Brutus", "Trinidad", 45.0, "Healthy", false, 180.0);
        Reptile medusa = new Reptile("Green Anaconda", "Medusa", "Trinidad", 30.0, "Critical", false, 350.0);
        Marine atlas = new Marine("Leatherback Turtle", "Atlas", "Trinidad", 500.0, "Healthy", 1200.0, 8000);
        
        caroni.addAnimal(ruby);
        caroni.addAnimal(blaze);
        caroni.addAnimal(dusty);
        caroni.addAnimal(brutus);
        caroni.addAnimal(medusa);
        caroni.addAnimal(atlas);    
        
        Bird doctorBird = new Bird("Doctor Bird", "Flash", "Jamaica", 0.01, "Healthy", 12.0, true);
        Marine hawksbillTurtle = new Marine("Hawksbill Turtle", "Shelly", "Jamaica", 80.0, "Injured", 50.0, 3000);
        Marine nurseShark = new Marine("Nurse Shark", "Gills", "Jamaica", 110.0, "Healthy", 75.0, 5000);
        
        blueLagoon.addAnimal(doctorBird);
        blueLagoon.addAnimal(hawksbillTurtle);
        blueLagoon.addAnimal(nurseShark);

        System.out.println("=== Caroni Bird Sanctuary roster ===");
        caroni.printRoster();
        System.out.println();
        System.out.println("=== Blue Lagoon Marine Park roster ===");
        blueLagoon.printRoster();
        System.out.println();

        System.out.println("=== Daily food budgets ===");
        System.out.println(caroni.getName() + ": $" + caroni.getDailyFoodBudget() + "0 TTD");
        System.out.println(blueLagoon.getName() + ": $" + blueLagoon.getDailyFoodBudget() + "0 TTD\n");

        System.out.println("=== Birds at Caroni ===");
        ArrayList<Animal> caroniBirds = caroni.getAnimalsOfType("Bird");
        for (Animal a : caroniBirds) {
            System.out.println("  " + a.toString());
        }
        System.out.println();

        System.out.println("=== Relocatable animals at Caroni ===");
        ArrayList<Animal> caroniRelocatable = caroni.getRelocatableAnimals();
        for (Animal a : caroniRelocatable) {
            System.out.println("  " + a.toString());
        }
        System.out.println();

        System.out.println("=== Sighting logs ===");
        ruby.logSighting("2026-06-10", "Caroni Swamp");
        ruby.logSighting("2026-06-12", "Nariva Swamp");
        atlas.logSighting("2026-06-11", "Matura Beach");
        System.out.println("Ruby sighting count: " + ruby.getSightingCount());
        System.out.println("Ruby last sighting: " + ruby.getLastSighting());
        System.out.println("Atlas sighting count: " + atlas.getSightingCount());
        System.out.println("Atlas last sighting: " + atlas.getLastSighting());
        System.out.println("Brutus last sighting: " + brutus.getLastSighting());
        System.out.println();

        System.out.println("=== Transfer Atlas to Blue Lagoon ===");
        boolean transferResult = caroni.transferAnimal(atlas.getAnimalId(), blueLagoon);
        if (transferResult) {
            System.out.println("Transfer successful: true");
        } else {
            System.out.println("Transfer successful: false");
        }
        blueLagoon.printRoster();
        System.out.println();

        System.out.println("=== Attempt to transfer Brutus (Reptile) ===");
        if (caroni.transferAnimal(brutus.getAnimalId(), blueLagoon)) {
            System.out.println("Transfer successful: true");
        } else {
            System.out.println("Transfer successful: false");
        }
        System.out.println();

        System.out.println("=== Most expensive animal at each sanctuary ===");
        System.out.println(caroni.getName() + ": " + caroni.getMostExpensiveAnimal() +" ($" + caroni.getMostExpensiveAnimal().getDailyFoodCostTTD() + "0 TTD/day)");
        System.out.println(blueLagoon.getName() + ": " + blueLagoon.getMostExpensiveAnimal() +" ($" + blueLagoon.getMostExpensiveAnimal().getDailyFoodCostTTD() + "0 TTD/day)");
        System.out.println();

        System.out.println("=== Updated food budgets ===");
        System.out.println(caroni.getName() + ": $" + caroni.getDailyFoodBudget() + "0 TTD");
        System.out.println(blueLagoon.getName() + ": $" + blueLagoon.getDailyFoodBudget() + "0 TTD");
    }
}
