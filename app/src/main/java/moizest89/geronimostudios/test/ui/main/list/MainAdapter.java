package moizest89.geronimostudios.test.ui.main.list;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.data.models.Article;
import moizest89.geronimostudios.test.util.OnItemClickListener;
import moizest89.geronimostudios.test.util.PabloPicasso;

/**
 * Created by moizest89 on 6/9/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder>{


    private Context context;
    private OnItemClickListener onItemClickListener;
    private AdapterDataVerify adapterDataVerify;
    private List<Article> mData;
    private final static String TAG = MainAdapter.class.getSimpleName();



    public MainAdapter(Context context, AdapterDataVerify adapterDataVerify) {
        this.context = context;
        this.adapterDataVerify =adapterDataVerify;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_main_list, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Article article = this.mData.get(position);

        holder.item_title.setText(article.getName());
        holder.item_category.setText(article.getCategory());


        //Create singleton for avoid memory leaks
        Picasso picasso = PabloPicasso.with(this.context);
        picasso.load(article.getBanner())
                .placeholder(R.drawable.place_holder_rectangular)
                .error(R.drawable.place_holder_rectangular)
                .into(holder.item_banner);

    }

    @Override
    public int getItemCount() {
        return this.mData.size();
    }


    public void setData(List<Article> data){

        this.mData = data;
        this.notifyDataSetChanged();
    }


    public void addItemToList(Article article){
        this.mData.add(0,article);
        this.notifyItemInserted(0);
        this.adapterDataVerify.itemAddedSuccesfully(true);
        isEmpty();
    }

    public void removeItemToList(){

        if(this.mData.size() > 0) {
            this.mData.remove(0);
            this.notifyItemRemoved(0);
            this.adapterDataVerify.itemDeletedSuccesfully(true);
        }
        isEmpty();
    }


    //Item to verify if recyclerview has data to show and call action to show a simple message into the view
    private void isEmpty(){
        boolean status = (this.mData.size() == 0)? true: false;
        Log.e(TAG, "mData is empty: "+status);
        this.adapterDataVerify.recyclerIsEmpty(status);
    }

    public Article getData(int position){
        return this.mData.get(position);
    }

    public class Holder extends RecyclerView.ViewHolder{


        @BindView(R.id.item_banner)
        ImageView item_banner;
        @BindView(R.id.item_title)
        TextView item_title;
        @BindView(R.id.item_category)
        TextView item_category;

        public Holder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

        }

    }


    public interface AdapterDataVerify{
        void recyclerIsEmpty(boolean status);
        void itemAddedSuccesfully(boolean status);
        void itemDeletedSuccesfully(boolean status);
    }
}
