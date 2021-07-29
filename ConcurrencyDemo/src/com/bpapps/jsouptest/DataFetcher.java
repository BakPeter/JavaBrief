package com.bpapps.jsouptest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;


public class DataFetcher implements Runnable {
    private BlockingQueue<ResponseResult> bq;
    private ResponseResult rr;

    private boolean mContinueWork = true;
    private int mNumberOfLoops;
    private String mLink;
    private String mTreadOutputColor;
    private String mThreadName;

    public DataFetcher(BlockingQueue<ResponseResult> bq, int numberOfLoops, String link, String threadName, String treadOutputColor) {
        this.bq = bq;

        this.mNumberOfLoops = numberOfLoops;
        this.mLink = link;
        this.mThreadName = threadName;
        this.mTreadOutputColor = treadOutputColor;
    }

    public DataFetcher(ResponseResult rr, int numberOfLoops, String link, String threadName, String treadOutputColor) {
        this.rr = rr;

        this.mNumberOfLoops = numberOfLoops;
        this.mLink = link;
        this.mThreadName = threadName;
        this.mTreadOutputColor = treadOutputColor;
    }

    @Override
    public void run() {
        Thread.currentThread().setName(this.mThreadName);

        for (int i = 0; i < mNumberOfLoops && isContinueWork(); i++) {
            try {
                URL urlObj = new URL(mLink);
                HttpURLConnection con = (HttpURLConnection) urlObj.openConnection();
                con.setRequestMethod("GET");
                con.setRequestProperty("User-Agent", "Mozilla/5.0");
                int responseCode = con.getResponseCode();
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(con.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                //Read JSON response and print
//                Gson gson = new Gson();
//                ResponseResult rr = gson.fromJson(response.toString(), ResponseResult.class);
//                rr.setResponseCode(responseCode);
//                ResponseResult rr = new ResponseResult(responseCode, Thread.currentThread().getName() );
                rr.setOrigin(Thread.currentThread().getName() + " " + i);
                rr.setResponseCode(responseCode);
                System.out.println(mTreadOutputColor + Thread.currentThread().getName() + " : " + rr.toString());
//                mDataFetchedCallBack.dataFetched(new ResponseResult(responseCode, response.toString()));
//                bq.put(rr);

                Thread.sleep(1000);
            }
            catch (InterruptedException e) {
                System.out.println(mTreadOutputColor + Thread.currentThread().getName() + " interrupted");
                setContinueWork(false);
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized boolean isContinueWork() {
        return mContinueWork;
    }

    public synchronized void setContinueWork(boolean continueWork) {
        this.mContinueWork = continueWork;
        System.out.println(mTreadOutputColor + Thread.currentThread().getName() + " stop work");
    }
}
