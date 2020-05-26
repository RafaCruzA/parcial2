package com.uca.capas.parcial2.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.uca.capas.parcial2.domain.Categoria;
import com.uca.capas.parcial2.service.CategoriaService;
import com.uca.capas.parcial2.service.LibroService;

@Controller
public class MainController {
	
	@Autowired
	CategoriaService categoriaService;
	
	@Autowired
	LibroService libroService;
	
	
	@RequestMapping("/inicio")
	public ModelAndView inicio() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("index");
		return mav;
	}
	
	@RequestMapping("/ingresarCategoria")
	public ModelAndView insertarCategoria() {
		ModelAndView mav = new ModelAndView();
		Categoria categoria = new Categoria();
		mav.addObject("categoria", categoria);
		mav.setViewName("ingresarCategoria");
		return mav;
	}

	@RequestMapping("/validarCategoria")
	public ModelAndView insertCatV(@Valid @ModelAttribute Categoria categoria, BindingResult result) {
		ModelAndView mav = new ModelAndView();
		if (result.hasErrors()) {
			mav.setViewName("ingresarCAtegoria");
		} else {
			try {
				categoriaService.insert(categoria);
			} catch (Exception e) {
				e.printStackTrace();
			}
			mav.addObject("condition", new Integer(1));
			mav.setViewName("index");
		}
		return mav;
	}

}