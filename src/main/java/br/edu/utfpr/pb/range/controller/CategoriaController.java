package br.edu.utfpr.pb.range.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.pb.range.model.Categoria;
import br.edu.utfpr.pb.range.service.CategoriaService;

@Controller
@RequestMapping("categoria")
public class CategoriaController {
	
	@Autowired
	private CategoriaService categoriaService;
	
	@GetMapping
	public String list(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size,
			Model model) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(5);
		
		Page<Categoria> list = this.categoriaService.findAll(PageRequest.of(currentPage-1, pageSize));
		
		model.addAttribute("categorias", list);
		
		if(list.getTotalPages() > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, list.getTotalPages())
					.boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		return "categoria/list";
	}
	
	@GetMapping(value = {"novo", "form", "new"})
	public String form(Model model) {
		model.addAttribute("categoria", new Categoria());
		return "categoria/form";
	}
	
	@PostMapping
	public String save(@Valid Categoria categoria,
			BindingResult result,
			Model model,
			RedirectAttributes attributes){
		if ( result.hasErrors() ) {
			model.addAttribute("categoria", categoria);
			return "categoria/form";
		}
		
		categoriaService.save(categoria);
		
		attributes.addFlashAttribute("sucesso", 
				"Registro salvo com sucesso!");
		return "redirect:/categoria";
	}
	
	@GetMapping("{id}") // /categoria/25
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("categoria", categoriaService.findOne(id));
		return "categoria/form";
	}
	
	@DeleteMapping("{id}") // /categoria/25
	public String delete(@PathVariable Long id,
			Model model,
			RedirectAttributes attributes) {
		try {
			categoriaService.delete(id);
			attributes.addFlashAttribute("sucesso", 
					"Registro removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("erro", 
					"Falha ao remover registro");
		}
		return "redirect:/categoria";
	}
	
}
