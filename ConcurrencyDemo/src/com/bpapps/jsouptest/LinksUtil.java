package com.bpapps.jsouptest;

import java.util.HashMap;
import java.util.Map;

public class LinksUtil {
    public static Map<String, String> getLinks() {
        Map<String, String> retVal = new HashMap<>();
        retVal.put("ynet", "https://www.ynet.co.il/home/0,7340,L-8,00.html");
        retVal.put("bizportal", "https://www.bizportal.co.il/");
        retVal.put("amazon", "https://www.amazon.com/");
        retVal.put("ebay", "https://www.ebay.com/");

        return retVal;
    }
}
