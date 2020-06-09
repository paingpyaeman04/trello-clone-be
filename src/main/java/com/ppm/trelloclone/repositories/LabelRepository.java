package com.ppm.trelloclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppm.trelloclone.models.Label;

public interface LabelRepository extends JpaRepository<Label, Long> {

}
