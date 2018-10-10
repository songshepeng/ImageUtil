package singleObject;

import objectmanager.SingletoManager;

/**
 * Created by baidu on 2018/9/21.
 * 静态内部类单例模式
 *
 */

public class SICSingle {
    public SICSingle() {
    }


    public static SICSingle getInstance(){

        SingletoManager.registerService("SICSingle",InstanceHoder.mSicSingle);

        return  InstanceHoder.mSicSingle;
    }

    private static class InstanceHoder{

         private static final SICSingle mSicSingle  =new SICSingle();
     }
}
