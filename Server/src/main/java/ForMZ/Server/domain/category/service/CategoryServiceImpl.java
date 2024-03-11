package ForMZ.Server.domain.category.service;

import ForMZ.Server.domain.category.entity.Category;
import ForMZ.Server.domain.category.entity.CategoryCode;
import ForMZ.Server.domain.category.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    public Category getCategory(String categoryCode){
        if(categoryCode.isBlank())
            return null;
        return categoryRepository.findByCategoryCode(CategoryCode.parsing(categoryCode));
    }
}