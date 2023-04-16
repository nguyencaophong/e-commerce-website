package holders;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

public class UserViewHolder extends RecyclerView.ViewHolder {
    public ImageView imgPerson;
    public TextView tvNamePerson;
    public TextView tvPhonePerson;
    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        imgPerson = itemView.findViewById(R.id.profile_image);
        tvNamePerson = itemView.findViewById(R.id.tv_name_person);
        tvPhonePerson = imgPerson.findViewById(R.id.tv_price_product);
    }
}
