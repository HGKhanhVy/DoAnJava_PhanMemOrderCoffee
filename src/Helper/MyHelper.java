/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Helper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author DELL
 */
public class MyHelper {

    public static String getMaKH() {
        String maHD = "KH";
        String ngaytemp = getDate();
        String timeTemp = getTime();
        String[] ngays = ngaytemp.split("/");
        String[] times = timeTemp.split(":");

        maHD += ngays[0];
        maHD += ngays[1];
        maHD += times[0];
        maHD += times[1];
        maHD += times[2];

        System.out.println(maHD);
        return maHD;
    }

    public static String getMaHD() {
        String maHD = "HD";
        String ngaytemp = getDate();
        String timeTemp = getTime();
        String[] ngays = ngaytemp.split("/");
        String[] times = timeTemp.split(":");

        maHD += ngays[0];
        maHD += ngays[1];
        maHD += times[0];
        maHD += times[1];
        maHD += times[2];

        System.out.println(maHD);
        return maHD;
    }

    public static String getDate() {
        Date date = new Date();
        SimpleDateFormat DateFor = new SimpleDateFormat("dd/MM/yyyy");
        String stringDate = DateFor.format(date);
        return stringDate;
    }

    public static String getTime() {
        Locale locale = new Locale("fr", "FR");
        DateFormat dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT, locale);
        String date = dateFormat.format(new Date());
        System.out.print(date);
        return date;
    }
    

}
