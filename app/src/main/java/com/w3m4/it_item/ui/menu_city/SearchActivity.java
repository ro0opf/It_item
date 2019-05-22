package com.w3m4.it_item.ui.menu_city;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.w3m4.it_item.R;
import com.w3m4.it_item.ui.fragment.CityFragment;

// 도시 검색 메인 메뉴
public class SearchActivity extends AppCompatActivity {
    FragmentManager fm;
    FragmentTransaction tran;
    // 교체할 화면 fragment
    Fragment cityFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_souvenir);

        // Fragment 클래스 객체 생성 (임시)
        cityFragment = new CityFragment();

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.commit();
        fragmentTransaction.add(R.id.main_city_frame, cityFragment);

    }

    private void setFrag(int id)
    {
        fm=getSupportFragmentManager();
        tran=fm.beginTransaction();


    }


}
