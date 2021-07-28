package com.bpapps;

import com.bpapps.httprequestdemo.HttpRequestAsyncDemo;
import com.bpapps.httprequestdemoblockingqueue.DataFetcher;
import com.bpapps.httprequestdemoblockingqueue.DataHandler;
import com.bpapps.httprequestdemoblockingqueue.ResponseResult;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import static com.bpapps.ThreadColors.ANSI_BLUE;

public class Main {
    //http request demo blocking queue
    public static void main(String[] args) {
        System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " start");

        BlockingQueue<ResponseResult> bq = new ArrayBlockingQueue<ResponseResult>(1);

        DataFetcher df = new DataFetcher(bq);
        DataHandler dh = new DataHandler(bq);

        new Thread(df).start();
        new Thread(dh).start();

        System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " end");
    }

//    //http request demo
//    public static void main(String[] args) {
//        System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " start");
//
//        HttpRequestAsyncDemo httpHandler = new HttpRequestAsyncDemo(new HttpRequestAsyncDemo.IDataFetchedListener() {
//            @Override
//            public void dataFetched(HttpRequestAsyncDemo.ResponseResult data) {
//                System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " : " + data.toString());
//            }
//        });
//
////        for (int i = 0; i < 10; i++) {
////            try {
////                Thread.sleep(1000);
////                System.out.println(ANSI_RED+Thread.currentThread().getName() + ", " + i);
////            } catch (InterruptedException e) {
////                e.printStackTrace();
////            }
////        }
//
//        httpHandler.get();
//
//        System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " end");
//    }


//    public static void main(String[] args) {
//        // write your code here
//        System.out.println(Thread.currentThread().getName() + " thread started");
//
////        mainRun();
////        new SynchronizeDemo().run();
//
//        System.out.println(ANSI_RESET + Thread.currentThread().getName() + " thread ended");
//    }

//    private static void mainRun() {
    //        Thread anotherThread = new AnotherThread();
//        anotherThread.setName("===Another Thread===");
//        anotherThread.start();
////        try {
////            Thread.sleep(2000);
////        } catch (InterruptedException e) {
////            e.printStackTrace();
////        }
//        Thread runnableThread = new Thread(new MyRunnable());
//        runnableThread.setName("$$ Runnable Thread$$");
//        runnableThread.start();
////        new Thread(() -> {
////            for (int i = 100; i < 110; i++) {
////                System.out.println(ANSI_BLUE + "Anonymous class Thread 2 " + i);
////                try {
////                    Thread.sleep(2000);
////                } catch (InterruptedException e) {
////                    e.printStackTrace();
////                }
////            }
////        }).start();
//
//        new Thread(() -> {
//            for (int i = 0; i < 10; i++) {
//                try {
//                    anotherThread.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println(ANSI_GREEN + "Anonymous class Thread 1 " + i);
//                try {
//                    Thread.sleep(500);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//        ).start();
//
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        runnableThread.interrupt();
//    }
}
