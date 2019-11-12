package com.comshelin.comshelinguide;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class TabPagerAdapter extends FragmentStatePagerAdapter {

    private int tabCount;

    @Override
    public int getCount() {
        return tabCount;
    }

    public TabPagerAdapter(@NonNull FragmentManager fm, int tabCount) {
        super(fm);
        this.tabCount = tabCount;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                ListFragment listFragment = new ListFragment();
                return listFragment;
            case 1:
                MapFragment mapFragment = new MapFragment();
                return mapFragment;
            case 2:
                RecipeFragment recipeFragment = new RecipeFragment();
                return recipeFragment;
            case 3:
                MyFragment myFragment = new MyFragment();
                return myFragment;
            default:
                return null;
        }
    }
}
