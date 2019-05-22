package com.w3m4.it_item.ui.city;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.GridLayoutManager;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.Photo;
import com.w3m4.it_item.databinding.ActivitySearchBinding;

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
        edtSearch.setHint("여행할 도시를 선택해주세요.");

        initData();
    }

    private void initData() {
        photoArrayList.add(new Photo(R.drawable.tokyo_main, "도쿄"));
        photoArrayList.add(new Photo(R.drawable.osaka_main, "오사카"));
        photoArrayList.add(new Photo(R.drawable.sapporo_main, "삿포로"));
        photoArrayList.add(new Photo(R.drawable.hokkaido_main, "홋카이도"));
        photoArrayList.add(new Photo(R.drawable.kyusu_main, "큐슈"));
        photoArrayList.add(new Photo(R.drawable.kyoto_main, "교토"));

        SearchAdapter adapter = new SearchAdapter(photoArrayList);
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        binding.rcv.setAdapter(adapter);
        binding.rcv.setLayoutManager(manager);
    }
}
