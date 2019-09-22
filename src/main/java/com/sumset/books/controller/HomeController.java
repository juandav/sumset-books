/**
 * Module dependencies
 */
package com.sumset.books.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author juandav
 *
 */
@Controller
@RequestMapping("app")
public class HomeController {
	@GetMapping(value = { "/home", "/" })
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("home");
		return mav;
	}
}
