package hh.swd20.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import hh.swd20.Bookstore.domain.Category;
import hh.swd20.Bookstore.domain.CategoryRepository;

@Controller
public class CategoryController {
	@Autowired
	private CategoryRepository crepository;

	@RequestMapping("/categorylist")
	public String categorylist(Model model) {
		model.addAttribute("categories", crepository.findAll());
		return "categorylist";
	}

	@RequestMapping(value = "/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}

	@RequestMapping(value = "/savecategory", method = RequestMethod.POST)
	public String save(Category category) {
		crepository.save(category);
		return "redirect:categorylist";
	}

	@RequestMapping(value = "/editcategory/{id}", method = RequestMethod.GET)
	public String editStudent(@PathVariable("id") Long categoryid, Model model) {
		model.addAttribute("category", crepository.findById(categoryid));
		return "editcategory";
	}

	@RequestMapping(value = "/savecategoryEdit", method = RequestMethod.POST)
	public String saveEdit(Category category) {
		crepository.save(category);
		return "redirect:categorylist";
	}

	@RequestMapping(value = "/deletecategory/{id}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("id") Long categoryid, Model model) {
		crepository.deleteById(categoryid);
		return "redirect:../categorylist";
	}
}
