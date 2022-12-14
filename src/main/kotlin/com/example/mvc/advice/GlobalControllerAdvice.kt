package com.example.mvc.advice

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

// restcontroller에서 예외 발생하면 여기서 처리
// 전역 에러 처리
@RestControllerAdvice
class GlobalControllerAdvice {

    @ExceptionHandler(value = [RuntimeException::class])
    fun exception(e: RuntimeException): String{
        return "Server Error"
    }

    @ExceptionHandler(value = [IndexOutOfBoundsException::class])
    fun indexOutOfBoundsException(e: IndexOutOfBoundsException): ResponseEntity<String>{
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Index Error")
    }
}