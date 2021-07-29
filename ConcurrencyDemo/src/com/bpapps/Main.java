package com.bpapps;

import com.bpapps.jsouptest.DataFetcher;
import com.bpapps.jsouptest.DataHandler;
import com.bpapps.jsouptest.LinksUtil;
import com.bpapps.jsouptest.ResponseResult;

import java.util.Map;

public class Main {
    //jsoup
    public static void main(String[] args) {
//        String html = "<html><head><title>First parse</title></head><body><p>Parsed HTML into a doc.</p><p>Parsed HTML into a doc.</p><p>Parsed HTML into a doc.</p></body></html>";
//        Document doc = Jsoup.parse(html);
//        Elements elems =  doc.select("p");
//        for (Element elem :
//                elems) {
//            System.out.println(elem.text());
//        }
        Map<String, String> links = LinksUtil.getLinks();
        System.out.println(Thread.currentThread().getName() + " thread " + links);

        for (Map.Entry<String, String> entry : links.entrySet()) {
            ResponseResult rr = new ResponseResult();
            DataFetcher df = new DataFetcher(rr, 10, entry.getValue(), entry.getKey() + " fetcher thread", ThreadColors.ANSI_GREEN);
            DataHandler dh = new DataHandler(rr, entry.getKey() +"handler thread", ThreadColors.ANSI_BLUE, 10);
            new Thread(dh).start();
            new Thread(df).start();
        }
//        BlockingQueue<ResponseResult> bq1 = new ArrayBlockingQueue<>(1);
//        ResponseResult rr1 = new ResponseResult();
//        DataFetcher df1 = new DataFetcher(rr1, 10, links.get("ynet"), "ynet fetcher thread", ThreadColors.ANSI_CYAN);
//        DataHandler dh1 = new DataHandler(rr1, "ynet handler thread", ThreadColors.ANSI_BLUE, 10);
//        new Thread(dh1).start();
//        new Thread(df1).start();

//        BlockingQueue<ResponseResult> bq2 = new ArrayBlockingQueue<>(1);
//        DataFetcher df2 = new DataFetcher(bq2, 10, links.get("ebay"), "ebay fetcher thread", ThreadColors.ANSI_CYAN);
//        DataHandler dh2 = new DataHandler(bq2, "ebay handler thread", ThreadColors.ANSI_CYAN);
//        new Thread(df2).start();
//        new Thread(dh2).start();

        int x = 9;
    }
    //    http request demo blocking queue
//    public static void main(String[] args) {
//        System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " start");
//
//        BlockingQueue<ResponseResult> bq = new ArrayBlockingQueue<ResponseResult>(1);
//
//        DataFetcher df = new DataFetcher(bq);
//        DataHandler dh = new DataHandler(bq);
//
//        new Thread(df).start();
//        new Thread(dh).start();
//
//        System.out.println(ANSI_BLUE + Thread.currentThread().getName() + " end");
//    }

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
