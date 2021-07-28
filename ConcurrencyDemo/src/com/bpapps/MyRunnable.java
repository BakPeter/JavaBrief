package com.bpapps;

import static com.bpapps.ThreadColors.ANSI_CYAN;

public class MyRunnable implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ANSI_CYAN + "MyRunnable " + Thread.currentThread().getName() + " " + i);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(ANSI_CYAN + "MyRunnable Interrupted and stopped");
                return;//end thread
            }
        }
    }
}
