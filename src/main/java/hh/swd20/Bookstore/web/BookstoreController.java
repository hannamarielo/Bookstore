package hh.swd20.Bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller

public class BookstoreController {

	// localhost:8080/index

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String helloThymeLeaf() {
		return "index"; // hellothymeleaf.html
	}
}