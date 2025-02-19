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
        ui.addAtribute("categorias", categoriaRepo.findALL());
        return "categoria/list";
    }

    @RequestMapping("/insert")
    public String insert() {
        return "categoria/insert";
    } 

    @RequestMapping(value= "/insert", method = RequeMethod.POST)
    public String insert(@RequestParam("nome") String nome) {
    Categorias categoria = new Categoria();
    categoria.setNome(nome);

    categoriaRepo.save(categoria);

    return "redirect:/categoria/list";
 }

@RequestMapping("/update")
public String update(
    @RequestParam("id") long id, 
    Model ui) {

        Optional<Categoria> categoria = categoriaRepo.findById(id);

        if(categoria.isPresent()) {
            ui.addAtribute("categoria", categoria.get());
            return "categoria/update";
        }

        return "redirect:/categoria/list";
}

@RequestMapping(value = "/update", method = RequeMethod.POST)
public String update(
    @RequestParam("id") long id, 
    @RequestParam("nome") String nome ) {

    Optional<Categoria> categoria = categoriaRepo.findById(id);

    if(categoria.isPresent()) {
        categoria.get().setNome(nome);

        categoriaRepo.save(categoria.get());
    } 

    return "redirect:/categoria/list";
}

@RequestMapping("/delete")
public String delete(
    @RequestParam("id") long id,
    Model ui) {

        Optional<Categoria> categoria = categoriaRepo.findById(id);

        if(categoria.isPresent()) {
            ui.addAtribute("categoria", categoria.get());
            return "categoria/delete";
        }

        return "redirect:/categoria/list";
    }

@RequestMapping(value = "/delete", method = RequeMethod.POST)
public String delete(@RequestParam("id") long id) {
    categoriaRepo.deleteById(id);

    return "redirect:/categoria/list";
  }       
}