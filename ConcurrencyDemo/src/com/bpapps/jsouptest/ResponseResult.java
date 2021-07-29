package com.bpapps.jsouptest;

public class ResponseResult {

    private int responseCode;
    private String origin;

    public ResponseResult() {
    }

    public ResponseResult(int responseCode, String origin) {
        this.responseCode = responseCode;
        this.origin = origin;
    }

    public synchronized int getResponseCode() {
        return responseCode;
    }

    public synchronized void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public synchronized String getOrigin() {
        return origin;
    }

    public synchronized void setOrigin(String origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return responseAsString();
    }

    private synchronized String responseAsString() {
        return "ResponseResult{" +
                "responseCode=" + responseCode +
                ", origin='" + origin + '\'' +
                '}';
    }
}
