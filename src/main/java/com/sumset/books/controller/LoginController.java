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
public class LoginController {
	@GetMapping(value = { "/login", "/" })
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView();
		String errorMessage = "Usuario no autorizado, debe autentificarse.";
		mav.addObject("errorMsg", errorMessage);
		mav.setViewName("login");
		return mav;
	}
}
