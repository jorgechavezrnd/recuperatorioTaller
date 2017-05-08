package com.ucbcba.taller.repositories;

import com.ucbcba.taller.entities.TerminalHistory;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

@Transactional
public interface TerminalHistoryRepository extends CrudRepository<TerminalHistory, Integer> {

}
