package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Search by partial name
    List<Country> findByNameContainingIgnoreCase(String text);

    // Search by partial name in ascending order
    List<Country> findByNameContainingIgnoreCaseOrderByNameAsc(String text);

    // Search by starting alphabet
    List<Country> findByNameStartingWithIgnoreCaseOrderByNameAsc(String alphabet);
}