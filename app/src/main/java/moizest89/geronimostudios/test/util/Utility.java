package moizest89.geronimostudios.test.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;

import moizest89.geronimostudios.test.R;

/**
 * Created by moizest89 on 6/10/17.
 */

public class Utility {


    public final static String INTENT_DATA = "data";

    public static void changeActivity(Context context, Class<?> target, Bundle options, boolean finish) {
        Intent i = new Intent(context, target);

        if (options != null)
            i.putExtras(options);

        context.startActivity(i);

        if (finish)
            ((Activity) context).finish();

    }


    public static void showAboutMeDialog(Context context){
        new AlertDialog.Builder(context)
                .setView(R.layout.item_about_me)
                .setPositiveButton(android.R.string.ok, null)
                .create().show();
    }


}
