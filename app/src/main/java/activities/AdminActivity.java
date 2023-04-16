package activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;
import com.example.recycleview_gridlayout.R;

import adapters.ItemAdapter;
import models.StoreItemManagement;

public class AdminActivity extends AppCompatActivity {
    List<StoreItemManagement> listStoreItemManagement;
    RecyclerView rvTest;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        setData();
        setControl();
    }



    private void setData() {
        ArrayList arrayList = new ArrayList();
        this.listStoreItemManagement = arrayList;
        arrayList.add(new StoreItemManagement(R.drawable.ic_chart, "Thống kê", "#1200DB"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_tag, "Hãng", "#EC6F29"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_l_box, "Sản phẩm", "#5186EC"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_document, "Đơn đặt hàng", "#EBA552"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_l_gift, "Voucher", "#00B000"));
        this.listStoreItemManagement.add(new StoreItemManagement(R.drawable.ic_l_user, "User", "#FBCA91"));
    }

    private void setControl() {
        this.rvTest = (RecyclerView) findViewById(R.id.rvTest);
        new GridLayoutManager(this, 2);
        this.rvTest.setLayoutManager(new GridLayoutManager(this, 2));
        ItemAdapter adapter = new ItemAdapter(this.listStoreItemManagement);
        this.rvTest.setAdapter(adapter);
    }


    private void setEvent() {
    }
}