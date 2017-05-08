package com.ucbcba.taller.services;

import com.ucbcba.taller.entities.TerminalHistory;

public interface TerminalHistoryService {

    public Iterable<TerminalHistory> listAllTerminalHystories();

    public TerminalHistory getTerminalHistoryById(Integer id);

    public TerminalHistory saveTerminalHistory(TerminalHistory terminalHistory);

    public void deleteTerminalHistory(Integer id);

}
