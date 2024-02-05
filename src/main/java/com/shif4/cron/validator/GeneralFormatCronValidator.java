package com.shif4.cron.validator;

import org.springframework.scheduling.support.CronExpression;

/**
 * Validator for Cron string expression, using  CronExpression object from Quartz.
 * WORK_AROUND_SECONDS_VALUE is concatenated to cronExpression only for validation
 * because not passing seconds in arguments
 */
public class GeneralFormatCronValidator implements CronValidator {
    static String WORK_AROUND_SECONDS_VALUE = "* ";

    @Override
    public void validate(String cronExpression) {
        if (!CronExpression.isValidExpression(WORK_AROUND_SECONDS_VALUE + cronExpression)) {
            throw new IllegalArgumentException("Cron expression is not valid.");
        }
    }
}


