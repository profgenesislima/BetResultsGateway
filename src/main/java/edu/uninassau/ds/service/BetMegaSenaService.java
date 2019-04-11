package edu.uninassau.ds.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uninassau.ds.model.Bet;
import edu.uninassau.ds.model.BetType;
import edu.uninassau.ds.repository.BetRepository;

@Service
public class BetMegaSenaService implements BetService{

	@Autowired
	private BetRepository repository;
	
	@Override
	public List<Bet> allResultsByBetType(BetType betType) {
		
		return null;
	}

	@Override
	public List<Bet> resultsByBetType(BetType betType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Bet> allResults() {
		
		return repository.findAll();
	}

	@Override
	public String result(BetType betType, LocalDate date) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Bet bet) {
	repository.save(bet);
		
	}

	@Override
	public void update(Bet bet) {
		// TODO Auto-generated method stub
		
	}

	
	
}
