package com.bpapps.httprequestdemoblockingqueue;

public class ResponseResult {

    private int responseCode;
    private String origin;

    public ResponseResult(int responseCode, String origin) {
        this.responseCode = responseCode;
        this.origin = origin;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
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
