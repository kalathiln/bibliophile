package com.koma.library.dbservice.resource;

import com.koma.library.dbservice.model.Quote;
import com.koma.library.dbservice.model.Quotes;
import com.koma.library.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.stream.Collectors;

@RestController
/*
 * @RestController simply returns the object and object data is directly written
 * into HTTP response as JSON or XML.
 */
@RequestMapping("/rest/db")
/*
 * Used to implement the URL handler with HTTP requests GET, POST, PUT, DELETE
 * and Patch It
 * supports @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping.
 * 
 * @GetMapping("/get/{id}")
 */
public class DBServiceResource {
	private QuotesRepository quotesRepository;

	public DBServiceResource(QuotesRepository quotesRepository) {
		this.quotesRepository = quotesRepository;
	}

	@GetMapping("/{username}")
	public List<String> getQuotes(@PathVariable("username") final String username) {
		return getQuotesByUserName(username);
	}
	
	private List<String> getQuotesByUserName(@PathVariable("username") final String username){
		 return quotesRepository.findByUserName(username)
				 .stream()
				 .map(quote -> {
			return quote.getQuote();
		}).collect(Collectors.toList());
	}
	
	@PostMapping("/delete/{username}")
    public List<String> delete(@PathVariable("username") final String username) {

        List<Quote> quotes = quotesRepository.findByUserName(username);
        System.out.println("quotes asdasd:"+quotes);
        quotesRepository.findByUserName(username)
        .stream()
        .forEach(quote -> {
        	quotesRepository.delete(quote);
        });
        
        
        

        return getQuotesByUserName(username);
    }
	
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes) {
		quotes.getQuotes()
		.stream()
		.map(quote -> (new Quote(quotes.getUserName(), quote)))
		.forEach(quote -> {
			quotesRepository.save(quote);
		});
		return getQuotesByUserName(quotes.getUserName());
	}
}
