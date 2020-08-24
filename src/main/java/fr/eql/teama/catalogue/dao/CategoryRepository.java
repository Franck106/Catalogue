package fr.eql.teama.catalogue.dao;

import fr.eql.teama.catalogue.entities.Category;
import fr.eql.teama.catalogue.entities.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category, Integer> {
    List<Category> findAllByCategoryId(Integer id);
}
