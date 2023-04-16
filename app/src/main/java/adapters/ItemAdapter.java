package adapters;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.recycleview_gridlayout.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import models.StoreItemManagement;

/* loaded from: classes4.dex */
public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.TestViewHolder> {
    List<StoreItemManagement> tests;

    public ItemAdapter(List<StoreItemManagement> tests) {
        this.tests = tests;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.category_admin_item, parent, false);
        TestViewHolder storeManagementItem = new TestViewHolder(view);
        return storeManagementItem;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(TestViewHolder holder, int position) {
        StoreItemManagement storeItemManagement = this.tests.get(position);
        String colorString = storeItemManagement.getColorString();
        int resId = this.tests.get(position).getStoreItemManagementSrcImage();
        holder.ivStoreManagementSrcImage.setImageResource(resId);
        holder.ivStoreManagementSrcImage.setColorFilter(Color.parseColor(colorString));
        String title = storeItemManagement.getStoreItemManagementName();
        holder.tvStoreManagementTitle.setText(title);
        GradientDrawable drawable = (GradientDrawable) holder.tvStoreManagementTitle.getBackground();
        drawable.setColor(Color.parseColor(colorString));
        setEvent(holder, position);
    }

    private void setEvent(TestViewHolder testViewHolder, int position) {
        OnClickListenerTestViewHolder onClickListenerTestViewHolder = new OnClickListenerTestViewHolder(testViewHolder, position);
        testViewHolder.itemView.setOnClickListener(onClickListenerTestViewHolder);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.tests.size();
    }

    /* loaded from: classes4.dex */
    public class TestViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivStoreManagementSrcImage;
        private TextView tvStoreManagementTitle;

        public TestViewHolder(View itemView) {
            super(itemView);
            this.tvStoreManagementTitle = (TextView) itemView.findViewById(R.id.tvStoreManagementItemTitle);
            this.ivStoreManagementSrcImage = (ImageView) itemView.findViewById(R.id.ivStoreManagementSrcImage);
        }
    }

    public class OnClickListenerTestViewHolder implements View.OnClickListener {
        int position;
        TestViewHolder testViewHolder;

        public OnClickListenerTestViewHolder(TestViewHolder testViewHolder, int position) {
            this.testViewHolder = testViewHolder;
            this.position = position;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View v) {
            switch (this.position) {
                case 0:
                    Log.d("message", "chuc nang nay chua duoc ho tro");
                    return;
                case 1:
                    Log.d("message", "chuc nang nay chua duoc ho tro");
                    return;
                case 2:
                    Log.d("message", "chuc nang nay chua duoc ho tro");
                    return;
                case 3:
                    Log.d("message", "chuc nang nay chua duoc ho tro");
                    return;
                case 4:
                    Log.d("message", "chuc nang nay chua duoc ho tro");
                    return;
                case 5:
                    Log.d("message", "chuc nang nay chua duoc ho tro");
                    return;
                default:
                    Log.d("message", "Khong chua chuc nang nay ");
                    return;
            }
        }
    }
}
