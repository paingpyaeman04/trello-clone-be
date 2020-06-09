package com.ppm.trelloclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppm.trelloclone.models.Card;

public interface CardRepository extends JpaRepository<Card, Long> {

}
