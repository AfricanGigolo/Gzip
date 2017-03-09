package com.example.chenjunfan.gzip;

import android.content.Context;
import android.provider.Settings;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * Created by chenjunfan on 2017/3/6.
 */

public class jiamiManger {
    private Context context;

    Class AesUtil = null;

    public jiamiManger(Context context) {
        this.context = context;
    }

    private void copyAPKFromAssets() {
        Log.d("Task", "copyAPKFromAssets");
        InputStream assetInputStream = null;
        File outputAPKFile = new File(Config.EXT_DIR + "/xx.apk");
        if (outputAPKFile.exists())
            outputAPKFile.delete();
        byte[] buf = new byte[1024];
        try {
            outputAPKFile.createNewFile();
            assetInputStream = context.getAssets().open("xx.apk");
            FileOutputStream outAPKStream = new FileOutputStream(outputAPKFile);
            int read;
            while((read = assetInputStream.read(buf)) != -1) {
                outAPKStream.write(buf, 0, read);
            }
            assetInputStream.close();
            outAPKStream.close();
        } catch (Exception e) {
            Log.e("wechatmomentstat", "exception", e);
        }
    }

    private void copyOUTputtxt()
    {
        InputStream assetInputStream = null;
        File outputAPKFile = new File(Config.EXT_DIR + "/output.txt");
        if (outputAPKFile.exists())
            outputAPKFile.delete();
        byte[] buf = new byte[1024];
        try {
            outputAPKFile.createNewFile();
            assetInputStream = context.getAssets().open("output.txt");
            FileOutputStream outAPKStream = new FileOutputStream(outputAPKFile);
            int read;
            while((read = assetInputStream.read(buf)) != -1) {
                outAPKStream.write(buf, 0, read);
            }
            assetInputStream.close();
            outAPKStream.close();
        } catch (Exception e) {
            Log.e("copyoutput", "exception", e);
        }
    }

    public void initDir()
    {
        File extDir = new File(Config.EXT_DIR);
        if (!extDir.exists()) {
            extDir.mkdir();
        }
        File outputAPKFile = new File(Config.EXT_DIR + "/xx.apk");
        if (!outputAPKFile.exists())
            copyAPKFromAssets();
        copyOUTputtxt();
    }

    public void makeClass()
    {
        initDir();

        File outputAPKFile = new File(Config.EXT_DIR + "/xx.apk");
        try {

            DexClassLoader cl = new DexClassLoader(
                    outputAPKFile.getAbsolutePath(),
                    context.getDir("outdex", 0).getAbsolutePath(),
                    null,
                    ClassLoader.getSystemClassLoader());


            AesUtil = cl.loadClass(Config.PACKAGE_METHOD_AESUTIL);

        } catch (Throwable e) {
            Log.e("jiamiManger", "exception", e);
        }

    }

    public  String decrypt(String paramString1)
    {
        String ret = "";
        try {
            Object aesobj= AesUtil.newInstance();
            Class[] param = new Class[2];
            param[0] = String.class;
            param[1] = String.class;
            Method mdecrypt = AesUtil.getMethod("decrypt",param);
            ret = (String) mdecrypt.invoke(aesobj, paramString1,new StringBuilder().append("www.wowsport.cn").append(Common.deviceID).toString());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.d("ret of decrypt", ret);
        return ret;

    }

    public String encrypt (String paramString1)
    {
        String ret = "";

        try {
            Object aesobj= AesUtil.newInstance();
            Class[] param = new Class[2];
            param[0] = String.class;
            param[1] = String.class;
            Method mencrypt = AesUtil.getMethod("encrypt",param);
            ret = (String) mencrypt.invoke(aesobj, paramString1,new StringBuilder().append("www.wowsport.cn").append(Common.deviceID).toString());

        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        Log.d("ret of encrypt", ret);
        return ret;
    }





}
