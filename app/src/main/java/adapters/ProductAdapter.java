package adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recycleview_gridlayout.R;
import java.util.List;

import activities.ProductDetail;
import holders.ProductViewHolder;
import interfaces.IClickItemProductListener;
import models.Product;


public class ProductAdapter extends RecyclerView.Adapter<ProductViewHolder> {
    private List<Product> mProducts;
    private IClickItemProductListener iClickItemProductListener;
    private Context mContext;

    public ProductAdapter(Context context,List<Product> products){
        this.mContext =context;
        this.mProducts = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product,parent,false);
        return new ProductViewHolder(view);
    }

    // Function set data and show
    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = mProducts.get(position);
        if(product == null){
            return;
        }
        holder.resourceId.setImageResource(product.getResourceId());
        holder.tvNameProduct.setText(product.getName());
        holder.tvPriceProduct.setText(product.getPrice());

        holder.itemProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gotoProductDetail(product);
            }
        });
    }

    private void gotoProductDetail(Product product) {
        Intent intent = new Intent(mContext, ProductDetail.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("product",product);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        if(mProducts !=null){
            return mProducts.size();
        }
        return 0;
    }
}
