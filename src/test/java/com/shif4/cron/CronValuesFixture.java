package com.shif4.cron;

public class CronValuesFixture {

    //valid
    public final static String EVERY_MINUTE = "* * * * *";
    public final static String EVERY_HOUR_AT_30_MINUTE = "30 * * * *";
    public final static String EVERY_6_HOURS_AT_THE_WEEKDAYS = "0 */6 * * 1-5";
    public final static String EVERY_10_MINUTES_9_TO_17_WEEKDAYS = "*/10 9-17 * * 1-5";
    public final static String EVERY_2_HOURS_ON_10TH_AND_25TH_DAY_OF_MONTH = "0 */2 10,25 * *";

    //invalid
    public final static String EMPTY = "";
    public final static String INVALID_NUMBER_OF_MINUTES = "60 * * * *";
    public final static String INVALID_NUMBER_OF_HOURS = "* 25 * * *";
    public final static String INVALID_NUMBER_OF_DAYS_IN_MONTH = "* * 32 * *";
    public final static String INVALID_NUMBER_OF_MONTH = "* * * 13 *";
    public final static String INVALID_DAY_OF_WEEK = "* * * * 8";


    // single input cases
    public static final String ALL_VALUES_FROM_MIN_TO_MAX_CASE = "*";
    public static final String SINGULAR_VALUE_CASE = "3";
    public static final String RANGED_VALUES_CASE = "2-4";
    public static final String INTERVAL_VALUES_CASE = "*/2";
    public static final String MATCHING_VALUES_CASE = "1,3,5";
    public static final String RANGED_WITH_INTERVAL_CASE = "2-6/2";
}
