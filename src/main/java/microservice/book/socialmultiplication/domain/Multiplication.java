package microservice.book.socialmultiplication.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
public final class Multiplication {
    private final int factorA;
    private final int factorB;

    Multiplication() {
        this(0,0);
    }
}
