package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Terminal;
import com.ucbcba.taller.repositories.TerminalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class TerminalServiceImpl implements TerminalService {

    private TerminalRepository terminalRepository;

    @Autowired
    @Qualifier(value = "terminalRepository")
    public void setTerminalRepository(TerminalRepository terminalRepository) {
        this.terminalRepository = terminalRepository;
    }

    @Override
    public Iterable<Terminal> listAllTerminals() {
        return terminalRepository.findAll();
    }

    @Override
    public Terminal getTerminalById(Integer id) {
        return terminalRepository.findOne(id);
    }

    @Override
    public Terminal saveTerminal(Terminal terminal) {
        return terminalRepository.save(terminal);
    }

    @Override
    public void deleteTerminal(Integer id) {
        terminalRepository.delete(id);
    }

}