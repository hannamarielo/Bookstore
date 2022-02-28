package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Book;
import hh.swd20.Bookstore.domain.BookRepository;

@Controller
public class BookstoreController {
			@Autowired
			private BookRepository repository;
			
			@RequestMapping("/booklist")
			public String booklist(Model model) {		
				model.addAttribute("books", repository.findAll());
		        return "booklist";
			}
			
			@RequestMapping(value = "/add")
		    public String addBook(Model model){
		    	model.addAttribute("book", new Book());
		        return "addbook";
		    } 
		    
		    @RequestMapping(value = "/savebook", method = RequestMethod.POST)
		    public String save(Book book){
		        repository.save(book);
		        return "redirect:booklist";
		    }
		    
		    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
		    public String editStudent(@PathVariable("id") Long bookId, Model model){
		    	model.addAttribute("book", repository.findById(bookId));
		        return "editbook";
		    }
		    
		    @RequestMapping(value = "/saveEdit", method = RequestMethod.POST)
		    public String saveEdit(Book book){
		        repository.save(book);
		        return "redirect:booklist";
		    }

		    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
		    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
		    	repository.deleteById(bookId);
		        return "redirect:../booklist";
		    }
}