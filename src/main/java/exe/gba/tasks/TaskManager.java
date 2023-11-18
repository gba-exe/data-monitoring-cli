package exe.gba.tasks;

import java.util.Objects;
import java.util.Timer;
import java.util.TimerTask;

public class TaskManager {

    private static Timer scheduler = new Timer();

    public static void executeTask(TimerTask task, int delay, int period){

        scheduler.schedule(task, delay, period);
    }

    public static void stopTask(){

        scheduler.cancel();
    }
}
