package moizest89.geronimostudios.test.ui.main.list;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.data.models.Article;
import moizest89.geronimostudios.test.ui.main.details.ArticleDetailsActivity;
import moizest89.geronimostudios.test.util.ClickListener;
import moizest89.geronimostudios.test.util.RecyclerTouchListener;
import moizest89.geronimostudios.test.util.Utility;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements IMainView, MainAdapter.AdapterDataVerify {


    //Views injections
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.text_message)
    TextView text_message;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private MainPresenter mPresenter;
    private MainAdapter mAdapter;

    private final static String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);


        setActionBar();


        //Adapter receives context and interface to verify when data is empty
        this.mAdapter = new MainAdapter(this,this);

        //Create a interface called OnItemClickListener to implement ability into RecyclerView
        this.recycler_view.addOnItemTouchListener(new RecyclerTouchListener(this, recycler_view, new ClickListener() {
            @Override
            public void onClick(View view, int position) {

                Article article = mAdapter.getData(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Utility.INTENT_DATA, article);;
                Utility.changeActivity(MainActivity.this, ArticleDetailsActivity.class, bundle, false);

            }
        }));

        this.recycler_view.setLayoutManager(new LinearLayoutManager(this));
        this.recycler_view.setAdapter(this.mAdapter);


        this.mPresenter = new MainPresenter(this);
        this.mPresenter.attachView(this);
        this.mPresenter.getData();



        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.addRandomArticle();
            }
        });
    }


    private void setActionBar(){
        setSupportActionBar(toolbar);
        getSupportActionBar().setIcon(R.drawable.circle_plume);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        getMenuInflater().inflate(R.menu.menu_remove_item, menu);
        getMenuInflater().inflate(R.menu.menu_about_me, menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_add_item) {
            mPresenter.addRandomArticle();
            return true;
        }else if(id == R.id.menu_remove_item){
            mAdapter.removeItemToList();
            return true;
        }else if(id == R.id.menu_about_me){
            showAboutMe();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public void setMainData(List<Article> data) {
        this.mAdapter.setData(data);
    }

    @Override
    public void setRandomArticle(Article article) {
        this.mAdapter.addItemToList(article);
        this.recycler_view.scrollToPosition(0);
    }

    //RecyclerView callbacks methods
    @Override
    public void recyclerIsEmpty(boolean status) {

        //If the recycler view is empty, show message and desable
        //menu icon.

        if(status){
            this.text_message.setVisibility(View.VISIBLE);
            toolbar.getMenu().getItem(1).setEnabled(false);
        }else{
            this.text_message.setVisibility(View.INVISIBLE);
            toolbar.getMenu().getItem(1).setEnabled(true);
        }
    }

    @Override
    public void itemAddedSuccesfully(boolean status) {
        showSimpleMessage(R.string.message_item_added);
    }

    @Override
    public void itemDeletedSuccesfully(boolean status) {
        showSimpleMessage(R.string.message_item_deleted);
    }


    private void showAboutMe(){
        Utility.showAboutMeDialog(this);
    }

    //Show toast message
    private void showSimpleMessage(int message){
        //My first option was a Snackbar but I didn't like animation
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
//        Snackbar.make(this.fab, message, Snackbar.LENGTH_SHORT).show();
    }
}
