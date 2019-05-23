package com.w3m4.it_item.ui.search;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Category;
import com.w3m4.it_item.databinding.ActivitySearchCategoryBinding;

import java.util.ArrayList;

public class SearchCategoryActivity extends AppCompatActivity {

    private ActivitySearchCategoryBinding binding;
    private CategoryAdapter categoryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_search_category);

        binding.menuTop.edtSearch.setHint(R.string.search_category_edt_hint);
        initCategoryRcv(binding.rcvCategory);
        fetchCategoryData();
    }

    private void fetchCategoryData() {
        categoryAdapter.addItem(new Category(R.drawable.ic_food, "식품"));
        categoryAdapter.addItem(new Category(R.drawable.ic_cosmetics, "뷰티"));
        categoryAdapter.addItem(new Category(R.drawable.ic_pharmacy, "약품"));
        categoryAdapter.addItem(new Category(R.drawable.ic_snack, "과자"));
        categoryAdapter.addItem(new Category(R.drawable.ic_cat, "지역 특산품"));
        categoryAdapter.addItem(new Category(R.drawable.ic_robot, "장난감"));
    }

    private void initCategoryRcv(RecyclerView rcv) {
        categoryAdapter = new CategoryAdapter(new ArrayList<>());

        rcv.setHasFixedSize(true);
        rcv.setLayoutManager(new GridLayoutManager(this, 2));
        rcv.setAdapter(categoryAdapter);
    }

}
