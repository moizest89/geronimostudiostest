package moizest89.geronimostudios.test.ui.main.details;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.transition.Transition;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.data.models.Article;
import moizest89.geronimostudios.test.util.PabloPicasso;
import moizest89.geronimostudios.test.util.Utility;

public class ArticleDetailsActivity extends AppCompatActivity {


    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.article_banner)
    ImageView article_banner;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.category)
    TextView category;
    @BindView(R.id.description)
    TextView description;


    private Article article;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_article_details);

        ButterKnife.bind(this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Bundle data = getIntent().getExtras();
        if (data != null && data.containsKey(Utility.INTENT_DATA)) {



            this.article = data.getParcelable(Utility.INTENT_DATA);

            //Create singleton for avoid memory leaks
            Picasso picasso = PabloPicasso.with(this);
            picasso.load(article.getBanner())
                    .placeholder(R.drawable.place_holder_rectangular)
                    .error(R.drawable.place_holder_rectangular)
                    .into(article_banner);

            this.title.setText(this.article.getName());
            this.category.setText(this.article.getCategory());
            this.description.setText(this.article.getDescription());

            setActionBar();

        }

    }

    public void setActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
//        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_white_24dp);
//        this.toolbar.setTitle(null);
        getSupportActionBar().setTitle(this.article.getName());
        this.toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

}
