package moizest89.geronimostudios.test.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by moizest89 on 6/10/17.
 */

public class Utility {


    public static void changeActivity(Context context, Class<?> target, Bundle options, boolean finish) {
        Intent i = new Intent(context, target);

        if (options != null)
            i.putExtras(options);

        context.startActivity(i);

        if (finish)
            ((Activity) context).finish();

    }


}
