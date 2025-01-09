import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class SimulationController {
    private final Island island;
    private final ScheduledExecutorService scheduler;

    public SimulationController(Island island, ScheduledExecutorService scheduler) {
        this.island = island;
        this.scheduler = Executors.newScheduledThreadPool(3);
    }
    public void startSimulation() {
        scheduler.scheduleAtFixedRate(()-> island.simulateCycle(), 0, 1, TimeUnit.SECONDS);
    }
    public void stopSimulation() {
        scheduler.shutdown();
    }
}
