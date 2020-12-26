package microservices.book.socialmultiplication.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RandomGeneratorServiceTest {

    @Autowired
    private RandomGenerateService randomGenerateService;

    @Test
    public void generatorRandomFactorIsBetweenExpectedLimits() throws Exception {
        List<Integer> randomFactors = IntStream.range(0, 1000)
                .map(i -> randomGenerateService.generateRandomFactor())
                .boxed()
                .collect(Collectors.toList());

        assertThat(randomFactors)
                .containsOnlyOnceElementsOf(IntStream.range(11,100)
                .boxed()
                .collect(Collectors.toList()));
    }
}
