package com.w3m4.it_item.ui.search;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.databinding.ActivitySearchCityBinding;

import java.util.ArrayList;

public class SearchCityActivity extends AppCompatActivity {

    private ActivitySearchCityBinding binding;
    private mCityAdapter mCityAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_city);
        binding.menuTop.edtSearch.setHint("여행할 도시를 검색하세요.");

        initCityRcv(binding.rcvCity);
        fetchCityData();
    }

    private void fetchCityData() {
        mCityAdapter.addItem(new City(R.drawable.ic_city_tokyo, "도쿄"));
        mCityAdapter.addItem(new City(R.drawable.ic_city_hokkaido, "훗카이도"));
        mCityAdapter.addItem(new City(R.drawable.ic_city_kyoto, "쿄토"));
        mCityAdapter.addItem(new City(R.drawable.ic_city_kyusu, "큐슈"));
        mCityAdapter.addItem(new City(R.drawable.ic_city_osaka, "오사카"));
        mCityAdapter.addItem(new City(R.drawable.ic_city_sapporo, "삿포로"));
    }

    private void initCityRcv(RecyclerView rcv) {
        mCityAdapter = new mCityAdapter(new ArrayList<>());

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new GridLayoutManager(this,2));
        rcv.setAdapter(mCityAdapter);
    }
}