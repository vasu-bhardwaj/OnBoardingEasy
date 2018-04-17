package com.fivemin.chief.easyonboarding.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.fivemin.chief.easyonboarding.pages.IntroFragment;

import java.util.ArrayList;
import java.util.List;
public class IntroAdapter extends FragmentStatePagerAdapter {

   private List<IntroFragment> pages = new ArrayList<>();

    public IntroAdapter(List<IntroFragment> pages, FragmentManager fm) {
        super(fm);
        this.pages = pages;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        super.destroyItem(container, position, object);

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Object fragment = super.instantiateItem(container, position);
        pages.set(position, (IntroFragment) fragment);
        return fragment;
    }

    @Override
    public Fragment getItem(int position) {
        return pages.get(position);
    }

    @Override
    public int getCount() {
        return pages.size();
    }
}
