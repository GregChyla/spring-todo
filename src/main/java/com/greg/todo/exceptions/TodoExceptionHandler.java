package com.greg.todo.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TodoExceptionHandler extends RuntimeException{
    private final String exceptionMessage;
}
