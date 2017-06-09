package moizest89.geronimostudios.test.util;

import android.content.Context;

import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

/**
 * Created by moizest89 on 6/9/17.
 */

public class PabloPicasso {

    private static Picasso instance;

    public static Picasso with(Context context) {
        if (instance == null) {

            instance = new Picasso.Builder(context)
                    .downloader(new OkHttp3Downloader(context))
                    .build();
        }
        return instance;
    }

    private PabloPicasso() {
        throw new AssertionError("No instances.");
    }

}
