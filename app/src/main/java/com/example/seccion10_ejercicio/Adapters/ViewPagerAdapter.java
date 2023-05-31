package com.example.seccion10_ejercicio.Adapters;

import static com.example.seccion10_ejercicio.Activities.MainActivity.PERSON_FORM_FRAGMENT;
import static com.example.seccion10_ejercicio.Activities.MainActivity.PERSON_LIST_FRAGMENT;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.seccion10_ejercicio.Fragments.PersonFormFragment;
import com.example.seccion10_ejercicio.Fragments.PersonListFragment;


public class ViewPagerAdapter extends FragmentStatePagerAdapter {
  private int numberOfTabs;

  public ViewPagerAdapter(@NonNull FragmentManager fragmentManager, Context context, int numberOfTabs) {
    super(fragmentManager);
    this.numberOfTabs = numberOfTabs;
  }

  @NonNull
  @Override
  public Fragment getItem(int position) {
    switch (position){
      case PERSON_FORM_FRAGMENT:
        return new PersonFormFragment();
      case PERSON_LIST_FRAGMENT:
        return new PersonListFragment();
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return numberOfTabs;
  }
}
