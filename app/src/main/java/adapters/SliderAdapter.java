package adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.recycleview_gridlayout.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import models.Slider;

public class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.SliderViewHolder>{
    private List<Slider> sliders;
    private ViewPager2 viewPager2;

    public SliderAdapter(List<Slider> sliders, ViewPager2 viewPager2) {
        this.sliders = sliders;
        this.viewPager2 = viewPager2;
    }

    @NonNull
    @Override
    public SliderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SliderViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.slide_item_container,parent,false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull SliderViewHolder holder, int position) {
        holder.setImage(sliders.get(position));
        if(position == sliders.size()-2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        return sliders.size();
    }

    public class SliderViewHolder extends RecyclerView.ViewHolder{
        private RoundedImageView imageView;

        public SliderViewHolder(@NonNull View itemView) {
            super(itemView);
            this.imageView = itemView.findViewById(R.id.imageSlide);
        }

        void setImage(Slider slide){
            imageView.setImageResource(slide.getResourseId());

        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
          sliders.addAll(sliders);
          notifyDataSetChanged();
        }
    };


}
