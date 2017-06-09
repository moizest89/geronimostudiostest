package moizest89.geronimostudios.test.ui.base;

/**
 * Created by moizest89 on 6/9/17.
 */

public interface Presenter <V extends MvpView> {

    void attachView(V mvpView);
    void detachView();
}
