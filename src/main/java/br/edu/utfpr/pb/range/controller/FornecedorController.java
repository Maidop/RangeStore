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

import br.edu.utfpr.pb.range.model.Fornecedor;
import br.edu.utfpr.pb.range.service.FornecedorService;

@Controller
@RequestMapping("fornecedor")
public class FornecedorController {
	
	@Autowired
	private FornecedorService fornecedorService;

	@GetMapping
	public String list(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size,
			Model model) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(10);
		
		Page<Fornecedor> list = this.fornecedorService.findAll(PageRequest.of(currentPage-1, pageSize));
		
		model.addAttribute("fornecedor", list);
		
		if(list.getTotalPages() > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, list.getTotalPages())
					.boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		return "fornecedor/list";
	}
	
	@GetMapping({"new", "novo"})
	public String form( Model model) {
		model.addAttribute("fornecedor", new Fornecedor());
		return "fornecedor/form";
	}
	
	
	@PostMapping
	public String save(@Valid Fornecedor fornecedor,
			BindingResult result,
			Model model,
			RedirectAttributes attributes){
		if ( result.hasErrors() ) {
			model.addAttribute("fornecedor", fornecedor);
			return "fornecedor/form";
		}
		
		fornecedorService.save(fornecedor);
		
		attributes.addFlashAttribute("sucesso", 
				"Registro salvo com sucesso!");
		return "redirect:/fornecedor";
	}
	
	@GetMapping("{id}") 
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("fornecedor", fornecedorService.findOne(id));
		return "fornecedor/form";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id,
			Model model,
			RedirectAttributes attributes) {
		try {
			fornecedorService.delete(id);
			attributes.addFlashAttribute("sucesso", 
					"Registro removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("erro", 
					"Falha ao remover registro");
		}
		return "redirect:/fornecedor";
	}
}
