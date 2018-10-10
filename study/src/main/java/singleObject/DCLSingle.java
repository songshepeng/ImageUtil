package singleObject;

import objectmanager.SingletoManager;

/**
 * Created by baidu on 2018/9/21.
 *
 * DCL式单例
 */

public class DCLSingle {
    private static DCLSingle mDclSingle = null;

    public DCLSingle() {
    }

    public static DCLSingle getIntance(){
        if (mDclSingle == null) {
            synchronized (DCLSingle.class){
                if (mDclSingle == null) {
                    mDclSingle = new DCLSingle();
                }

            }
        }
        SingletoManager.registerService("DCLSingle",mDclSingle);
         return  mDclSingle ;
    }
}
