package com.project.sampleapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.stereotype.Controller;
import com.project.sampleapp.model.Book;
import com.project.sampleapp.services.BookService;

@Controller
//@RequestMapping("/books")
public class BookController {

   @Autowired
   private BookService bookService;
   
   @RequestMapping(value="/test")
   public String test(){
	   return "home";
   }

  }
