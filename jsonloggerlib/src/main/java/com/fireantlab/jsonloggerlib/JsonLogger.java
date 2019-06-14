package com.fireantlab.jsonloggerlib;

import android.util.Log;

/**
 * Created by Ray Chong on 2019-06-14.
 */
public class JsonLogger {


    private final static String defaultTAG = "JsonLogger";
    private final static int maxLogSize = 1000;


    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }


    private static String convertJsonFormattedString(String s) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for(int index=0;index<s.length();index++)
        {
            char c = s.charAt(index);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }
        return  jsonForMatStr.toString();
    }

    public static void logJson(String TAG, String message){
        final String jsonFormattedStr = convertJsonFormattedString(message);

        for(int i = 0; i <= jsonFormattedStr.length() / maxLogSize; i++) {
            int start = i * maxLogSize;
            int end = (i+1) * maxLogSize;
            end = end > jsonFormattedStr.length() ? jsonFormattedStr.length() : end;
            Log.v(TAG, jsonFormattedStr.substring(start, end));
        }
    }

    public static void logJson(String message){
        logJson(defaultTAG,message);
    }


}
