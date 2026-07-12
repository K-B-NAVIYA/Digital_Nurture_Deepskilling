package com.cognizant.ormlearn.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.repository.CountryRepository;

@Service
public class CountryService {
 @Autowired
 private CountryRepository repo;

 @Transactional(readOnly=true)
 public Country getCountry(String code){ return repo.findById(code).orElse(null); }

 @Transactional
 public Country addCountry(Country c){ return repo.save(c); }

 @Transactional
 public Country updateCountry(Country c){ return repo.save(c); }

 @Transactional
 public void deleteCountry(String code){ repo.deleteById(code); }

 @Transactional(readOnly=true)
 public List<Country> searchCountries(String text){
   return repo.findByNameContainingIgnoreCase(text);
 }
}
