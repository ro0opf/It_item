package com.w3m4.it_item.ui.main;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.Me;
import com.w3m4.it_item.data.model.list.ListRepo;
import com.w3m4.it_item.databinding.ActivityMainBinding;
import com.w3m4.it_item.ui.search.SearchCityActivity;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ListAdapter listAdapter;
    private CityAdapter cityAdapter;
    private CategoryAdapter categoryAdapter;
    private boolean flag = false;
    private final int REQUEST_ACT = 1;
    private final int REQUEST_OK = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initMotionLayout();
        initListRcv(binding.rcvList);
        initCityRcv(binding.rcvCity);
        initCategoryRcv(binding.rcvCategory);
        initClickListener();
        initMainData();
        fetchListData();
        fetchCityData();
        fetchCategoryData();
    }

    private void initMainData() {
        binding.tvWelcome.setText(Me.getInstance().getNickname() + binding.tvWelcome.getText());
    }

    private void fetchCategoryData() {
        categoryAdapter.addItem(new Category(R.drawable.ic_snack, "DUMMY"));
        categoryAdapter.addItem(new Category(R.drawable.ic_snack, "SNACK"));
        categoryAdapter.addItem(new Category(R.drawable.ic_food, "FOOD"));
        categoryAdapter.addItem(new Category(R.drawable.ic_cosmetics, "COSMETIC"));
        categoryAdapter.addItem(new Category(R.drawable.ic_pharmacy, "PHARMACY"));
        categoryAdapter.addItem(new Category(R.drawable.ic_supplements, "SUPPLEMENT"));
        categoryAdapter.addItem(new Category(R.drawable.ic_stationary, "STATIONARY"));
    }

    private void initCategoryRcv(RecyclerView rcv) {
        categoryAdapter = new CategoryAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rcv.setAdapter(categoryAdapter);
    }

    private void fetchCityData() {
        cityAdapter.addItem(new City(R.drawable.ic_city_tokyo, "Dummy"));
        cityAdapter.addItem(new City(R.drawable.ic_city_osaka, "Osaka"));
        cityAdapter.addItem(new City(R.drawable.ic_city_tokyo, "Tokyo"));
        cityAdapter.addItem(new City(R.drawable.ic_city_hokkaido, "Hokkaido"));
        cityAdapter.addItem(new City(R.drawable.ic_city_kyusu, "Kyusu"));
        cityAdapter.addItem(new City(R.drawable.ic_city_okinawa, "Okinawa"));
        cityAdapter.addItem(new City(R.drawable.ic_city_kyoto, "Kyoto"));
    }

    private void initCityRcv(RecyclerView rcv) {
        cityAdapter = new CityAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) {
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        });
        rcv.setAdapter(cityAdapter);
    }

    private void initClickListener() {
        binding.vCity.setOnClickListener(v -> {
            binding.rcvCity.setVisibility(View.VISIBLE);
            binding.rcvCategory.setVisibility(View.INVISIBLE);
            binding.vItem2.setVisibility(View.INVISIBLE);
            binding.vCity.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhite)));
        });

        binding.vItem.setOnClickListener(v -> {
            binding.rcvCity.setVisibility(View.INVISIBLE);
            binding.rcvCategory.setVisibility(View.VISIBLE);
            binding.vItem2.setVisibility(View.VISIBLE);
            binding.vCity.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorFaintMain)));
        });

        binding.ivMenu.setOnClickListener(v -> {
            binding.vAct.setVisibility(View.VISIBLE);
            startActivityForResult(new Intent(getApplicationContext(), ConfigActivity.class), REQUEST_ACT);
            overridePendingTransition(R.anim.slide_in_left, 0);
        });

        binding.ivHeaderMenu.setOnClickListener(v -> {
            binding.vAct.setVisibility(View.VISIBLE);
            startActivityForResult(new Intent(getApplicationContext(), ConfigActivity.class), REQUEST_ACT);
            overridePendingTransition(R.anim.slide_in_left, 0);
        });

        binding.ivHeaderSearch.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(), SearchCityActivity.class);
            i.putExtra("city", "error");
            startActivity(i);
        });
    }

    private void initListRcv(RecyclerView rcv) {
        listAdapter = new ListAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcv.setAdapter(listAdapter);
    }

    private void fetchListData() {
        disposable.add(ListRepo.getInstance().getList(Me.getInstance().getId())
                .subscribe(data -> {
                            listAdapter.setItems(data.getLists());
                        }, e -> {
                            e.printStackTrace();
                        }
                )
        );
    }

    void initMotionLayout() {
        binding.nsvMain.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (scrollY > 1000 && !flag) {
                binding.mlMain.transitionToEnd();
                flag = true;
            }
            if (scrollY < 1000 && flag) {
                binding.mlMain.transitionToStart();
                flag = false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_ACT) {
            if (resultCode == REQUEST_OK) {
                binding.vAct.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
