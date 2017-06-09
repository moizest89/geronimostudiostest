package moizest89.geronimostudios.test.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.data.models.Article;
import moizest89.geronimostudios.test.util.OnItemClickListener;

                    public class MainActivity extends AppCompatActivity implements IMainView,OnItemClickListener {


    //Views injections
    @BindView(R.id.recycler_view)
    RecyclerView recycler_view;
    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private MainPresenter mPresenter;
    private MainAdapter mAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        setActionBar();

        this.mAdapter = new MainAdapter(this);

        //Create a interface called OnItemClickListener to implement ability into RecyclerView
        this.mAdapter.setOnItemClickListener(this);

        this.recycler_view.setLayoutManager(new LinearLayoutManager(this));
        this.recycler_view.setAdapter(this.mAdapter);


        this.mPresenter = new MainPresenter(this);
        this.mPresenter.attachView(this);
        this.mPresenter.getData();



        this.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    private void setActionBar(){
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_item, menu);
        getMenuInflater().inflate(R.menu.menu_remove_item, menu);
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
        }

        return super.onOptionsItemSelected(item);
    }


    //Interface callback
    @Override
    public void onItemClickListener(View view, int position) {

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
}
