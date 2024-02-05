package com.shif4.cron.parser;

import com.shif4.cron.CronComponent;

import java.util.List;

public interface CronParser {
    List<String> parse(final String valueToParse, CronComponent cronComponent);
}
