package ir.rmv.bss.ibsng.service.util;

import org.springframework.http.HttpHeaders;

public class IbsngServiceUtil {

    public static HttpHeaders headerHandler() {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", "application/json");
        return headers;
    }
}
