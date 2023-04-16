package holders;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

public class ItemInfoConfigurationHolder extends RecyclerView.ViewHolder{

    public TextView tvItemInfoProductKey;
    public TextView tvItemInfoProductValue;

    public ItemInfoConfigurationHolder(@NonNull View itemView) {
        super(itemView);
        this.tvItemInfoProductKey = (TextView) itemView.findViewById(R.id.tvItemInfoProductKey);
        this.tvItemInfoProductValue = (TextView) itemView.findViewById(R.id.tvInfoProductValue);
    }
}
