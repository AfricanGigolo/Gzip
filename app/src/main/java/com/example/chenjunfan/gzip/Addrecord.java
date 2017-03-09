package com.example.chenjunfan.gzip;

import android.content.Context;
import android.os.Build;
import android.os.Looper;
import android.provider.Settings;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by chenjunfan on 2017/3/6.
 */

public class Addrecord {

    public Addrecord(Context context, String date, String name, String stuid, String userid,String hour,String distance,String collegeNo,String durtime) {
        this.context = context;
        this.date = date;
        this.name = name;
        this.stuid = stuid;
        this.userid = userid;
        this.hour = hour;
        this.distance = distance;
        deviceID = Common.deviceID;
        this.collegeNo= collegeNo;
        this.durtime = durtime;
    }

    private Context context;
    private String date;
    private String hour;
    private String name;
    private String stuid;
    private String userid;
    private String devmoule = Common.devmoule;
    private String deviceID;
    private String distance;
    private String collegeNo;
    private String durtime;

    public void add()
    {
        new Thread() {


            @Override
            public void run() {
// TODO Auto-generated method stub
                Looper.prepare();
                final String urlPath = "http://58.213.141.235:8080/qmjs_FEP/datewalk/createSportTrack.action";
                URL url;
                try {
                    url = new URL(urlPath);
/*封装子对象*/
                    JSONObject header = new JSONObject();
                    header.put("devModuleID", devmoule);
                    header.put("funcId", "");
                    header.put("userId", userid);
                    header.put("accessToken", "0");
                    header.put("verOrgCode", "3");
                    header.put("appId", "");
                    header.put("stuName", name);
                    header.put("loginId", "nuaa"+stuid);
                    header.put("cityCode", "320100");
                    header.put("devType", "1");
                    header.put("sysCode", "");
                    header.put("authType", "1");
                    header.put("orgCode", "10002");
                    header.put("appVersion", "0.6.1");
                    header.put("collegeNo", collegeNo);
                    header.put("retMessage", "0");
                    header.put("campus", "2");
                    header.put("osVersion", "1");
                    header.put("interceptTime", "");
                    header.put("configurationVersion", "2.52");
                    header.put("currentCityCode", "320100");
                    header.put("devId", deviceID);
                    header.put("retStatus", "0");

                    jiamiManger jima = new jiamiManger(context);
                    jima.makeClass();


                    String encodestr = readTxtFile();
                    encodestr = encodestr.replaceAll("2017-03-06",date);
                    encodestr = encodestr.replaceAll("45058596413064498",userid);
                    encodestr = encodestr.replaceAll("REPLACE_HOUR",hour);
                    encodestr = encodestr.replace("1760.0",distance+".0");
                    encodestr = encodestr.replace("148877","148897");
                    encodestr = encodestr.replace("DURTIME",durtime);
                    Log.d("加密前：", encodestr);

                    encodestr = jima.encrypt(encodestr);




/*封装Person数组*/
                    JSONObject JSON = new JSONObject();
                    JSON.put("header", header);
                    JSON.put("body", "'" + encodestr + "'");
/*把JSON数据转换成String类型使用输出流向服务器写*/
                    String content = String.valueOf(JSON);
                    Log.d("update", content);
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setConnectTimeout(5000);
                    conn.setDoOutput(true);//设置允许输出
                    conn.setRequestMethod("POST");
                    conn.setRequestProperty("User-Agent", "Fiddler");
                    conn.setRequestProperty("Content-Type", "application/json");
                    conn.setRequestProperty("Charset", "UTF-8");
                    OutputStream os = conn.getOutputStream();
                    os.write(content.getBytes());
                    os.close();
/*服务器返回的响应码*/

                    BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
                    String retData = null;
                    String responseData = "";
                    while ((retData = in.readLine()) != null) {
                        responseData += retData;
                    }
                    Log.d("MainActivity", responseData);
                    String ret = jima.decrypt(responseData);
                    Log.d("return", ret);
                    Toast.makeText(context, ret, Toast.LENGTH_SHORT).show();


                } catch (Exception e) {
// TODO: handle exception
                    throw new RuntimeException(e);
                }
                Looper.loop();
            }

        }.start();
    }

    private  String readTxtFile(){
        String str="";
        try {
            String encoding="utf-8";
            File file=new File(Config.EXT_DIR+"/output.txt");
            if(file.isFile() && file.exists()){ //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file),encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while((lineTxt = bufferedReader.readLine()) != null){
                    str = str+lineTxt;
                }
                read.close();
            }else{
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return str;

    }


}


