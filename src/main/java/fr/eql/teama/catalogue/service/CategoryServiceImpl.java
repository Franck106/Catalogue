package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dao.CategoryRepository;
import fr.eql.teama.catalogue.dto.CategoryDto;
import fr.eql.teama.catalogue.entities.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.jws.WebService;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<CategoryDto> getCategoryTree() {
        Iterable<Category> allCategories = categoryRepository.findAll();
        List<CategoryDto> dtos = new ArrayList<>();

        allCategories.forEach(category -> {
            if (category.getCategory() == null) {
                dtos.add(CategoryDto.from(category));
            }
        });

        return dtos;
    }
}
