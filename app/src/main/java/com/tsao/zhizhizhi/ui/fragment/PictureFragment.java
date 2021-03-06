package com.tsao.zhizhizhi.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.zhizhizhi.yvan.zhizhizhi.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class PictureFragment extends Fragment {


    public PictureFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_picture, container, false);
        initTabLayoutAndViewPager(view);
        return view;
    }

    /**
     * 初始化TabLayout和ViewPager
     */
    private void initTabLayoutAndViewPager(View view){

        TabLayout tabLayout = (TabLayout)view.findViewById(R.id.pic_tablayout);
        ViewPager viewPager = (ViewPager)view.findViewById(R.id.pic_viewpager);

        //给tab设置自己想要的标签
        final List<String> tabTitleList = new ArrayList<>();
        tabTitleList.add("Gank.io");
        for(int i = 0;i < tabTitleList.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabTitleList.get(i)));
        }

        //设置要显示在ViewPager上的Fragment集合
        final List<Fragment> fragmentList = new ArrayList<>();
        Fragment gankFragment = new GankFragment();
        fragmentList.add(gankFragment);


        //生成ViewPager的适配器
        PagerAdapter adapter = new FragmentPagerAdapter(getChildFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragmentList.get(position);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return tabTitleList.get(position);
            }
        };

        //设置适配器，并将TabLayout与ViewPager相关联
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);

    }

}
