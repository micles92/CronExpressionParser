package com.shif4.cron;

import com.shif4.cron.parser.CronParser;
import com.shif4.cron.validator.CronValidator;

import static com.shif4.cron.CronComponent.*;

public class CronFacade {
    public static final String COMMAND_NAME = "command";
    public static final char SPACE_CHARACTER = ' ';
    public static final String REGEX_PATTERN_TO_SPLIT_CRON_VALUES = "\\s+";
    private final CronValidator cronValidator;
    private final CronParser cronParser;

    public CronFacade(CronValidator cronValidator, CronParser cronParser) {
        this.cronValidator = cronValidator;
        this.cronParser = cronParser;
    }

    public void printParsedCronExpression(String[] args) {
        validateInputArray(args);
        final int lastSpaceIndex = args[0].lastIndexOf(SPACE_CHARACTER);
        String cronExpression = args[0].substring(0, lastSpaceIndex);
        String extractedCommand = args[0].substring(lastSpaceIndex + 1);

        cronValidator.validate(cronExpression);

        String[] cronComponents = cronExpression.split(REGEX_PATTERN_TO_SPLIT_CRON_VALUES);

        printScheduleItem(MINUTE, cronComponents[0]);
        printScheduleItem(HOUR, cronComponents[1]);
        printScheduleItem(DAY_OF_MONTH, cronComponents[2]);
        printScheduleItem(MONTH, cronComponents[3]);
        printScheduleItem(DAY_OF_WEEK, cronComponents[4]);
        printExtractedCommand(extractedCommand);
    }

    private void printExtractedCommand(final String extractedCommand) {
        System.out.printf("%-14s%s%n", COMMAND_NAME, extractedCommand);

    }

    private void printScheduleItem(CronComponent component, String valueToParse) {
        var scheduleList = cronParser.parse(valueToParse, component);
        System.out.printf("%-14s%s%n", component.getName(), String.join(" ", scheduleList));
    }

    private void validateInputArray(String[] args) {
        if (args == null || args.length == 0 || args[0] == null || args[0].isEmpty()) {
            throw new IllegalArgumentException("Provided arguments are invalid.");
        }
    }
}
