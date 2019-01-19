package com.rsouza01.urlrzr.utils;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlRzrUtils {

    public static boolean isUrlValid(String url) {
        boolean valid = true;
        try {
            new URL(url);
        } catch (MalformedURLException e) {
            valid = false;
        }
        return valid;
    }

}
