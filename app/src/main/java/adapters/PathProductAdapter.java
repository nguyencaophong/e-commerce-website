package adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

import java.util.List;

import holders.ItemPathProductViewHolder;
import models.ItemPathProduct;

public class PathProductAdapter extends RecyclerView.Adapter<ItemPathProductViewHolder> {
    private List<ItemPathProduct> mPaths;
    private Context mContext;

    public PathProductAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setData(List<ItemPathProduct> paths){
        this.mPaths = paths;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ItemPathProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_path_product,parent,false);
        return new ItemPathProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemPathProductViewHolder holder, int position) {
        ItemPathProduct itemPathProduct = mPaths.get(position);
        if(itemPathProduct == null){
            return ;
        }

        holder.item.setText(itemPathProduct.getPath());
    }

    @Override
    public int getItemCount() {
        if(mPaths !=null){
            return mPaths.size();
        }
        return 0;
    }
}
