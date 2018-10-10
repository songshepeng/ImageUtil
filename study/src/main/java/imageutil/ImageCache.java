package imageutil;

import android.graphics.Bitmap;
import android.util.LruCache;



/**
 * 内存缓存
 * Created by baidu on 2018/9/14.
 */

public class ImageCache implements MImageCache{

    LruCache<String,Bitmap>mImageCache ;

    public ImageCache() {
         initImageCache();
    }

    private void initImageCache() {

        //最大内存
        final  int maxMeony = (int) (Runtime.getRuntime().maxMemory() / 1024);
        //最大容量超过这个容量就自动回收
        final  int cacheSize = maxMeony/4 ;
        mImageCache = new LruCache<String,Bitmap>(cacheSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()* value.getHeight()/1024;
                //getRowBytes 每一行占用的字节数
            }
        };
    }

    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url,bitmap);

    }

    @Override
    public Bitmap get(String url) {
        return mImageCache.get(url);
    }
}
