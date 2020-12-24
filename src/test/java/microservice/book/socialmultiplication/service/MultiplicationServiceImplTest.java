package microservice.book.socialmultiplication.service;

import microservice.book.socialmultiplication.domain.Multiplication;
import microservice.book.socialmultiplication.domain.MultiplicationResultAttempt;
import microservice.book.socialmultiplication.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class MultiplicationServiceImplTest {
    private MultiplicationServiceImpl multiplicationServiceImpl;

    @Mock
    private RandomGenerateService randomGenerateService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        multiplicationServiceImpl = new MultiplicationServiceImpl(randomGenerateService);
    }

    @Test
    public void checkCorrectAttemptTest() {
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("John_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3000);

        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

        assertThat(attemptResult).isTrue();
    }

    @Test
    public void checkWrongAttemptTest() {
        Multiplication multiplication = new Multiplication(50, 60);
        User user = new User("John_doe");
        MultiplicationResultAttempt attempt = new MultiplicationResultAttempt(user, multiplication, 3010);

        boolean attemptResult = multiplicationServiceImpl.checkAttempt(attempt);

        assertThat(attemptResult).isFalse();
    }
}
