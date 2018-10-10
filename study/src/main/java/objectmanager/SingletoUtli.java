package objectmanager;

import singleObject.DCLSingle;
import singleObject.SICSingle;
import singleObject.SlackerSingle;

/**
 * Created by baidu on 2018/9/21.
 */

public class SingletoUtli {



    public static void  put(){
        DCLSingle mDclSingle = DCLSingle.getIntance();
        SICSingle mSICSingle= SICSingle.getInstance();
        SlackerSingle mSlackerSingle = SlackerSingle.getInstance();
        SingletoManager.registerService("DCLSingle",mDclSingle);
        SingletoManager.registerService("SICSingle",mSICSingle);
        SingletoManager.registerService("SlackerSingle",mSlackerSingle);
    }
}
