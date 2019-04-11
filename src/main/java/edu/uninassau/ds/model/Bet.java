package edu.uninassau.ds.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "BetEverything")
@Data
public class Bet implements Serializable{

	@Id
	private String id;
	private int[] numbers;
	private LocalDate date;
	private int winners;
	private BetType betType;
	private BigDecimal prize;
	
}
