package activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.recycleview_gridlayout.R;
import java.util.ArrayList;
import java.util.List;
import adapters.PathProductAdapter;
import datas.data;
import holders.ItemInfoConfigurationHolder;
import models.ItemConfiguration;
import models.ItemPathProduct;
import models.Product;


public class ProductDetail extends AppCompatActivity {
    private RecyclerView rcvPathProduct;
    private LinearLayout llShowInfoConfiguration;
    private TextView tvNameProduct,tvPriceProduct;
    private ImageView imgProduct;
    protected LinearLayout llShowInfoProduct;
    static Integer numbersIndexInfoConfiguration = 13;
    AutoCompleteTextView tvSearch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_detail);
        setControl();
        setEven();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_topbar,menu);
        return false;
    }

    private void setEven(){
        ImageButton imageButton = findViewById(R.id.ibtn_back);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ProductDetail.this,MainActivity.class);
                startActivity(intent);
            }
        });

        if(getIntent() !=null && getIntent().getExtras()!= null && getIntent().hasExtra(MainActivity.ACTIVITY_SERVICE));
        Product product = (Product) getIntent().getSerializableExtra("product");

        execSearch();
        getInfoProduct(product);
        getInfoConfiguration(product);
        execCategoryProduct();
    }

    private View onCreateViewHolder(@NonNull ViewGroup parent,String keyInfoConfiguration, String valueInfoConfiguration){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_info_configuration, parent, false);
        ItemInfoConfigurationHolder viewHolder = new ItemInfoConfigurationHolder(view);

        viewHolder.tvItemInfoProductKey.setText(keyInfoConfiguration);
        viewHolder.tvItemInfoProductValue.setText(valueInfoConfiguration);
        return viewHolder.itemView;
    }

    private void getInfoProduct(Product product){
        List<String> descriptionProduct = product.getDescription();
        Integer size = descriptionProduct.size();

        for(int i=0; i < size; ++i){
            TextView textView = new TextView(this);
            textView.setText(descriptionProduct.get(i));
            llShowInfoProduct.addView(textView);
        }

        tvNameProduct.setText(product.getName());
        tvPriceProduct.setText(product.getPrice());
        imgProduct.setImageResource(product.getResourceId());
    }

    private void getInfoConfiguration(Product product){
        List<String> infoConfiguration = product.getInfoConfiguration();
        data data = new data();
        List<String> keysConfiguration = data.getKeyInfoConfiguration();
        for(int i =0; i < numbersIndexInfoConfiguration; ++i){
            View view = onCreateViewHolder(llShowInfoConfiguration,keysConfiguration.get(i),infoConfiguration.get(i));
            if(i%2==0){
                view.setBackgroundColor(0xFF4E85D7);
                view.invalidate();
            }
            else{
                view.setBackgroundColor(0xFFFFFFFF);
                view.invalidate();
            }
            view.setPadding(32,16,0,16);
            llShowInfoConfiguration.addView(view);
        }
    }

    private void execSearch(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, new data().suggestProduct());
        tvSearch.setHint("Bạn cần tìm gì ?");
        tvSearch.setAdapter(adapter);
    }

    private void execCategoryProduct(){
        PathProductAdapter productAdapter = new PathProductAdapter(this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        rcvPathProduct.setLayoutManager(linearLayoutManager);
        productAdapter.setData(getPaths());
        rcvPathProduct.setAdapter(productAdapter);
    }

    private void setControl(){
        llShowInfoConfiguration = findViewById(R.id.llShowInfoConfiguration);
        llShowInfoProduct = findViewById(R.id.llItemInfoProduct);
        rcvPathProduct = findViewById(R.id.rcv_path_product);
        tvNameProduct = findViewById(R.id.tv_name_product);
        tvPriceProduct = findViewById(R.id.tv_price_product);
        imgProduct = findViewById(R.id.img_product_detail);
        tvSearch = findViewById(R.id.auto_search);
    }

    private List<ItemPathProduct> getPaths(){
        List<ItemPathProduct> itemPathProducts = new ArrayList<>();
        itemPathProducts.add(new ItemPathProduct("Laptop"));
        itemPathProducts.add(new ItemPathProduct("Apple"));
        itemPathProducts.add(new ItemPathProduct("Macbook"));
        return itemPathProducts;
    }
}
