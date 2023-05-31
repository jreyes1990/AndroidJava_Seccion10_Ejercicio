package com.example.seccion10_ejercicio.Models;

import androidx.annotation.NonNull;

import java.text.MessageFormat;

public class Country {
  private String Name;
  private String CountryCode;

  public Country(String name, String countryCode) {
    Name = name;
    CountryCode = countryCode;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public String getCountryCode() {
    return CountryCode;
  }

  public void setCountryCode(String countryCode) {
    CountryCode = countryCode;
  }

  public String getFlagURL(){
    return MessageFormat.format("http://www.geognos.com/api/en/countries/flag/{0}.png", this.getCountryCode());
  }

  /* Importante!! Sobreescribimos el metodo toString() de nuestra clase POJO Country
  *  para que cuando el Sppiner llame internamente cada objeto, use el name para ser mostrado
  *  como unico valor posible en la lista despegable */
  @NonNull
  @Override
  public String toString() {
    return Name;
  }
}
