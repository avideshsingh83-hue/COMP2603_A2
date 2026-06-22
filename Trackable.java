public interface Trackable {
    public void logSighting(String date, String location);

    public int getSightingCount();

    public String getLastSighting();
}
