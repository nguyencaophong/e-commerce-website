package ui.user;

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

import adapters.UserAdapter;
import models.User;

public class ListUserFragment extends Fragment {
    private RecyclerView rcvUser;
    private UserAdapter userAdapter;
    private Context mContext;

    public ListUserFragment(Context mContext){
        this.mContext = mContext;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.item_user,container,false);
        setControl(view);
        setEven();
        return view;
    }

    private void setEven(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext,RecyclerView.VERTICAL,false);
        rcvUser.setLayoutManager(linearLayoutManager);
        userAdapter.setData(mContext,getUsers());
        rcvUser.setAdapter(userAdapter);
    }

    private List<User> getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(R.drawable.person1,"Vo Tiến Đạt","0374448888","97 Man Thiện","01-01-2001","votiendat","hello"));
        users.add(new User(R.drawable.person2,"Vo Tiến Đạt","0374448888","97 Man Thiện","01-01-2001","votiendat","hello"));
        users.add(new User(R.drawable.person3,"Vo Tiến Đạt","0374448888","97 Man Thiện","01-01-2001","votiendat","hello"));
        users.add(new User(R.drawable.person4,"Vo Tiến Đạt","0374448888","97 Man Thiện","01-01-2001","votiendat","hello"));
        users.add(new User(R.drawable.person3,"Vo Tiến Đạt","0374448888","97 Man Thiện","01-01-2001","votiendat","hello"));
        return users;
    }

  private void setControl(View view){
        rcvUser = view.findViewById(R.id.rcv_users);
        userAdapter = new UserAdapter(mContext);
    }
}