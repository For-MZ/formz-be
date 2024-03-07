package ForMZ.Server.domain.post.exception;

import static ForMZ.Server.domain.post.exception.PostExceptionList.POST_NOT_FOUND;

public class InvalidSortParamException extends PostException {
    public InvalidSortParamException() {
        super(POST_NOT_FOUND.getStatusCode(), POST_NOT_FOUND.getHttpStatus(), POST_NOT_FOUND.getMessage());
    }
}