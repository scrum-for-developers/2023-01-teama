package de.codecentric.psd.worblehat.web.controller;

import de.codecentric.psd.worblehat.domain.BookService;
import de.codecentric.psd.worblehat.web.formdata.ReturnAllBooksFormData;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

/** Controller class for the */
@Controller
@RequestMapping("/returnAllBooks")
public class ReturnBooksController {

  private BookService bookService;

  @Autowired
  public ReturnBooksController(BookService bookService) {
    this.bookService = bookService;
  }

  @GetMapping
  public void prepareView(ModelMap modelMap) {
    modelMap.put("returnAllBookFormData", new ReturnAllBooksFormData());
  }

  @PostMapping
  public String returnAllBooks(
      @ModelAttribute("returnAllBookFormData") @Valid ReturnAllBooksFormData formData,
      BindingResult result) {
    if (result.hasErrors()) {
      return "returnAllBooks";
    } else {
      if (formData.getIsbn() == null || formData.getIsbn().isEmpty()) {
        bookService.returnAllBooksByBorrower(formData.getEmailAddress());
      } else {
        bookService.returnBookByBorrowerAndISBN(formData.getEmailAddress(), formData.getIsbn());
      }

      return "home";
    }
  }
}
