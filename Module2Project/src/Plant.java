public class Plant {
    public static final int MAX_PLANTS = 200;

    public static Plant grow() {
        if (Plant.MAX_PLANTS > 0) {
            return new Plant();
        }
        return null;
    }
}
