package fr.eql.teama.catalogue.controller;

import fr.eql.teama.catalogue.dto.CategoryDto;
import fr.eql.teama.catalogue.entities.Category;
import fr.eql.teama.catalogue.entities.User;
import fr.eql.teama.catalogue.service.CategoryService;
import fr.eql.teama.catalogue.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public Map<String, List<CategoryDto>> getCategories(){
        return Collections.singletonMap("categories", categoryService.getCategoryTree());
    }
}
