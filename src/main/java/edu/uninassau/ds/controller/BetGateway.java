package edu.uninassau.ds.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;

import javax.money.CurrencyUnit;
import javax.money.Monetary;

import org.javamoney.moneta.Money;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import edu.uninassau.ds.model.Bet;
import edu.uninassau.ds.model.BetType;
import edu.uninassau.ds.remote.RemoteAPI;
import edu.uninassau.ds.service.BetMegaSenaService;
import edu.uninassau.ds.service.BetQuinaService;

@RestController
@RequestMapping("/results")
public class BetGateway{

	@Autowired
	private BetMegaSenaService betService;
	
	
	
	
	CurrencyUnit real = Monetary.getCurrency("BRL"); 
	
	
	
	
	@GetMapping
	public ModelAndView results() {
		ModelAndView mv = new ModelAndView();		
		mv.addObject("results", betService.allResults());
		mv.setViewName("/results");
	 
		Integer totalPrize = 0;
		
		for(Bet bet : betService.allResults()) {		
		    
			totalPrize = totalPrize + bet.getPrize().intValue();
		}
		
		
		mv.addObject("totalPrize", totalPrize);
		
			
		return	mv;
	}
	
	
	@GetMapping(value="/api/results")
	public @ResponseBody List<Bet> restsults() {		
		return betService.allResults();
	}
	
	
	@RequestMapping("mock")
	public String mockDocument() {		
		Bet megasena = new Bet();
		int[] numbers = RemoteAPI.getMegaSenaNumbers();
		megasena.setNumbers(numbers);
		megasena.setBetType(BetType.megasena);
		megasena.setWinners(2);
		megasena.setDate(LocalDate.now());
		
	//	Money megaSenaPrize = Money.of(15000000, real);
		megasena.setPrize(new BigDecimal(15000000));
		
		
		
		
		Bet quina = new Bet();
		int[] quina_numbers = RemoteAPI.getQuinaNumbers();
		quina.setNumbers(numbers);
		quina.setBetType(BetType.quina);
		quina.setWinners(1);
		quina.setDate(LocalDate.now());
		
		
		//Money quinaPrize = Money.of(1000000, real);
		quina.setPrize(new BigDecimal(1000000));
		
		//betMegaSenaService.save(megasena);
		
		betService.save(megasena);
		betService.save(quina);
		
		
		return "done!";
	}
	
}
