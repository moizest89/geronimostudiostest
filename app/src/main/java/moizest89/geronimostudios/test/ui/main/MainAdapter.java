package moizest89.geronimostudios.test.ui.main;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import moizest89.geronimostudios.test.R;
import moizest89.geronimostudios.test.util.OnItemClickListener;

/**
 * Created by moizest89 on 6/9/17.
 */

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.Holder>{


    private Context context;
    private OnItemClickListener onItemClickListener;

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

    }

    @Override
    public int getItemCount() {
        return 5;
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
