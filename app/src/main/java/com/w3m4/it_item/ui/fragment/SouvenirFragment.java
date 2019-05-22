package com.w3m4.it_item.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.w3m4.it_item.R;
import com.w3m4.it_item.data.model.Photo;
import com.w3m4.it_item.ui.search.mItemAdapter;

import java.util.ArrayList;

public class SouvenirFragment extends Fragment {

    private ArrayList<Photo> photoArrayList = new ArrayList<>();
    private RecyclerView rcv;

    View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_souvenir, container, false);

        rcv = (RecyclerView) view.findViewById(R.id.rcv);

        initData();
        return view;
    }

    private void initData() {
        photoArrayList.add(new Photo(R.drawable.ic_food, "식품"));
        photoArrayList.add(new Photo(R.drawable.ic_cosmetics, "뷰티"));
        photoArrayList.add(new Photo(R.drawable.ic_pharmacy, "약품"));
        photoArrayList.add(new Photo(R.drawable.ic_snack, "과자"));
        photoArrayList.add(new Photo(R.drawable.ic_cat, "지역 특산품"));
        photoArrayList.add(new Photo(R.drawable.ic_robot, "장난감"));

        mItemAdapter adapter = new mItemAdapter(getActivity(), photoArrayList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);

        rcv.setAdapter(adapter);
        rcv.setLayoutManager(manager);
    }

}
