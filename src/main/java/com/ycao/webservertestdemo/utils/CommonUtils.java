package com.ycao.webservertestdemo.utils;

import javax.servlet.http.HttpServletRequest;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Type CommonUtils.java
 * @Desc Common utils
 * @author yuan.cao@utbm.fr
 * @date 01/05/2022 13:49
 * @version 1.0
 */
public class CommonUtils {

    /**
    * @DESC return the closest floating-point value that is equal to a mathematical integer and cast it.
    * @param Double
    * @return Integer
    * @data 02/05/2022 00:28
    * @author yuan.cao@utbm.fr
    **/
    public static Integer doubleToInteger(Double d){
        if (d==null){
            return null;
        }
        double di = Math.rint(d);
        return Integer.valueOf( (int) di);
    }

    /**
     * @param request
     * @return IP Address
     */
    public static String getIpAddrByRequest(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * String to token
     * @param
     * @return String
     */
    public static String getTokenStr(String str) {
        String pattern = "token:(.*?)$";
        Pattern r1 = Pattern.compile(pattern);
        Matcher m1 = r1.matcher(str);
        List<String> resList = new ArrayList<>();
        while(m1.find()){
            resList.add(m1.group(1).trim());
        }
        if(resList.size()!=1){
            return null;
        }else{
            String res = resList.toString();
            res = res.replace("[","")
                    .replace("]","");
            return res;
        }
    }

    /**
    * @DESC Generate random ID: current hour, minute, second + two random numbers
    * @param
    * @return
    * @data 16/05/2022 11:44
    * @author yuan.cao@utbm.fr
    **/
    public static Integer getRandomID() {

        SimpleDateFormat simpleDateFormat;

        simpleDateFormat = new SimpleDateFormat("HHmmss");

        Date date = new Date();

        String str = simpleDateFormat.format(date);

        int rannum = (int)(1+Math.random() * 99);// 获取随机数1-99

        return Integer.valueOf(str + rannum);// 当前时间
    }

    /**
    * @DESC Get the day of the week: 0-6:Monday-Sunday
    * @param
    * @return
    * @data 20/05/2022 12:10
    * @author yuan.cao@utbm.fr
    **/
    public static Integer getCurWeek() {
        Integer week=-1;
        Date today = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(today);
        int weekday = c.get(Calendar.DAY_OF_WEEK);
        if (weekday == 1) {
            week = 6;
        } else if (weekday == 2) {
            week = 0;
        } else if (weekday == 3) {
            week = 1;
        } else if (weekday == 4) {
            week = 2;
        } else if (weekday == 5) {
            week = 3;
        } else if (weekday == 6) {
            week = 4;
        } else if (weekday == 7) {
            week = 5;
        }
        return week;
    }

    /**
    * @DESC get current time : HH:mm
    * @param
    * @return
    * @data 21/05/2022 00:13
    * @author yuan.cao@utbm.fr
    **/
    public static String getCurTime(){
        SimpleDateFormat simpleDateFormat;
        simpleDateFormat = new SimpleDateFormat("HH:mm");
        Date date = new Date();
        String str = simpleDateFormat.format(date);
        return str;
    }

}