package com.example.backend.service;

import com.example.backend.exception.NotFoundException;
import com.example.backend.model.Question;
import com.example.backend.repository.QuestionRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    private QuestionRepository questionRepository;

    public Optional<Question> findById(Long id) {
        return questionRepository.findById(id);
    }

    public Question addNewQuestion(String content) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            Question questionJson = objectMapper.readValue(content, Question.class);
            return questionRepository.save(questionJson);
        } catch (IOException ex) {
            throw new NotFoundException("Không thêm được question" + " Thử lại", ex);
        }
    }

}
