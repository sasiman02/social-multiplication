package microservice.book.socialmultiplication.controller;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.service.MultiplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/multiplications")
public class MultiplicationController {

    private final MultiplicationService multiplicationService;

    @Autowired
    public MultiplicationController(final MultiplicationService multiplicationService) {
        this.multiplicationService = multiplicationService;
    }

    @GetMapping("/random")
    Multiplication getRadnomMultiplication() {
        return multiplicationService.createRandomMultiplication();
    }
}
