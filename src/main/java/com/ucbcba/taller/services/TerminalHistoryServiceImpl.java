package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.TerminalHistory;
import com.ucbcba.taller.repositories.TerminalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TerminalHistoryServiceImpl implements TerminalHistoryService {

    private TerminalHistoryRepository terminalHistoryRepository;

    @Autowired
    @Qualifier(value = "terminalHistoryRepository")
    public void setTerminalHistoryRepository(TerminalHistoryRepository terminalHistoryRepository) {
        this.terminalHistoryRepository = terminalHistoryRepository;
    }

    @Override
    public Iterable<TerminalHistory> listAllTerminalHystories() {
        return terminalHistoryRepository.findAll();
    }

    @Override
    public TerminalHistory getTerminalHistoryById(Integer id) {
        return terminalHistoryRepository.findOne(id);
    }

    @Override
    public TerminalHistory saveTerminalHistory(TerminalHistory terminalHistory) {
        return terminalHistoryRepository.save(terminalHistory);
    }

    @Override
    public void deleteTerminalHistory(Integer id) {
        terminalHistoryRepository.delete(id);
    }

}
