package moizest89.geronimostudios.test.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
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
    private List<Article> data = new ArrayList<>();

    public MainAdapter(Context context) {
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {


        View v = LayoutInflater.from (parent.getContext ()).inflate (R.layout.item_main_list, parent, false);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        Article article = this.data.get(position);

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
        return this.data.size();
    }


    public void setData(List<Article> mData){
        this.data = mData;
        this.notifyDataSetChanged();
    }


    public void addItemToList(Article article){
        this.data.add(0,article);
        this.notifyItemInserted(0);

    }
    
    public void removeItemToList(){
        this.data.remove(0);
        this.notifyItemRemoved(0);
    }

    //Public method to set OnClickListener ability via Interface
    public void setOnItemClickListener(OnItemClickListener clickListener){
        this.onItemClickListener = clickListener;
    }

    public class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{


        @BindView(R.id.item_banner)
        ImageView item_banner;
        @BindView(R.id.item_title)
        TextView item_title;
        @BindView(R.id.item_category)
        TextView item_category;

        public Holder(View itemView) {
            super(itemView);

            ButterKnife.bind(this,itemView);

            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            //Set behavior into each row
            onItemClickListener.onItemClickListener(v, getAdapterPosition());
        }
    }
}
