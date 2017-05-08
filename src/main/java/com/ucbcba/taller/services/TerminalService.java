package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.Terminal;

public interface TerminalService {

    Iterable<Terminal> listAllTerminals();

    Terminal getTerminalById(Integer id);

    Terminal saveTerminal(Terminal terminal);

    void deleteTerminal(Integer id);

}
