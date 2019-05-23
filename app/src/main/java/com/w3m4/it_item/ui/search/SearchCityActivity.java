package com.w3m4.it_item.ui.search;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.model.list.ListRepo;
import com.w3m4.it_item.databinding.ActivitySearchCityBinding;
import com.w3m4.it_item.ui.search.city2.CityCategoryAdapter;
import com.w3m4.it_item.ui.search.city2.CityListAdapter;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class SearchCityActivity extends AppCompatActivity {

    private ActivitySearchCityBinding binding;
    private CityAdapter CityAdapter;
    private CityListAdapter cityListAdapter;
    private CityCategoryAdapter cityCategoryAdapter;
    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_city);
        binding.menuTop.edtSearch.setHint(R.string.search_city_edt_hint);

        initCityRcv(binding.rcvCity);
        initCityAdapterObserve();
        fetchCityData();
        initCity2ClickListener();
        initCity2ListRcv(binding.city2.rcvList);
        initCity2CategoryRcv(binding.city2.rcvCategory);
        initBackButton();
    }

    private void initCity2CategoryRcv(RecyclerView rcv) {
        cityCategoryAdapter = new CityCategoryAdapter(new ArrayList<>());

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(cityCategoryAdapter);
    }

    private void initCity2ListRcv(RecyclerView rcv) {
        cityListAdapter = new CityListAdapter(new ArrayList<>());

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
        rcv.setAdapter(cityListAdapter);
    }

    private void initBackButton() {
        binding.menuTop.ivBack.setOnClickListener(v -> {
            if (binding.city2.clMain.getVisibility() == View.VISIBLE) {
                closeCity2();
            } else {
                finish();
            }
        });
    }

    private void initCity2ClickListener() {
        binding.city2.vLeft.setOnClickListener(v -> {
            binding.city2.vLeft.setVisibility(View.INVISIBLE);
            binding.city2.vRight.setVisibility(View.VISIBLE);
            binding.city2.rcvList.setVisibility(View.VISIBLE);
            binding.city2.rcvCategory.setVisibility(View.INVISIBLE);
        });
        binding.city2.vRight.setOnClickListener(v -> {
            binding.city2.vLeft.setVisibility(View.VISIBLE);
            binding.city2.vRight.setVisibility(View.INVISIBLE);
            binding.city2.rcvCategory.setVisibility(View.VISIBLE);
            binding.city2.rcvList.setVisibility(View.INVISIBLE);
        });
    }

    private void initCityAdapterObserve() {
        CityAdapter.cityLiveData.observe(this, data -> {
            openCity2(data);
        });
    }

    private void openCity2(City city) {
        binding.rcvCity.setVisibility(View.INVISIBLE);
        binding.city2.clMain.setVisibility(View.VISIBLE);
        fetchCity2ListData(city);
    }

    private void fetchCity2ListData(City city) {
        // TODO : feachDATA
        disposable.add(ListRepo.getInstance().getCityList(city.getName())
                .subscribe(data -> {
                            cityListAdapter.setItems(data.getLists());
                        }, e -> {
                            e.printStackTrace();
                        }
                ));
    }

    private void closeCity2() {
        binding.rcvCity.setVisibility(View.VISIBLE);
        binding.city2.clMain.setVisibility(View.INVISIBLE);
    }

    private void fetchCityData() {
        CityAdapter.addItem(new City(R.drawable.ic_city_tokyo, "Tokyo"));
        CityAdapter.addItem(new City(R.drawable.ic_city_hokkaido, "훗카이도"));
        CityAdapter.addItem(new City(R.drawable.ic_city_kyoto, "쿄토"));
        CityAdapter.addItem(new City(R.drawable.ic_city_kyusu, "큐슈"));
        CityAdapter.addItem(new City(R.drawable.ic_city_osaka, "Osaka"));
        CityAdapter.addItem(new City(R.drawable.ic_city_sapporo, "삿포로"));
    }

    private void initCityRcv(RecyclerView rcv) {
        CityAdapter = new CityAdapter(new ArrayList<>());

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new GridLayoutManager(this, 2));
        rcv.setAdapter(CityAdapter);
    }

    @Override
    public void onBackPressed() {
        if (binding.city2.clMain.getVisibility() == View.VISIBLE) {
            closeCity2();
        } else {
            finish();
        }
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}