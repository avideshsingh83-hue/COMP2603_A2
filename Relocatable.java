public interface Relocatable {
    public boolean canRelocateTo(String targetIsland);

    public double getRelocationCost();

    public void relocateTo(String island);
}
