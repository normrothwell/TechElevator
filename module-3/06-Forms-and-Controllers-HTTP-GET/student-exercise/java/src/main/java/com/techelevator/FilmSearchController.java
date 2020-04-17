package com.techelevator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.techelevator.dao.FilmDao;
import com.techelevator.dao.model.Film;

/**
 * FilmSearchController
 */
@Controller
public class FilmSearchController {

    @Autowired
    FilmDao filmDao;
    
    
    @RequestMapping ("/filmList")
    public String showFilmSearchForm() {
    	return "filmList";
    }

    //Can also use defaultvalue = 0 to set a default value as opposed to checking for null (put after requestparam in the variable)
    @RequestMapping("/filmSearch")
    public String searchFilms(@RequestParam String genre, @RequestParam (required = false) Integer minLength, @RequestParam (required = false) Integer maxLength, ModelMap map) {
    	
    	if (minLength == null) {
    		minLength = 0;
    	}
    	
    	if (maxLength == null) {
    		maxLength = 999;
    	}
    	
    	List <Film> filmList = filmDao.getFilmsBetween(genre, minLength, maxLength);
    	map.put("filmList", filmList);
    	
        return "filmList";
    }

}