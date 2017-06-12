package moizest89.geronimostudios.test.ui.main.zoom_image;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.util.PabloPicasso;
import moizest89.geronimostudios.test.util.TouchImageView;
import moizest89.geronimostudios.test.util.Utility;

public class ZoomImageVIewActivity extends AppCompatActivity {


    @BindView(R.id.pinch_imageview)
    TouchImageView pinch_imageview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zoom_image_view);

        ButterKnife.bind(this);

        Bundle data = getIntent().getExtras();
        if (data != null && data.containsKey(Utility.INTENT_DATA)) {

            String image_url = data.getString(Utility.INTENT_DATA);


            Picasso picasso = PabloPicasso.with(this);
            picasso.load(image_url)
                    .placeholder(R.drawable.place_holder_rectangular)
                    .error(R.drawable.place_holder_rectangular)
                    .into(pinch_imageview);

        }

    }

}
