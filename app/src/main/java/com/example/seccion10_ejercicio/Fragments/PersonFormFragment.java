package com.example.seccion10_ejercicio.Fragments;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.seccion10_ejercicio.Interfaces.OnPersonCreated;
import com.example.seccion10_ejercicio.Models.Country;
import com.example.seccion10_ejercicio.Models.Person;
import com.example.seccion10_ejercicio.R;
import com.example.seccion10_ejercicio.Utils.Util;

import java.util.List;

public class PersonFormFragment extends Fragment {
  private EditText editTextName;
  private Spinner spinnerCountry;
  private Button btnCreate;
  private List<Country> countries;
  private OnPersonCreated onPersonCreated;

  public PersonFormFragment(){
  }

  @Nullable
  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_form, container, false);

    editTextName = (EditText) view.findViewById(R.id.editTextName);
    spinnerCountry = (Spinner) view.findViewById(R.id.spinnerCountry);
    btnCreate = (Button) view.findViewById(R.id.buttonCreate);
    btnCreate.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        createNewPersona();
      }
    });

    // Obtenemos todos los paises
    countries = Util.getCountries();

    /* Creamos un ArrayAdapter para ser pasado a nuestro spinner/DropDown/Lista despegable
    *  con un layout integrado en Android para su uso directo, llamado
    *  simple_spinner_dropdown_item */
    ArrayAdapter<Country> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_spinner_dropdown_item, countries);
    spinnerCountry.setAdapter(adapter);

    return view;
  }

  private void createNewPersona(){
    if (!editTextName.getText().toString().isEmpty()){
      // Recogemos el pais seleccionado de la siguiente manera
      Country country = (Country) spinnerCountry.getSelectedItem();
      Person person = new Person(editTextName.getText().toString(), country);

      // Usamos la intefaz para comunicarnos con el MainActivity y este con el otro fragment
      onPersonCreated.createPerson(person);
    }
  }

  // Eventos para enlazar el listener
  @Override
  public void onAttach(@NonNull Context context) {
    super.onAttach(context);

    if (context instanceof OnPersonCreated){
      onPersonCreated = (OnPersonCreated) context;
    }else{
      throw new RuntimeException(context.toString()+ " must implement OnPersonCreated");
    }
  }

  // Eventos para desenlazar el listener
  @Override
  public void onDetach() {
    super.onDetach();
    onPersonCreated = null;
  }
}
