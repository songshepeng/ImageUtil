package util;

import android.graphics.Bitmap;

/**
 * Created by baidu on 2018/9/17.
 */

public interface MImageCache {
    void put(String url , Bitmap bitmap);
    Bitmap get(String url);
}
