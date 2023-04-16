package adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycleview_gridlayout.R;

import java.util.List;

import holders.UserViewHolder;
import models.User;

public class UserAdapter extends RecyclerView.Adapter<UserViewHolder>{
    private Context mContext;
    private List<User> mListUser;

    public UserAdapter(Context mContext){
        this.mContext = mContext;
    }
    public void setData(Context mContext,List<User> listUser){
        this.mContext = mContext;
        this.mListUser = listUser;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user,parent,false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = mListUser.get(position);
        if(user ==null  ){
            return;
        }
        holder.imgPerson.setImageResource(user.getSourceId());
        holder.tvNamePerson.setText(user.getFull_name());
        holder.tvPhonePerson.setText(user.getPhone());
    }

    @Override
    public int getItemCount() {
        if(mListUser !=null){
            return mListUser.size();
        }
        return 0;
    }
}
