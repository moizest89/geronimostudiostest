package moizest89.geronimostudios.test.ui.main;

import android.app.Application;

import moizest89.geronimostudios.test.R;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by moizest89 on 6/10/17.
 */

public class Geronimo extends Application{


    @Override
    public void onCreate() {
        super.onCreate();
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/NotoSansUI-Regular.ttf")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
    }
}
