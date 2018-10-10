package imageutil;

import android.graphics.Bitmap;

/**
 * Created by baidu on 2018/9/17.
 */

public class DoubleCache implements MImageCache {
   ImageCache mImageCache  =  new ImageCache();
   DiskCache  mDiskCache   =  new DiskCache();
    @Override
    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url,bitmap);
        mDiskCache.put(url,bitmap);
    }

    @Override
    public Bitmap get(String url) {
        Bitmap bitmap = mImageCache.get(url);
        if (bitmap == null) {
            bitmap = mDiskCache.get(url);
        }
        return bitmap;
    }
}
