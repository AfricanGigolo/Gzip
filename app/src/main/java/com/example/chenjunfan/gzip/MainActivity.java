package com.example.chenjunfan.gzip;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Looper;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    EditText nameET,stuidET,useridET,dateET,hourET,distanceET,collegeNoET,durtimeET;
    Button addBT;
    //String name,stuid,userid,date,hour,distance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameET = (EditText) findViewById(R.id.et_name);
        stuidET = (EditText) findViewById(R.id.et_stuid);
        useridET = (EditText) findViewById(R.id.et_userid);
        dateET = (EditText) findViewById(R.id.et_date);
        hourET = (EditText) findViewById(R.id.et_time);
        distanceET = (EditText) findViewById(R.id.et_distance);
        collegeNoET = (EditText) findViewById(R.id.et_collegeNo);
        durtimeET = (EditText) findViewById(R.id.et_durtime);
        addBT = (Button) findViewById(R.id.bt_add);


        if(Common.who.equals("cjf"))
        {
            setText("陈俊帆","161430120","45058596413064498","16");
        }
        else if(Common.who.equals("xc"))
        {
            setText("徐畅","161430105","323819658991574","16");
        }
        else if(Common.who.equals("xl"))
        {
            setText("熊澜","161420307","56808193194148589","16");

        }
        else if(Common.who.equals("wyy"))
        {
            setText("王玥玥","061510305","56423236160199708","06");
        }
        else if(Common.who.equals("zyf"))
        {
            setText("赵玙璠","041400802","56724982310262776","13");
        }
        else if(Common.who.equals("lcy"))
        {
            setText("罗晨宇","071430129","57223657085750595","07");
        }
        else if(Common.who.equals("ldy"))
        {
            setText("李迪媛","161430203","56787227642362244","16");
        }
        else if(Common.who.equals("jy"))
        {
            setText("蒋毅","071430101","57221344406757279","07");
        }
        else if(Common.who.equals("wj"))
        {
            setText("王杰","071430103","57563404154063072","07");
        }
        else if(Common.who.equals("zrj"))
        {
            setText("张润嘉","071420121","47617981581902608","07");
        }
        else if(Common.who.equals("tf"))
        {
            setText("田凤","041400806","56761708563026726","13");
        }
        else
        {
            setText(Common.who,"","","");
        }
        addBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (nameET.getText().equals("")||stuidET.getText().equals("")||dateET.getText().equals("")||hourET.getText().equals("")||dateET.getText().equals("2017-0-")||collegeNoET.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "请完整填写信息", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Addrecord addrecord = new Addrecord(MainActivity.this,dateET.getText().toString(),nameET.getText().toString(),stuidET.getText().toString(),useridET.getText().toString(),hourET.getText().toString(),distanceET.getText().toString(),collegeNoET.getText().toString(),durtimeET.getText().toString());
                    addrecord.add();
                    if(Common.who.equals("xc"))
                    {
                        Toast.makeText(MainActivity.this, "丫头，蕃蕃爱你哦~ 么么哒 去觅动校园看看记录吧", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        //Toast.makeText(MainActivity.this, "打卡完成", Toast.LENGTH_SHORT).show();
                    }
                    finish();
                }

            }
        });


    }

    private void setText(String name1,String stuid1,String userid1,String collegeNo1)
    {
        SimpleDateFormat formatter = new SimpleDateFormat ("yyyy-MM-dd");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String date = formatter.format(curDate);
        nameET.setText(name1);
        stuidET.setText(stuid1);
        useridET.setText(userid1);
        dateET.setText(date);
        hourET.setText("12");
        distanceET.setText("1760");
        collegeNoET.setText(collegeNo1);
    }






}
