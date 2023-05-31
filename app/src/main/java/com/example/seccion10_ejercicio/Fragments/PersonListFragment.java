package com.example.seccion10_ejercicio.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.seccion10_ejercicio.Adapters.PersonAdapter;
import com.example.seccion10_ejercicio.Models.Person;
import com.example.seccion10_ejercicio.R;

import java.util.ArrayList;
import java.util.List;

public class PersonListFragment extends Fragment {
  private List<Person> persons;
  private ListView listView;
  private PersonAdapter adapter;

  public PersonListFragment() {
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list, container, false);
    persons = new ArrayList<Person>();
    listView = (ListView) view.findViewById(R.id.listViewPerson);
    adapter = new PersonAdapter(getContext(), R.layout.list_view_item_person, persons);
    listView.setAdapter(adapter);

    return view;
  }

  public void addPerson(Person person){
    this.persons.add(person);
    adapter.notifyDataSetChanged();
  }
}
