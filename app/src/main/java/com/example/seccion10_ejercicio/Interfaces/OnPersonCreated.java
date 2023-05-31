package com.example.seccion10_ejercicio.Interfaces;

import com.example.seccion10_ejercicio.Models.Person;

/* Interfaz definida en fichero aparte para la comunicacion entre el FormFragment
*  y el ListFragment, a traves del MainActivity */
public interface OnPersonCreated {
  void createPerson(Person person);
}
