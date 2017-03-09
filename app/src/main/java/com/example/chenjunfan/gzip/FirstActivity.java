package com.example.chenjunfan.gzip;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * Created by chenjunfan on 2017/3/6.
 */

public class FirstActivity extends Activity{
    EditText nameET,devmET,deviET;
    Button yesBT,fanyiBT;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        jiamiManger jiami = new jiamiManger(FirstActivity.this);
        jiami.initDir();

        nameET = (EditText) findViewById(R.id.et_first_name);
        yesBT = (Button) findViewById(R.id.bt_first_yes);
        devmET = (EditText) findViewById(R.id.et_devmoule);
        deviET = (EditText) findViewById(R.id.et_deviceid);
        fanyiBT = (Button) findViewById(R.id.bt_first_fanyi);

        devmET.setText(Build.MODEL);
        deviET.setText(Settings.Secure.getString(FirstActivity.this.getContentResolver(), "android_id"));

        yesBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.who = nameET.getText().toString();
                if(nameET.getText().toString().equals("cjf"))
                {
                    Common.devmoule="Google Nexus5";
                    Common.deviceID = "f6f5f615ce077f35";
                }
                else if(nameET.getText().toString().equals("xc"))
                {
                    Common.devmoule="SM-G9350";
                    Common.deviceID = "6f2c22badc1596d5";
                }
                else
                {
                    Common.devmoule="Redmi Note 2";
                    Common.deviceID = "4653b015ad8ef22d";
                }
                startActivity(new Intent(FirstActivity.this,MainActivity.class));
            }
        });
        fanyiBT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fanyi("");
            }
        });



    }

    public void fanyi(String content)
    {

        try {
            File f = new File(Config.EXT_DIR+"/fanyi.txt");
            if (f.exists()) {
                System.out.print("文件存在");
            } else {
                System.out.print("文件不存在");
                f.createNewFile();// 不存在则创建
            }



            BufferedWriter output = new BufferedWriter(new FileWriter(f));
            jiamiManger jiami = new jiamiManger(FirstActivity.this);
            jiami.makeClass();
            output.write(jiami.decrypt(content));
            output.close();
        } catch (Exception e) {
            e.printStackTrace();

        }
    }


}

/*设备：
   Google Nexus5
   f6f5f615ce077f35

   Google Pixel
   b67575c06c9e629f

   Redmi Note 4
   4653a015ad8ff22d




 */
