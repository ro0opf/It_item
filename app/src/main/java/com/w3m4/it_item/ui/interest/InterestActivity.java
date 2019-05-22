package com.w3m4.it_item.ui.interest;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.bumptech.glide.request.RequestOptions;
import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.data.Photo;
import com.w3m4.it_item.databinding.ActivityInterestBinding;

import java.util.ArrayList;

public class InterestActivity extends AppCompatActivity {
    private ArrayList<City> cityArrayList = new ArrayList<City>();
    private ArrayList<Category> categoryArrayList = new ArrayList<Category>();
    private ActivityInterestBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_interest);

        initUser();
        initCity();
        initCategory();

        CityAdapter cityAdapter = new CityAdapter(cityArrayList);
        binding.rcvCity.setAdapter(cityAdapter);
        CategoryAdapter categoryAdapter = new CategoryAdapter(categoryArrayList);
        binding.rcvCategory.setAdapter(categoryAdapter);

        String nickname = Me.getInstance().getNickname();
        binding.tvWannaKnow.setText(nickname + binding.tvWannaKnow.getText());

        binding.btnInterestDone.setOnClickListener(v -> {
            // TODO: 서버로 어레이리스트 전달
            startActivity(new Intent(getApplicationContext(), com.w3m4.it_item.ui.city.SearchActivity.class));
            finish();
        });
    }

    private void initUser() {
        Glide.with(getApplicationContext())
                .load(Me.getInstance().getThumbnail())
                .apply(RequestOptions.bitmapTransform(new CircleCrop()))
                .into(binding.ivThumbnail);
    }

    private void initCity() {
        // TODO: 서버에서 도시/카테고리  데이터 가져와서 쪼로록 넣도록 변경할까요?
        cityArrayList.add
                (new City("city00", "도쿄",
                        new Photo(R.drawable.tokyo_thumb, "도쿄")));
        cityArrayList.add
                (new City("city01", "오사카",
                        new Photo(R.drawable.osaka_thumb, "오사카")));
        cityArrayList.add
                (new City("city02", "삿포로",
                        new Photo(R.drawable.sapporo_thumb, "삿포로")));
        cityArrayList.add
                (new City("city03", "홋카이도",
                        new Photo(R.drawable.hokkaido_thumb, "홋카이도")));
        cityArrayList.add
                (new City("city04", "큐슈",
                        new Photo(R.drawable.kyusu_thumb, "큐슈")));
        cityArrayList.add
                (new City("city05", "교토",
                        new Photo(R.drawable.kyoto_thumb, "교토")));
    }

    private void initCategory() {
        categoryArrayList.add(
                new Category("category00", "식품",
                        new Photo(R.drawable.ic_food, "식품")));
        categoryArrayList.add(
                new Category("category01", "과자",
                        new Photo(R.drawable.ic_snack, "과자")));
        categoryArrayList.add(
                new Category("category02", "약품",
                        new Photo(R.drawable.ic_pharmacy, "약품")));
        categoryArrayList.add(
                new Category("category03", "건강보조제",
                        new Photo(R.drawable.ic_cat, "건강보조제")));
        categoryArrayList.add(
                new Category("category04", "뷰티",
                        new Photo(R.drawable.ic_cosmetics, "뷰티")));
        categoryArrayList.add(
                new Category("category05", "토이",
                        new Photo(R.drawable.ic_robot, "토이")));
    }
}
