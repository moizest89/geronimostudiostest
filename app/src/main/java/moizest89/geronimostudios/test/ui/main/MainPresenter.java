package moizest89.geronimostudios.test.ui.main;

import android.content.Context;

import java.util.ArrayList;
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

    public MainPresenter(Context context) {
        this.context = context;

        mData = setDummyData();

    }

    private List<Article> setDummyData(){

        List<Article> data = new ArrayList<>();

        data.add(new Article("Funny cats",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/1"));
        data.add(new Article("Cats Love",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/10"));
        data.add(new Article("Cats cats everywhere",this.context.getResources().getString(R.string.description_item),"love","http://lorempixel.com/640/400/cats/3"));
        data.add(new Article("Hate cats? why?",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/4"));
        data.add(new Article("Meowwww",this.context.getResources().getString(R.string.description_item),"cats","http://lorempixel.com/640/400/cats/5"));
        data.add(new Article("True love with cats",this.context.getResources().getString(R.string.description_item),"love","http://lorempixel.com/640/400/cats/6"));

        return data;

    }


    public void getData(){
        getMvpView().setMainData(this.mData);
    }


    public void addRandomArticle(){

        Article article = this.mData.get(3);

        getMvpView().setRandomArticle(article);
    }

}
