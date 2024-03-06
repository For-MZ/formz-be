package ForMZ.Server.domain.category.exception;

import lombok.Getter;

public class CategoryLogicException extends RuntimeException{
    @Getter
    private CategoryExceptionCode categoryExceptionCode;

    public CategoryLogicException(CategoryExceptionCode categoryExceptionCode){
        super(categoryExceptionCode.getMessage());
        this.categoryExceptionCode = categoryExceptionCode;
    }
}
