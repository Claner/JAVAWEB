package Test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Clanner on 2016/12/9.
 */
public class Demo {
    public static void main(String[] args) {
        final Timer timer = new Timer();
        final long delay = 1;
        timer.schedule(new TimerTask() {
            int i = 1;
            @Override
            public void run() {
                if (i == 100) timer.cancel();
                System.out.println(i++);
            }
        },new Date(),delay);
    }
}
