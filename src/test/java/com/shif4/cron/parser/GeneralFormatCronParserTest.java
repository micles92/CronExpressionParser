package com.shif4.cron.parser;

import com.shif4.cron.CronComponent;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static com.shif4.cron.CronValuesFixture.*;
import static com.shif4.cron.CronComponent.DAY_OF_WEEK;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GeneralFormatCronParserTest {

    final GeneralFormatCronParser parser = new GeneralFormatCronParser();

    @MethodSource("provideArgumentsForCronParser")
    @ParameterizedTest(name = "Should parse input: {0}, for: {1} to expected values: {3}")
    void testParse(String input, CronComponent cronComponent, List<String> expectedResult) {

        final var result = parser.parse(input, cronComponent);

        assertEquals(expectedResult, result);
    }

    //using DAY_OF_WEEK Cron component because it has minValue:0 and maxValue:6 - it's easier to test
    private static Stream<Arguments> provideArgumentsForCronParser() {
        return Stream.of(
                Arguments.of(SINGULAR_VALUE_CASE, DAY_OF_WEEK, List.of("3")),
                Arguments.of(ALL_VALUES_FROM_MIN_TO_MAX_CASE, DAY_OF_WEEK, List.of("0", "1", "2", "3", "4", "5", "6")),
                Arguments.of(RANGED_VALUES_CASE, DAY_OF_WEEK, List.of("2", "3", "4")),
                Arguments.of(INTERVAL_VALUES_CASE, DAY_OF_WEEK, List.of("0", "2", "4", "6")),
                Arguments.of(MATCHING_VALUES_CASE, DAY_OF_WEEK, List.of("1", "3", "5")),
                Arguments.of(RANGED_WITH_INTERVAL_CASE, DAY_OF_WEEK, List.of("2", "4", "6"))
        );
    }
}

