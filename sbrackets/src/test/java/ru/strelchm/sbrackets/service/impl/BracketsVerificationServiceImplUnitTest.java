package ru.strelchm.sbrackets.service.impl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import ru.strelchm.sbrackets.service.BracketsVerificationService;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BracketsVerificationServiceImplUnitTest {
    private final BracketsVerificationService bracketsVerificationService = new BracketsVerificationServiceImpl();

    @Test
    void shouldVerifyEmptyString() {
        assertTrue(bracketsVerificationService.verify(""));
    }

    @ParameterizedTest
    @MethodSource("onlyOneBracketStrings")
    void shouldNotVerifyIfThereIsOnlyOneBracket(String text) {
        assertFalse(bracketsVerificationService.verify(text));
    }

    @ParameterizedTest
    @MethodSource("emptyBracketsStrings")
    void shouldNotVerifyEmptyBrackets(String text) {
        assertFalse(bracketsVerificationService.verify(text));
    }

    @ParameterizedTest
    @MethodSource("correctBracketsStrings")
    void shouldVerify(String text) {
        assertTrue(bracketsVerificationService.verify(text));
    }

    private static Stream<String> emptyBracketsStrings() {
        return Stream.of(
                "()",
                "dsf()",
                "()sdf",
                "(()sdf)",
                "(sdf())"
        );
    }

    private static Stream<String> correctBracketsStrings() {
        return Stream.of(
                "((j)(sdf))",
                "(j)(sdf)",
                "dsf(sdf)sdf",
                "dsf(sdf)",
                "Вчера я отправился в поход в лес (это мое любимое место для отдыха) вместе с друзьями. " +
                        "Мы выбрали маршрут, который проходил через горные потоки и поля (для разнообразия). " +
                        "В начале пути погода была отличной, солнце светило ярко, и птицы радостно пели. " +
                        "Однако, когда мы подошли ближе к вершине горы, небо стало покрываться облаками, " +
                        "(как будто природа готовила нам небольшой сюрприз). " +
                        "Несмотря на это, виды были захватывающими, особенно когда мы достигли высшей точки и " +
                        "увидели прекрасный вид на долину (я почувствовал, что все усилия стоили того).",
                "(sdf)sdf"
        );
    }

    private static Stream<String> onlyOneBracketStrings() {
        return Stream.of(
                "dsf(",
                "(Sf)dsf(",
                "(sdf",
                "dsf)",
                "sdf)",
                "(sdf))"
        );
    }
}