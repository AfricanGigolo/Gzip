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
        else if(Common.who.equals("ch"))
        {
            setText("彩虹","061510304","45473860802956069","06");
        }
        else if(Common.who.equals("a1"))
        {
            setText("施展","071430302","47733481307776035","07");
        }
        else if(Common.who.equals("a2"))
        {
            setText("杨松","071430307","57225747340752283","07");
        }
        else if(Common.who.equals("a3"))
        {
            setText("苏攀","071430310","46349343370451291","07");
        }
        else if(Common.who.equals("a4"))
        {
            setText("张家硕","071430318","57226733443840072","07");
        }
        else if(Common.who.equals("a5"))
        {
            setText("李维龙","071430309","57243385785206851","07");
        }
        else if(Common.who.equals("a6"))
        {
            setText("张元熹","071430312","57389827953074279","07");
        }
        else if(Common.who.equals("a7"))
        {
            setText("朱江","071430306","57243065999079660","07");
        }
        else if(Common.who.equals("a8"))
        {
            setText("肖天","071430313","46949275911841546","07");
        }
        else if(Common.who.equals("a9"))
        {
            setText("宁顺刚","071430304","49443118312027073","07");
        }
        else if(Common.who.equals("a10"))
        {
            setText("梁小强","071430305","56116938993965699","07");
        }
        else if(Common.who.equals("a11"))
        {
            setText("杨飞","071430308","57456706428713956","07");
        }
        else if(Common.who.equals("rgd"))
        {
            setText("饶港迪","071430229","47653044530617522","07");
        }
        else if(Common.who.equals("wl"))
        {
            setText("吴磊","071430130","56766150454871698","07");
        }
        else if(Common.who.equals("czx"))
        {
            setText("陈志贤","161610333","14093702881212601","16");
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
        SimpleDateFormat formatter2 = new SimpleDateFormat ("HH");
        Date curDate = new Date(System.currentTimeMillis());//获取当前时间
        String date = formatter.format(curDate);
        nameET.setText(name1);
        stuidET.setText(stuid1);
        useridET.setText(userid1);
        dateET.setText(date);
        hourET.setText((Integer.parseInt(formatter2.format(curDate))-Common.getRandom(4,1))+"");
        distanceET.setText(Common.getRandom(199,150)+"0");
        collegeNoET.setText(collegeNo1);
        durtimeET.setText(Common.getRandom(19,15)+":"+Common.getRandom(59,10));
    }






}
