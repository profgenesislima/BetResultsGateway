package edu.uninassau.ds.service;

import java.time.LocalDate;
import java.util.List;

import edu.uninassau.ds.model.Bet;
import edu.uninassau.ds.model.BetType;

public interface BetService {

	String result(BetType betType, LocalDate date);
	List<Bet> allResultsByBetType(BetType betType);
	List<Bet> resultsByBetType(BetType betType);
	List<Bet> allResults();
	void save(Bet bet);
	void update(Bet bet);
	

	
	
	
	
}
