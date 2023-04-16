package holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

public class CategoryViewHolder extends RecyclerView.ViewHolder{
    public TextView tvNameCategory;
    public RecyclerView rcvProduct;
    public ImageView imvTitle;

    public CategoryViewHolder(@NonNull View itemView) {
        super(itemView);

        tvNameCategory = itemView.findViewById(R.id.tv_name_category);
        rcvProduct = itemView.findViewById(R.id.rcv_products);
        imvTitle = itemView.findViewById(R.id.imv_title_home);
    }
}
