package com.crbaldwin.osu_wrapper.util;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;

public class API_Request {

    public JSONObject callApi(String url) throws IOException, JSONException {
        InputStream is = new URL(url).openStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            if(jsonText.length()>2) {
                jsonText = fixOsuJson(jsonText);
                JSONObject json = new JSONObject(jsonText);
                return json;
            }
            else {
                return null;
            }
        } finally {
            is.close();
        }
    }

    private String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    private String fixOsuJson(String jsonTxt) {
        StringBuilder fixed = new StringBuilder(jsonTxt);

        fixed.deleteCharAt(jsonTxt.length()-1);
        fixed.deleteCharAt(0);
        //fixed.deleteCharAt(1);

        return fixed.toString();
    }
}
