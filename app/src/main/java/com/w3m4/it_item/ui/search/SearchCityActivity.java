package com.w3m4.it_item.ui.search;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.databinding.ActivitySearchCityBinding;

import java.util.ArrayList;

public class SearchCityActivity extends AppCompatActivity {

    private ActivitySearchCityBinding binding;
    private ArrayList<City> cityArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_city);
        binding.menuTop.edtSearch.setHint("여행할 도시를 검색하세요.");
        initData();
    }

    private void initData() {
        cityArrayList.add(new City(R.drawable.ic_city_tokyo, "도쿄"));
        cityArrayList.add(new City(R.drawable.ic_city_hokkaido, "훗카이도"));
        cityArrayList.add(new City(R.drawable.ic_city_kyoto, "쿄토"));
        cityArrayList.add(new City(R.drawable.ic_city_kyusu, "큐슈"));
        cityArrayList.add(new City(R.drawable.ic_city_osaka, "오사카"));
        cityArrayList.add(new City(R.drawable.ic_city_sapporo, "삿포로"));

        mCityAdapter adapter = new mCityAdapter(cityArrayList);
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        binding.rcv.setAdapter(adapter);
        binding.rcv.setLayoutManager(manager);
    }
}