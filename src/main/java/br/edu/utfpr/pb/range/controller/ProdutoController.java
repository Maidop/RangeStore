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
import br.edu.utfpr.pb.range.model.Produto;
import br.edu.utfpr.pb.range.service.CategoriaService;
import br.edu.utfpr.pb.range.service.MarcaService;
import br.edu.utfpr.pb.range.service.ProdutoService;

@Controller
@RequestMapping("produto")
public class ProdutoController {

	@Autowired
	private CategoriaService categoriaService;
	@Autowired
	private MarcaService marcaService;
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping
	public String list(
			@RequestParam("page") Optional<Integer> page,
			@RequestParam("size") Optional<Integer> size,
			Model model) {
		
		int currentPage = page.orElse(1);
		int pageSize = size.orElse(10);
		
		Page<Produto> list = this.produtoService.findAll(PageRequest.of(currentPage-1, pageSize));
		
		model.addAttribute("produto", list);
		
		if(list.getTotalPages() > 0) {
			List<Integer> pageNumbers = IntStream.rangeClosed(1, list.getTotalPages())
					.boxed().collect(Collectors.toList());
			model.addAttribute("pageNumbers", pageNumbers);
		}
		
		return "produto/list";
	}
	
	@GetMapping({"new", "novo"})
	public String form( Model model) {
		model.addAttribute("produto", new Produto());
		carregarCombos(model);
		return "produto/form";
	}
	
	private void carregarCombos(Model model) {
		model.addAttribute("categoria",
				categoriaService.findAll() );
		model.addAttribute("marca",
				marcaService.findAll() );
	}
	
	@PostMapping
	public String save(@Valid Produto produto,
			BindingResult result,
			Model model,
			RedirectAttributes attributes){
		if ( result.hasErrors() ) {
			model.addAttribute("produto", produto);
			carregarCombos(model);
			return "produto/form";
		}
		
		produtoService.save(produto);
		
		attributes.addFlashAttribute("sucesso", 
				"Registro salvo com sucesso!");
		return "redirect:/produto";
	}
	
	@GetMapping("{id}") 
 	public String form(@PathVariable Long id, Model model) {
		model.addAttribute("produto", produtoService.findOne(id));
		carregarCombos(model);
		return "produto/form";
	}
	
	@DeleteMapping("{id}")
	public String delete(@PathVariable Long id,
			Model model,
			RedirectAttributes attributes) {
		try {
			produtoService.delete(id);
			attributes.addFlashAttribute("sucesso", 
					"Registro removido com sucesso!");
		} catch (Exception e) {
			e.printStackTrace();
			attributes.addFlashAttribute("erro", 
					"Falha ao remover registro");
		}
		return "redirect:/produto";
	}
}
