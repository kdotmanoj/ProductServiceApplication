package dev.manoj.productserviceapplication.exceptionhandlers;

import dev.manoj.productserviceapplication.dtos.ExceptionDto;
import dev.manoj.productserviceapplication.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<ExceptionDto> handleArithmeticException(ArithmeticException ex) {
        return buildResponse("ArithmeticException occurred", "ArithmeticException", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ExceptionDto> handleArrayIndexOutOfBoundsException(ArrayIndexOutOfBoundsException ex) {
        return buildResponse("ArrayIndexOutOfBoundsException occurred", "ArrayIndexOutOfBoundsException", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleProductNotFoundException(ProductNotFoundException ex) {
        String message = "Invalid productId " + ex.getId() + " passed";
        return buildResponse(message, "ProductNotFoundException caught", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDto> handleGeneralException(Exception ex) {
        return buildResponse("Something went wrong", "Exception", HttpStatus.BAD_REQUEST);
    }

    private ResponseEntity<ExceptionDto> buildResponse(String message, String resolution, HttpStatus status) {
        ExceptionDto dto = new ExceptionDto();
        dto.setMessage(message);
        dto.setResolution(resolution);
        return new ResponseEntity<>(dto, status);
    }
}
