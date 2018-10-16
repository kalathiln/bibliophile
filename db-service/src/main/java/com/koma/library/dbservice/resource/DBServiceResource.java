package com.koma.library.dbservice.resource;

import com.koma.library.dbservice.repository.QuotesRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
/* @RestController simply returns the object
 *  and object data is directly written into HTTP response as JSON or XML.
 */
@RequestMapping("/rest/db")
/* Used to implement the URL handler with HTTP requests GET, POST, PUT, DELETE and Patch
 *  It supports @GetMapping, @PostMapping, @PutMapping, @DeleteMapping, @PatchMapping.
 *  @GetMapping("/get/{id}")
 */
public class DBServiceResource {
    private QuotesRepository quotesRepository;
    @GetMapping("/{username}")
        public List<String> getQuotes(@PathVariable("username") final String username){

        quotesRepository.findByUserName(username);

        return null;
    }


}
