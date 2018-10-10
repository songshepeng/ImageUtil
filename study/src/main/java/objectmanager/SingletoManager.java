package objectmanager;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by baidu on 2018/9/20.
 */

public class SingletoManager {
    public static Map<String,Object> objectMap =new HashMap<>();

    public SingletoManager() {
    }
    public static  void registerService (String key , Object instance){
         //containsKey 判断是否存在map集合内
        if (!objectMap.containsKey(key)){
             objectMap.put(key,instance);
        }

    }

     public static Object getService(String key){


        return objectMap.get(key);
     }
}
