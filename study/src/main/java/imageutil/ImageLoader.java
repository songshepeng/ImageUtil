package imageutil;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by baidu on 2018/9/14.
 */

public class ImageLoader {
       //图片缓存类
    MImageCache  mImageCache = new ImageCache();

     //创建线程池，维护任务
    ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
     // 创建更新UI Handler
    Handler mUiHanler =  new Handler(Looper.getMainLooper());

/**
 *
 * 设置缓存的类型，可自定义实现
 */


    public void setType(MImageCache ImageCache){
        mImageCache =ImageCache;
    }

/**
 * 修改图片背景
 *
 */

    private  void UpdateImageView(final ImageView imageView, final Bitmap bitmap){
        mUiHanler.post(new Runnable() {
            @Override
            public void run() {
                imageView .setImageBitmap(bitmap);
            }
        });
    }

    /**
     *
     * 通过路劲修改图片背景
     */


    public  void  displayImageView(final String url , final  ImageView imageView){
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }
        //图片没缓存则 提交到缓存池下载
        submitRequst(url,imageView);
    }

    public void submitRequst(final String url,final  ImageView imageView){
        imageView.setTag(url);
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap1 = donwloadImageView(url);
                if (bitmap1 == null) {
                    return;
                }
                if (imageView.getTag().equals(url)){
                    UpdateImageView(imageView,bitmap1);
                }

                mImageCache.put(url,bitmap1);
            }
        });
    }

    /**
     *   网络加载图片
     */

    public Bitmap donwloadImageView(String url){
        Bitmap bitmap = null;
        try {
            URL uri = new URL(url);
            HttpURLConnection urlConnection = (HttpURLConnection) uri.openConnection();
            bitmap = BitmapFactory.decodeStream(urlConnection.getInputStream());
            urlConnection.disconnect();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return  bitmap;
    }
}
