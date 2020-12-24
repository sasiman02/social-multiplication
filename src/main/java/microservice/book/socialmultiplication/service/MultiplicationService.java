package microservice.book.socialmultiplication.service;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;

public interface MultiplicationService {
    Multiplication createRandomMultiplication();

    boolean checkAttempt(final MultiplicationResultAttempt resultAttempt);
}
