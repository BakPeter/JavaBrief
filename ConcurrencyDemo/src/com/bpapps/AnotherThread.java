package com.bpapps;

import static com.bpapps.ThreadColors.ANSI_PURPLE;

public class AnotherThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(ANSI_PURPLE + currentThread().getName() + " " + i);
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println(ANSI_PURPLE + currentThread().getName() + " interrupted");
            }
        }
    }
}
