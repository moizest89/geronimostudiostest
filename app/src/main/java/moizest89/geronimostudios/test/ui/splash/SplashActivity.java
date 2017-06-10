package moizest89.geronimostudios.test.ui.splash;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;

import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.ui.main.MainActivity;
import moizest89.geronimostudios.test.util.Utility;

public class SplashActivity extends AppCompatActivity {

    private long splashDelay = 1000; //a second

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        setTime();

    }


    public void setTime(){

        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Utility.changeActivity(SplashActivity.this, MainActivity.class, null, true);
            }
        };
        Timer timer = new Timer();
        timer.schedule(task, splashDelay);

    }

}
