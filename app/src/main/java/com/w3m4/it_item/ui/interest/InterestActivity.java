package com.w3m4.it_item.ui.interest;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.databinding.ActivityInterestBinding;
import com.w3m4.it_item.ui.main.MainActivity;

import java.util.ArrayList;

public class InterestActivity extends AppCompatActivity {
    private CityAdapter cityAdatper;
    private CategoryAdapter categoryAdapter;
    private ActivityInterestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_interest);

        initUser();
        initCityRcv(binding.rcvCity);
        initCategoryRcv(binding.rcvCategory);
        fetchCityData();
        fetchCategoryData();
        binding.btnInterestDone.setOnClickListener(v -> {
            // TODO: 서버로 어레이리스트 전달
            startActivity(new Intent(getApplicationContext(), MainActivity.class));
            finish();
        });
    }

    private void initCityRcv(RecyclerView rcv) {
        cityAdatper = new CityAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setAdapter(cityAdatper);
    }

    private void initCategoryRcv(RecyclerView rcv){
        categoryAdapter = new CategoryAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setAdapter(categoryAdapter);
    }

    private void initUser() {
        Glide.with(getApplicationContext())
                .load(Me.getInstance().getThumbnail())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(binding.ivThumbnail);

        binding.tvWannaKnow.setText(Me.getInstance().getNickname() + binding.tvWannaKnow.getText());
    }

    private void fetchCityData() {
        cityAdatper.addItem(new City(R.drawable.tokyo_thumb, "도쿄"));
        cityAdatper.addItem(new City(R.drawable.osaka_thumb, "오사카"));
        cityAdatper.addItem(new City(R.drawable.sapporo_thumb, "삿포로"));
        cityAdatper.addItem(new City(R.drawable.hokkaido_thumb, "훗카이도"));
        cityAdatper.addItem(new City(R.drawable.kyusu_thumb, "큐슈"));
        cityAdatper.addItem(new City(R.drawable.kyoto_thumb, "쿄토"));
    }

    private void fetchCategoryData() {
        categoryAdapter.addItem(new Category("category00", "식품", R.drawable.ic_food));
        categoryAdapter.addItem(new Category("category01", "과자", R.drawable.ic_snack));
        categoryAdapter.addItem(new Category("category02", "약품", R.drawable.ic_pharmacy));
        categoryAdapter.addItem(new Category("category03", "건강보조제", R.drawable.ic_supplements));
        categoryAdapter.addItem(new Category("category04", "뷰티", R.drawable.ic_cosmetics));
        categoryAdapter.addItem(new Category("category05", "문구류", R.drawable.ic_stationary));
    }
}
