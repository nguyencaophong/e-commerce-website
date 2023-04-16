package activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import com.example.recycleview_gridlayout.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import java.util.ArrayList;
import java.util.List;

import adapters.SliderAdapter;
import models.Slider;
import ui.categories.FragmentCategories;
import ui.home.HomeFragment;
import datas.data;


public class MainActivity extends AppCompatActivity{
    BottomNavigationView bottomNavigationView;
    HomeFragment homeFragment = new HomeFragment(this);
    FragmentCategories fragmentCategories  = new FragmentCategories();
    AutoCompleteTextView tvSearch;
    ViewPager2 viewPager2;
    private Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEven();
        Banner();
    }

    private void setEven(){
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_dropdown_item_1line, new data().suggestProduct());
        tvSearch.setHint("Bạn cần tìm gì ?");
        tvSearch.setAdapter(adapter);

        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_change, new HomeFragment(this)).commit();
        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_home:
                        if(homeFragment == null){
                            homeFragment = new HomeFragment(getApplicationContext());
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_change, homeFragment).commit();
                        break;
                    case R.id.menu_category:
                        if(fragmentCategories == null){
                            fragmentCategories = new FragmentCategories();
                        }
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame_layout_change, fragmentCategories).commit();
                        break;
                }
            }
        });
    }

    private void Banner(){
        viewPager2 = findViewById(R.id.viewPager);
        List<Slider> sliders = new ArrayList<>();
        sliders.add(new Slider(R.drawable.slider_2));
        sliders.add(new Slider(R.drawable.slide_3));
        sliders.add(new Slider(R.drawable.slide_5));
        viewPager2.setAdapter(new SliderAdapter(sliders,viewPager2));

        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(5);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(30));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1- Math.abs(position);
                float scale = 0.85f+r*0.15f;
            }
        });
        viewPager2.setPageTransformer(compositePageTransformer);
        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);

                handler.removeCallbacks(sliderRunnable);
                handler.postDelayed(sliderRunnable,2000);
            }
        });
    }

    private  Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() +1);
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        handler.postDelayed(sliderRunnable,3000);
    }


    private void setControl() {
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        tvSearch  = findViewById(R.id.auto_search);
    }
}
