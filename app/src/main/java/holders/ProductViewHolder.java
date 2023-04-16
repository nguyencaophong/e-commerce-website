package holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

public class ProductViewHolder extends RecyclerView.ViewHolder {
    public TextView tvNameProduct;
    public TextView tvPriceProduct;
    public ImageView resourceId;
    public CardView itemProduct;
    public ProductViewHolder(@NonNull View itemView) {
        super(itemView);
        this.itemProduct = (CardView) itemView.findViewById(R.id.layout_item_product);
        this.tvNameProduct =(TextView) itemView.findViewById(R.id.tv_name_product);
        this.tvPriceProduct =(TextView) itemView.findViewById(R.id.tv_price_product);
        this.resourceId =(ImageView) itemView.findViewById(R.id.img_product);
    }
}
