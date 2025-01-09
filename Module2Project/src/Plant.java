public class Plant {
    private static final int MAX_PLANTS = 200;

    public static Plant grow() {
        if (Plant.MAX_PLANTS > 0) {
            return new Plant();
        }
        return null;
    }
}
