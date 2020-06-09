package com.ppm.trelloclone.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppm.trelloclone.models.Checklist;

public interface ChecklistRepository extends JpaRepository<Checklist, Long> {
	List<Checklist> findByCardId(Long card_id);
}
