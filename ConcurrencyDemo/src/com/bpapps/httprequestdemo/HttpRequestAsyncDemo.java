package com.bpapps.httprequestdemo;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import static com.bpapps.ThreadColors.ANSI_GREEN;

public class HttpRequestAsyncDemo {

    private IDataFetchedListener mDataFetchedCallBack;

    public HttpRequestAsyncDemo(IDataFetchedListener dataFetchedCallBack) {
        this.mDataFetchedCallBack = dataFetchedCallBack;
    }

    public void get() {
        new Thread(() -> {
            Thread.currentThread().setName("HttpRequestAsyncDemo");
            String url = "http://httpbin.org/ip";
            try {
                URL urlObj = new URL(url);
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
                Gson gson = new Gson();
                ResponseResult rr = gson.fromJson(response.toString(), ResponseResult.class);
                rr.responseCode = responseCode;

                System.out.println(ANSI_GREEN + Thread.currentThread().getName() +" : "+ response.toString());
//                mDataFetchedCallBack.dataFetched(new ResponseResult(responseCode, response.toString()));
                mDataFetchedCallBack.dataFetched(rr);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
//            try {
//                Thread.sleep(3000);
//                mDataFetchedCallBack.dataFetched(new FetchedData("thread slept 3 seconds, test data fetched"));
//
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }).start();
    }

    public interface IDataFetchedListener {
        void dataFetched(ResponseResult data);
    }

    public class ResponseResult {

        private int responseCode;
        private String origin;

        public ResponseResult(int responseCode, String origin) {
            this.responseCode = responseCode;
            this.origin = origin;
        }

        @Override
        public String toString() {
            return "ResponseResult{" +
                    "responseCode=" + responseCode +
                    ", origin='" + origin + '\'' +
                    '}';
        }
    }
}
