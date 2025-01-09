public class Island {
    private final int rows;
    private final int columns;
    private final Location[][] locations;

    public Island(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        locations = new Location[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                locations[i][j] = new Location();
            }
        }
    }
    public Location getLocation(int row, int column) {
        if(row >= 0 && row < rows && column >= 0 && column < columns) {
            return locations[row][column];
        }
        return null;
    }
    public synchronized void simulateCycle(){
        // Trigger actions (e.g., movement, feeding, breeding) for animals/plants
    }
}
