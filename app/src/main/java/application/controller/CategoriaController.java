package application.controller; 

import java.util.Optional; 

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequeMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Categorias;
import application.repository.CategoriaRepository;

@controller
@RequestMapping("/categoria")
public class CategoriaController {
    @Autowired
    private CategoriaRepository categoriaRepo;

    @RequestMapping("/list")
    public String list(Model ui) {
        ui.addAtribute("categorias,")
    }