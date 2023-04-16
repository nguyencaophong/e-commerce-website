package ui.home;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.recycleview_gridlayout.R;
import java.util.ArrayList;
import java.util.List;
import adapters.CategoryAdapter;
import models.Category;
import models.Product;
import datas.data;


public class HomeFragment extends Fragment {
    private RecyclerView rcvCategory;
    private CategoryAdapter categoryAdapter;
    private Context mContext;

    public HomeFragment(Context context){
        this.mContext = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        setControl(view);
        setEven();
        return view;
    }

    private void setEven(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false);
        rcvCategory.setLayoutManager(linearLayoutManager);
        categoryAdapter.setData(mContext,getListCategory());
        rcvCategory.setAdapter(categoryAdapter);
    }

    private List<Category> getListCategory(){
        data data = new data();

        List<Category> list = new ArrayList<>();
        List<Product> products = new ArrayList<>();
        List<String> infoConfiguration = data.getValueInfoConfiguration();
        List<String> descriptions = new ArrayList<>();
        descriptions.add("Phù hợp cho lập trình viên, thiết kế đồ họa 2D");
        descriptions.add("Hiệu năg vượt trội - Cân mọi tác vụ từ word, excel đến chỉnh sửa ảnh trên các phầm mềm nhưu AI, PTS");
        descriptions.add("Đa nhiệm mượt mà - Ram 8GB cho phép vừa mở trình duyệt để tra cứu thông tin, vừa làm việc trên phần mềm.");


        products.add(new Product(R.drawable.laptop_1,"Apple MacBook Air M1 256GB 2020 I Chính hãng Apple Việt Nam","19.000.000.d",descriptions,infoConfiguration));
        products.add(new Product(R.drawable.laptop_2,"Acer Nitro 5 Tiger (2022) Chính Hãng ","17.000.000.d",descriptions,infoConfiguration));
        products.add(new Product(R.drawable.laptop_3,"Dell Xps 15 9570 Gen 8th","18.900.000.d",descriptions,infoConfiguration));
        products.add(new Product(R.drawable.laptop_4,"Asus ExpertBook B9450FA-BM0616R ","19.999.000.d",descriptions,infoConfiguration));

        list.add(new Category("Laptop nổi bật",products));
        list.add(new Category("Điện thoại nổi bật",products));
        list.add(new Category("Phụ kiện",products));
        return list;
    }

    private void setControl(View view){
        rcvCategory = view.findViewById(R.id.rcv_category);
        categoryAdapter = new CategoryAdapter(mContext);
    }
}