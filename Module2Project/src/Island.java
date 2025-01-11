public class Island {
    private final Location[][] grid;
    private final int rows;
    private final int column;

    // Constructor
    public Island(int rows, int column) {
        this.rows = rows;
        this.column = column;
        this.grid = new Location[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                this.grid[i][j] = new Location();
            }
        }
    }
    public Location getLocation(int row, int col) {
        if (row >= 0 && row < rows && col >= 0 && col < column) {
            return grid[row][col];
        }
        return null; // Out-of-bounds
    }
    public Location getNeighbor(Location location, int direction) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == location) {
                    switch (direction) {
                        case 0: // North
                            return getLocation(i - 1, j);
                        case 1: // East
                            return getLocation(i, j + 1);
                        case 2: // South
                            return getLocation(i + 1, j);
                        case 3: // West
                            return getLocation(i, j - 1);
                        default:
                            return null;
                    }
                }
            }
        }
        return null; // Location not found
    }
    // Getters
    public int getRows() {
        return rows;
    }
    public int getColumn() {
        return column;
    }
}
