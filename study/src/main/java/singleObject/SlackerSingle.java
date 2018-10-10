package singleObject;

import objectmanager.SingletoManager;

/**
 * Created by baidu on 2018/9/21.
 * 懒汉式单例
 */

public class SlackerSingle {
    private static  SlackerSingle mSlackerSingle ;

    public SlackerSingle() {
    }

    public static synchronized SlackerSingle getInstance(){
        if (mSlackerSingle == null) {
            mSlackerSingle =new SlackerSingle();
        }

        SingletoManager.registerService("SlackerSingle",mSlackerSingle);

        http://www.25sc.com/shouyou/shouyou4.php?gid=152&channel=1619
       return mSlackerSingle ;
    }
}
