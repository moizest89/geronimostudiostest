package moizest89.geronimostudios.test.ui.main;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.data.models.Article;
import moizest89.geronimostudios.test.ui.base.BasePresenter;

/**
 * Created by moizest89 on 6/9/17.
 */

public class MainPresenter extends BasePresenter<IMainView>{

    private Context context;
    private List<Article> mData = new ArrayList<>();
    private final static String TAG = MainPresenter.class.getSimpleName();

    public MainPresenter(Context context) {
        this.context = context;
    }

    private void setDummyData(){


        mData.add(new Article("Funny cats",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/1"));
        mData.add(new Article("Cats Love",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/10"));
        mData.add(new Article("Cats cats everywhere",this.context.getResources().getString(R.string.description_item),"love","http://lorempixel.com/640/400/cats/3"));
        mData.add(new Article("Hate cats? why?",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/4"));
        mData.add(new Article("Meowwww",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/5"));
        mData.add(new Article("True love with cats",this.context.getResources().getString(R.string.description_item),"love","http://lorempixel.com/640/400/cats/6"));


    }


    public void getData(){
        setDummyData();

        List<Article> articleList = new ArrayList<>(this.mData);

        getMvpView().setMainData(articleList);
    }


    public void addRandomArticle(){
//        Log.e(TAG, "mData: "+mData.size());
        getMvpView().setRandomArticle(this.mData.get(1));
    }

}
