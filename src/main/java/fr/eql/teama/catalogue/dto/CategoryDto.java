package fr.eql.teama.catalogue.dto;

import fr.eql.teama.catalogue.entities.Category;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
public class CategoryDto {
    private int id;
    private String name;
    private List<CategoryDto> categories;
    private String image;
    private String description;

    public static CategoryDto from(Category category) {
        CategoryDto dto = new CategoryDto();
        dto.setName(category.getName());
        dto.setId(category.getId());
        dto.setCategories(category.getCategories().stream().map(CategoryDto::from).collect(Collectors.toList()));
        dto.setImage(category.getImage());
        dto.setDescription(category.getDescription());

        return dto;
    }
}
