package holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

public class ItemPathProductViewHolder extends RecyclerView.ViewHolder {
    public TextView item;
    public ItemPathProductViewHolder(@NonNull View itemView) {
        super(itemView);
        this.item = itemView.findViewById(R.id.tv_item_path);
    }
}
