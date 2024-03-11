package ForMZ.Server.domain.category.repository;

import ForMZ.Server.domain.category.entity.Category;
import ForMZ.Server.domain.category.entity.CategoryCode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category findByCategoryCode(CategoryCode categoryCode);
}
