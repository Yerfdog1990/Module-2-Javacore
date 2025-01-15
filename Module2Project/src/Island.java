public class Island {
    // A 2D array representing a grid on the island.
    private final Location[][] grid;
    // The number of rows in the grid.
    private final int rows;
    // The number of columns in the grid.
    private final int column;

    // Constructor: Initializes the island grid and its dimensions.
    public Island(int rows, int column) {
        // Set the number of rows.
        this.rows = rows;
        // Set the number of columns.
        this.column = column;
        // Initialize a 2D array of Locations with given dimensions.
        this.grid = new Location[rows][column];
        // Loop through each row.
        for (int i = 0; i < rows; i++) {
            // Loop through each column in the row.
            for (int j = 0; j < column; j++) {
                // Create a new Location object for each grid cell.
                this.grid[i][j] = new Location();
            }
        }
    }

    // Retrieves a Location object at the specified row and column if within bounds.
    public Location getLocation(int row, int col) {
        // Check if the specified row and column values are within valid range.
        if (row >= 0 && row < rows && col >= 0 && col < column) {
            return grid[row][col]; // Return the Location at the specified position.
        }
        return null; // Return null if the specified position is out of bounds.
    }

    // Finds the neighboring Location of a given Location in a specific direction.
    public Location getNeighbor(Location location, int direction) {
        // Traverse through the grid to locate the given Location.
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == location) { // Check if the current grid cell matches the Location.
                    // Determine the neighbor based on the specified direction.
                    switch (direction) {
                        case 0: // North: Row above the current cell.
                            return getLocation(i - 1, j);
                        case 1: // East: Column to the right of the current cell.
                            return getLocation(i, j + 1);
                        case 2: // South: Row below the current cell.
                            return getLocation(i + 1, j);
                        case 3: // West: Column to the left of the current cell.
                            return getLocation(i, j - 1);
                        default:
                            return null; // Return null if direction is invalid.
                    }
                }
            }
        }
        return null; // Return null if the given Location is not found in the grid.
    }

    // Getter for the number of rows in the grid.
    public int getRows() {
        return rows;
    }

    // Getter for the number of columns in the grid.
    public int getColumn() {
        return column;
    }
}
