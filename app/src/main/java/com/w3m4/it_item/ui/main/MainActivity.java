package com.w3m4.it_item.ui.main;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
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
    private boolean flag = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initMotionLayout();
        initListRcv(binding.rcvList);
        fetchCityData();
    }

    private void initListRcv(RecyclerView rcv) {
        listAdapter = new ListAdapter(new ArrayList<>());
        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rcv.setAdapter(listAdapter);
    }

    private void fetchCityData() {
        binding.vLeft2.setOnClickListener(v -> {
            disposable.add(ListRepo.getInstance().getList("hyyyyjin")
                    .subscribe(data->{
                                listAdapter.setItems(data.getLists());
                                Log.e("#$Main", data.getLists().size()+ "");
                            }, e->{
                                Log.e("#$Main", e.getMessage());
                            }
                    )
            );
        });
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

}
