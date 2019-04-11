package edu.uninassau.ds.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.uninassau.ds.model.Bet;

public interface BetRepository extends MongoRepository<Bet, String>{

}
