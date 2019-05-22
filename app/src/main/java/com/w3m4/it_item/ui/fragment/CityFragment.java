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
import com.w3m4.it_item.ui.helper.SouvenirAdapter;

import java.util.ArrayList;

public class CityFragment extends Fragment {

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
        photoArrayList.add(new Photo(R.drawable.ic_city_tokyo, "도쿄"));
        photoArrayList.add(new Photo(R.drawable.ic_city_osaka, "오사카"));
        photoArrayList.add(new Photo(R.drawable.ic_city_kyoto, "교토"));
        photoArrayList.add(new Photo(R.drawable.ic_city_kyusu, "큐슈"));
        photoArrayList.add(new Photo(R.drawable.ic_city_sapporo, "삿포로"));
        photoArrayList.add(new Photo(R.drawable.ic_city_hokkaido, "홋카이도"));

        SouvenirAdapter adapter = new SouvenirAdapter(getActivity(), photoArrayList);
        GridLayoutManager manager = new GridLayoutManager(getActivity(), 2);

        rcv.setAdapter(adapter);
        rcv.setLayoutManager(manager);
    }

}
