package com.shif4.cron.validator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.shif4.cron.CronValuesFixture.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class GeneralFormatCronValidatorTest {

    final GeneralFormatCronValidator validator = new GeneralFormatCronValidator();

    @ParameterizedTest
    @ValueSource(strings = {EVERY_MINUTE, EVERY_HOUR_AT_30_MINUTE, EVERY_6_HOURS_AT_THE_WEEKDAYS,
            EVERY_10_MINUTES_9_TO_17_WEEKDAYS, EVERY_2_HOURS_ON_10TH_AND_25TH_DAY_OF_MONTH})
    void validate_shouldPass_for_valid_cron_expression(String validCronExpression) {
        assertDoesNotThrow(() -> validator.validate(validCronExpression));
    }


    @ParameterizedTest
    @ValueSource(strings = {EMPTY, INVALID_NUMBER_OF_MINUTES, INVALID_NUMBER_OF_HOURS,
            INVALID_NUMBER_OF_DAYS_IN_MONTH, INVALID_NUMBER_OF_MONTH, INVALID_DAY_OF_WEEK})
    void validate_shouldThrow_IllegalArgumentException(String invalidCronExpression) {
        assertThrows(IllegalArgumentException.class,
                () -> validator.validate(invalidCronExpression));
    }
}