package moizest89.geronimostudios.test.ui.main;

import java.util.List;

import moizest89.geronimostudios.test.data.models.Article;
import moizest89.geronimostudios.test.ui.base.MvpView;

/**
 * Created by moizest89 on 6/9/17.
 */

public interface IMainView extends MvpView{

    void setMainData(List<Article> data);
    void setRandomArticle(Article article);
}
