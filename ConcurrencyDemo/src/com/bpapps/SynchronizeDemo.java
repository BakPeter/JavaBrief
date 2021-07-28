package com.bpapps;

import static com.bpapps.ThreadColors.ANSI_RED;

public class SynchronizeDemo {
    public void run() {
        System.out.println(ANSI_RED + "Run SynchronizeDemo started");

        CountDown counter = new CountDown();

        CountDownThread thread1 = new CountDownThread(counter);
        thread1.setName("Thread 1");
        CountDownThread thread2 = new CountDownThread(counter);
        thread2.setName("Thread 2");

        thread1.start();
        thread2.start();

        System.out.println(ANSI_RED + "Run SynchronizeDemo ended");
    }

    class CountDown {
        private int i;

        public void doCountdown() {
            String color;

            switch (Thread.currentThread().getName()) {
                case "Thread 1":
                    color = ThreadColors.ANSI_CYAN;
                    break;
                case "Thread 2":
                    color = ThreadColors.ANSI_PURPLE;
                    break;
                default:
                    color = ThreadColors.ANSI_GREEN;
            }

            synchronized (this) {
                for (i = 10; i > 0; i--) {
                    System.out.println(color + Thread.currentThread().getName() + ": i = " + i);
                }
            }
//            synchronized(this) {
//                for(i=10; i > 0; i--) {
//                    System.out.println(color + Thread.currentThread().getName() + ": i =" + i);
//                }
//            }
        }
    }

    class CountDownThread extends Thread {
        private CountDown counter;

        public CountDownThread(CountDown counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            counter.doCountdown();
        }
    }
}
