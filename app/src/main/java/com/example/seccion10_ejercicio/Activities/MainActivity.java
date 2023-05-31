package com.example.seccion10_ejercicio.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;


import com.example.seccion10_ejercicio.Adapters.ViewPagerAdapter;
import com.example.seccion10_ejercicio.Fragments.PersonListFragment;
import com.example.seccion10_ejercicio.Interfaces.OnPersonCreated;
import com.example.seccion10_ejercicio.Models.Person;
import com.example.seccion10_ejercicio.R;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity implements OnPersonCreated {
  private TabLayout tabLayout;
  private ViewPager viewPager;
  private ViewPagerAdapter adapter;

  // Indice de posicion de los fragmets
  public static final int PERSON_FORM_FRAGMENT = 0;
  public static final int PERSON_LIST_FRAGMENT = 1;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    setToolbar();
    setTabLayout();
    setViewPager();
    setListenerTabLayout(viewPager);
  }

  private void setToolbar(){
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
  }

  private void setTabLayout(){
    tabLayout = (TabLayout) findViewById(R.id.tabLayout);
    tabLayout.addTab(tabLayout.newTab().setText("Form"));
    tabLayout.addTab(tabLayout.newTab().setText("List"));
  }

  private void setViewPager(){
    viewPager = (ViewPager) findViewById(R.id.viewPager);
    adapter = new ViewPagerAdapter(getSupportFragmentManager(), this, tabLayout.getTabCount());
    viewPager.setAdapter(adapter);
    viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
  }

  private void setListenerTabLayout(final ViewPager viewPager){
    tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
      @Override
      public void onTabSelected(TabLayout.Tab tab) {
        int position = tab.getPosition();
        viewPager.setCurrentItem(position);
      }

      @Override
      public void onTabUnselected(TabLayout.Tab tab) {
      }

      @Override
      public void onTabReselected(TabLayout.Tab tab) {
      }
    });
  }


  @Override
  public void onPointerCaptureChanged(boolean hasCapture) {
    super.onPointerCaptureChanged(hasCapture);
  }

  @Override
  public void createPerson(Person person) {
    /* Obtenemos el fragmento deseado, ListFragment, a traves de
     *  getSupportFragmentManager(), y posteriormente pasamos el indice de posicion
     *  de dicho fragment */
    PersonListFragment fragment = (PersonListFragment) getSupportFragmentManager().getFragments().get(PERSON_LIST_FRAGMENT);

    // Llamamos al metodo de nuestro fragment
    fragment.addPerson(person);

    // Movemos el viewPager hacia el ListFragment para ver la persona aniadida en el ListView
    viewPager.setCurrentItem(PERSON_LIST_FRAGMENT);
  }
}