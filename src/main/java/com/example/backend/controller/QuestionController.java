package com.example.backend.controller;

import com.example.backend.model.Question;
import com.example.backend.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    @GetMapping(path = "/quest/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") Long id) {
        return new ResponseEntity(questionService.findById(id), HttpStatus.OK);
    }

    @PostMapping(path = "/quest")
    public ResponseEntity<Object> addNewQuestion(@RequestParam("content") String content) {
        return new ResponseEntity(questionService.addNewQuestion(content), HttpStatus.OK);
    }
}
