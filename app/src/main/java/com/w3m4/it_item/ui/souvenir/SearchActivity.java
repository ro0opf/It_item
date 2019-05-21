package com.w3m4.it_item.ui.souvenir;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Photo;
import com.w3m4.it_item.databinding.ActivitySearchBinding;
import com.w3m4.it_item.ui.search.SearchAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity {

    private ActivitySearchBinding binding;
    private ArrayList<Photo> photoArrayList = new ArrayList<>();

    private EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search);

        edtSearch=(EditText)findViewById(R.id.edt_search);
        edtSearch.setHint("구매할 기념품을 선택해주세요.");

        initData();
    }

    private void initData() {
        photoArrayList.add(new Photo(R.drawable.ic_food, "식품"));
        photoArrayList.add(new Photo(R.drawable.ic_cosmetics, "뷰티"));
        photoArrayList.add(new Photo(R.drawable.ic_pharmacy, "약품"));
        photoArrayList.add(new Photo(R.drawable.ic_snack, "과자"));
        photoArrayList.add(new Photo(R.drawable.ic_cat, "지역 특산품"));
        photoArrayList.add(new Photo(R.drawable.ic_robot, "장난감"));

        SearchAdapter adapter = new SearchAdapter(photoArrayList);
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        binding.rcv.setAdapter(adapter);
        binding.rcv.setLayoutManager(manager);
    }


}
