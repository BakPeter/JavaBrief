package com.bpapps.jsouptest;

import java.util.concurrent.BlockingQueue;

public class DataHandler implements Runnable {
    private BlockingQueue<ResponseResult> bq;
    private ResponseResult rr;

    private boolean mContinueWork = true;
    private String mTreadOutputColor;
    private String mThreadName;
    private int mNumberOfLoops;


//    public DataHandler(BlockingQueue<ResponseResult> bq, String threadName, String treadOutputColor) {
//        this.bq = bq;
//        this.mThreadName= threadName;
//        this.mTreadOutputColor = treadOutputColor;
//    }

    public DataHandler(ResponseResult rr, String threadName, String treadOutputColor, int numberOfLoops) {
        this.rr = rr;
        this.mThreadName = threadName;
        this.mTreadOutputColor = treadOutputColor;
        this.mNumberOfLoops = numberOfLoops;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(mThreadName);

        for (int i = 0; i < 10; i++) {
            System.out.println(mTreadOutputColor + Thread.currentThread().getName() + " : " + rr.toString());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

//        try {
////            ResponseResult rr = bq.take();
//            System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " : " + rr.toString());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }
}
