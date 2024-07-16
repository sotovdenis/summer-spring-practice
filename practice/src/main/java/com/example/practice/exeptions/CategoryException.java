package com.example.practice.exeptions;

public class CategoryException extends RuntimeException {
    public CategoryException(int compId ,int id) {
        super("Error occurred Sportsman category. Competition: "+compId+" status incorrect or no such Sportsman: " + id);
    }
}
