package com.w3m4.it_item.ui.main;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.motion.widget.MotionScene;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Transition;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.City;
import com.w3m4.it_item.data.mLists;
import com.w3m4.it_item.data.model.list.ListRepo;
import com.w3m4.it_item.databinding.ActivityMainBinding;

import java.util.ArrayList;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private CompositeDisposable disposable = new CompositeDisposable();
    private ListAdapter listAdapter;
    private CityAdapter cityAdapter;
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initMotionLayout();
        initListRcv(binding.rcvList);
        initCityRcv(binding.rcvCity);
        initClickListener();
        fetchListData();
        fetchCityData();
    }

    private void fetchCityData() {
        ArrayList<City> cityArrayList = new ArrayList<>();
        cityArrayList.add(new City(R.drawable.tokyo_main, "Dummy"));
        cityArrayList.add(new City(R.drawable.tokyo_main, "OSAKA"));
        cityArrayList.add(new City(R.drawable.tokyo_main, "TOKYO"));
        cityArrayList.add(new City(R.drawable.tokyo_main, "HOKKAIDO"));
        cityArrayList.add(new City(R.drawable.tokyo_main, "KYUSHU"));
        cityArrayList.add(new City(R.drawable.tokyo_main, "OKINAWA"));
        cityArrayList.add(new City(R.drawable.tokyo_main, "KYOTO"));
        cityAdapter.setItems(cityArrayList);
    }

    private void initCityRcv(RecyclerView rcv) {
        cityAdapter = new CityAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rcv.setAdapter(cityAdapter);
    }

    private void initClickListener() {
        binding.vCity.setOnClickListener(v -> {
            binding.vItem2.setVisibility(View.INVISIBLE);
            binding.vCity.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorWhite)));
        });
        binding.vItem.setOnClickListener(v -> {
            binding.vItem2.setVisibility(View.VISIBLE);
            binding.vCity.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(R.color.colorFaintMain)));
        });
    }

    private void initListRcv(RecyclerView rcv) {
        listAdapter = new ListAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcv.setAdapter(listAdapter);
    }

    private void fetchListData() {
        disposable.add(ListRepo.getInstance().getList("hyyyyjin")
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
    protected void onDestroy() {
        disposable.dispose();
        super.onDestroy();
    }
}
