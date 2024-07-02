package com.example.ebank.dao;

import com.example.ebank.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository  extends JpaRepository<Account,Long> {
}
