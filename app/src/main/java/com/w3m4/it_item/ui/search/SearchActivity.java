package com.w3m4.it_item.ui.search;

import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.model.Photo;
import com.w3m4.it_item.helper.SearchAdapter;

import java.util.ArrayList;

public class SearchActivity extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView recyclerView;
    private ArrayList<Photo> photoArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        Button linear = (Button) findViewById(R.id.linearLayout);
//        Button grid = (Button) findViewById(R.id.gridLayout);
//        Button staggered = (Button) findViewById(R.id.staggeredGridLayout);

        initData();

//        linear.setOnClickListener(this);
//        grid.setOnClickListener(this);
//        staggered.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
//        if (view.getId() == R.id.linearLayout) {
//            SearchAdapter adapter = new SearchAdapter(photoArrayList, R.layout.recycler_item, this);
//            LinearLayoutManager manager = new LinearLayoutManager(this);
//
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(manager);
//        } else if (view.getId() == R.id.gridLayout) {
//            SearchAdapter adapter = new SearchAdapter(photoArrayList, R.layout.recycler_item, this);
//            GridLayoutManager manager = new GridLayoutManager(this, 3);
//
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(manager);
//        } else if (view.getId() == R.id.staggeredGridLayout) {
//            SearchAdapter adapter = new SearchAdapter(photoArrayList, R.layout.recycler_item, this);
//            StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//
//            recyclerView.setAdapter(adapter);
//            recyclerView.setLayoutManager(manager);
//        }
    }

    private void initData() {
        photoArrayList.add(new Photo(R.drawable.tokyo_main, "도쿄"));
        photoArrayList.add(new Photo(R.drawable.osaka_main, "오사카"));
        photoArrayList.add(new Photo(R.drawable.sapporo_main, "삿포로"));
        photoArrayList.add(new Photo(R.drawable.hokkaido_main, "홋카이도"));
        photoArrayList.add(new Photo(R.drawable.kyusu_main, "큐슈"));
        photoArrayList.add(new Photo(R.drawable.kyoto_main, "교토"));

        SearchAdapter adapter = new SearchAdapter(photoArrayList, R.layout.recycler_item, this);
        GridLayoutManager manager = new GridLayoutManager(this, 2);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(manager);

//        SearchAdapter adapter = new SearchAdapter(photoArrayList, R.layout.recycler_item, this);
//        LinearLayoutManager manager = new LinearLayoutManager(this);
//
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(manager);
    }
}
