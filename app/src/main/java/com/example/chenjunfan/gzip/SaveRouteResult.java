package com.example.chenjunfan.gzip;

/**
 * Created by chenjunfan on 2017/3/6.
 */


import java.io.Serializable;

public class SaveRouteResult
        implements Serializable
{
    private static final long serialVersionUID = 394283845093097540L;
    private String gps_Id;
    private String holdDay;
    private boolean result;
    private String share_1;
    private String share_2;

    public String getGps_Id()
    {
        return this.gps_Id;
    }

    public String getHoldDay()
    {
        return this.holdDay;
    }

    public String getShare_1()
    {
        return this.share_1;
    }

    public String getShare_2()
    {
        return this.share_2;
    }

    public boolean isResult()
    {
        return this.result;
    }

    public void setGps_Id(String paramString)
    {
        this.gps_Id = paramString;
    }

    public void setHoldDay(String paramString)
    {
        this.holdDay = paramString;
    }

    public void setResult(boolean paramBoolean)
    {
        this.result = paramBoolean;
    }

    public void setShare_1(String paramString)
    {
        this.share_1 = paramString;
    }

    public void setShare_2(String paramString)
    {
        this.share_2 = paramString;
    }
}

