package com.bpapps.httprequestdemoblockingqueue;

import java.util.concurrent.BlockingQueue;

import static com.bpapps.ThreadColors.ANSI_BLUE;

public class DataHandler implements Runnable {
    private BlockingQueue<ResponseResult> bq;

    public DataHandler(BlockingQueue<ResponseResult> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("DataHandler");
        try {
            ResponseResult rr = bq.take();
            System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " : " + rr.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
