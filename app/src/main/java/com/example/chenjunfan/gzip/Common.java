package com.example.chenjunfan.gzip;

import java.util.Random;

/**
 * Created by chenjunfan on 2017/3/6.
 */

public class Common {
     public static String who ="";
     public static String date="";
     public static String devmoule = "Google Pixel";
     public static String deviceID ="4653a015ad8ee22d";

     public static int getRandom(int max,int min)
     {
          Random random = new Random();
          int s = random.nextInt(max)%(max-min+1) + min;
          return s;
     }
}
