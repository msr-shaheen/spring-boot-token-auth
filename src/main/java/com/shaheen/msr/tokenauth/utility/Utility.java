package com.shaheen.msr.tokenauth.utility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class Utility {
    public static final String INVALID_REQUEST_BODY_MESSAGE_EN = "Invalid Request Body";
    public static final String PROCESS_FAILED_MESSAGE_BN = "একটি সমস্যা হয়েছে। পুনরায় চেষ্টা করুন";
    public static final String PROCESS_FAILED_MESSAGE_EN = "Process failed.";

    public static String formattedDateTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS Z");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+6"));
        String dateStr = sdf.format(date);
        return dateStr;
    }

    public static enum SERVICES {
        CashIn,
        B2BTransfer
    };
}
