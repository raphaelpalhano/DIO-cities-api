package com.github.raphaelpalhano.DIO.CitiesDistance.countries.repository;

import com.github.raphaelpalhano.DIO.CitiesDistance.countries.Country;
import org.springframework.data.jpa.repository.JpaRepository;

//passar duas entidades: entidade, e identificador da identidade: long
public interface CountryRepository extends JpaRepository<Country, Long> {

}
