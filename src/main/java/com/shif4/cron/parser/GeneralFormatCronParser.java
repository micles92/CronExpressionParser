package com.shif4.cron.parser;

import com.shif4.cron.CronComponent;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GeneralFormatCronParser implements CronParser {

    @Override
    public List<String> parse(String valueToParse, CronComponent cronComponent) {
        int min = cronComponent.getMinValue();
        int max = cronComponent.getMaxValue();
        if (valueToParse.equals("*")) {
            return createRangeList(min, max);
        } else {
            List<String> result = new ArrayList<>();
            String[] subFields = valueToParse.split(",");
            for (String subField : subFields) {
                processSubField(result, subField, min, max);
            }
            return result;
        }
    }

    private List<String> createRangeList(int start, int end) {
        return IntStream.rangeClosed(start, end)
                .mapToObj(String::valueOf)
                .collect(Collectors.toList());
    }

    private void processSubField(List<String> result, String subField, int min, int max) {
        if (subField.contains("-") && subField.contains("/")) {
            processRangeAndIntervalSubField(result, subField, min, max);
        } else if (subField.contains("-")) {
            processRangeSubField(result, subField);
        } else if (subField.startsWith("*/")) {
            processIntervalSubField(result, subField, min, max);
        } else {
            result.add(subField);
        }
    }

    private void processRangeAndIntervalSubField(List<String> result, String subField, int min, int max) {
        String[] parts = subField.split("/");
        String rangePart = parts[0];
        int interval = Integer.parseInt(parts[1]);

        processRangeSubFieldWithInterval(result, rangePart, interval, min, max);
    }

    private void processRangeSubFieldWithInterval(List<String> result, String rangePart, int interval, int min, int max) {
        String[] range = rangePart.split("-");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);

        for (int i = start; i <= end; i += interval) {
            if (i >= min && i <= max) {
                result.add(String.valueOf(i));
            }
        }
    }

    private void processRangeSubField(List<String> result, String subField) {
        String[] range = subField.split("-");
        int start = Integer.parseInt(range[0]);
        int end = Integer.parseInt(range[1]);
        result.addAll(createRangeList(start, end));
    }

    private void processIntervalSubField(List<String> result, String subField, int min, int max) {
        int interval = Integer.parseInt(subField.substring(2));
        for (int i = min; i <= max; i += interval) {
            result.add(String.valueOf(i));
        }
    }
}

