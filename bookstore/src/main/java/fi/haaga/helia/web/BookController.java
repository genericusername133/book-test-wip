package fi.haaga.helia.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import fi.haaga.helia.domain.Book;
import fi.haaga.helia.repository.BookRepository;

@Controller
public class BookController {
	@Autowired
    private BookRepository repository; 

	@RequestMapping("/login")
	public String login() {
    	return "login";
    }	
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> books = (List<Book>) repository.findAll();
		model.addAttribute("books", books);
    	return "books";
    }
/*
    @RequestMapping(value = "add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
        return "addBook";
    }	

    @RequestMapping(value = "/edit/{id}")
    public String editBook(@PathVariable("id") Long bookId, Model model){
    	model.addAttribute("book", repository.findOne(bookId));
        return "editBook";
    }	    
    
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
    	return "redirect:/books";
    }
    
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long bookId, Model model) {
    	repository.delete(bookId);
        return "redirect:/books";
    }    
    */
    @RequestMapping(value = "getbooks", method = RequestMethod.GET)
    public @ResponseBody List<Book> getBooks() {
            return (List<Book>)repository.findAll();
    }      
}
