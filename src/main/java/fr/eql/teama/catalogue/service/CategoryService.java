package fr.eql.teama.catalogue.service;

import fr.eql.teama.catalogue.dto.CategoryDto;
import fr.eql.teama.catalogue.entities.Category;
import fr.eql.teama.catalogue.entities.User;

import javax.jws.WebService;
import java.util.List;

@WebService
public interface CategoryService {

    /**
     * Get all categories as a tree : each category contains its children
     *
     * @return categories with level 1 (main categories)
     */
    List<CategoryDto> getCategoryTree();
}
