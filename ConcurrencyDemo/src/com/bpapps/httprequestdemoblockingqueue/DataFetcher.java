package com.bpapps.httprequestdemoblockingqueue;

import com.google.gson.Gson;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.concurrent.BlockingQueue;

import static com.bpapps.ThreadColors.ANSI_GREEN;

public class DataFetcher implements Runnable {
    private BlockingQueue<ResponseResult> bq;

    public DataFetcher(BlockingQueue<ResponseResult> bq) {
        this.bq = bq;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("DataFetcher");
        String url = "https://www.w3schools.com/whatis/whatis_htmldom.asp";
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
            rr.setResponseCode(responseCode);

            System.out.println(ANSI_GREEN + Thread.currentThread().getName() + " : " + response.toString());
//                mDataFetchedCallBack.dataFetched(new ResponseResult(responseCode, response.toString()));
            bq.put(rr);
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}