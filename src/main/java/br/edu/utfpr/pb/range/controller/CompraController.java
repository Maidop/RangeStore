package br.edu.utfpr.pb.range.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.edu.utfpr.pb.range.model.Compra;
import br.edu.utfpr.pb.range.service.CategoriaService;
import br.edu.utfpr.pb.range.service.CompraService;
import br.edu.utfpr.pb.range.service.FornecedorService;
import br.edu.utfpr.pb.range.service.MarcaService;
import br.edu.utfpr.pb.range.service.ProdutoService;

@Controller
@RequestMapping("compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private CategoriaService categoriaService;
	
	@Autowired
	private MarcaService marcaService;
	
	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@GetMapping
	public String formulatioCompra(Model model) {

		model.addAttribute("categoria", categoriaService.findAll());
		model.addAttribute("marca", marcaService.findAll());
		model.addAttribute("produto", produtoService.findAll());
		model.addAttribute("fornecedor", fornecedorService.findAll());

		return "compra/form";
	}
	
	
	@PostMapping
	public ResponseEntity<?> save(
			@RequestBody @Valid Compra entity,
			BindingResult result, Model model,
			RedirectAttributes attributes){
		
		if (result.hasErrors()) {
			return new ResponseEntity<>(result.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		
		compraService.save(entity);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
