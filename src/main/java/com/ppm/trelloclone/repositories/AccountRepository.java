package com.ppm.trelloclone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ppm.trelloclone.models.Account;

public interface AccountRepository extends JpaRepository<Account, String> {

}
