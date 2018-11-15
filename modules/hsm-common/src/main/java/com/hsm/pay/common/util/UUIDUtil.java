package com.hsm.pay.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UUIDUtil {
    public static String orderNo(){
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        long time=System.currentTimeMillis();
        String random = String.valueOf((Math.random() * 9 + 1) * 1000000);
        String numStr = random.toString().substring(0, 4);
        return sdf.format(new Date())+time+numStr;
    }
}
