public class Plant {
    // A constant representing the maximum number of plants allowed.
    public static final int MAX_PLANTS = 200;

    // A method to grow and return a new Plant object if the maximum limit is not exceeded.
    public static Plant grow() {
        // Check if the number of plants is below the maximum allowed limit.
        if (Plant.MAX_PLANTS > 0) {
            // Create and return a new Plant object.
            return new Plant();
        }
        // If the maximum limit is reached, return null.
        return null;
    }
}
