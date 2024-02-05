package com.shif4.cron;

import com.shif4.cron.parser.GeneralFormatCronParser;
import com.shif4.cron.validator.GeneralFormatCronValidator;


public class CronApplication {

    private final CronFacade facade;

    public CronApplication(CronFacade facade) {
        this.facade = facade;
    }

    public static void main(String[] args) {
        var application = new CronApplication(new CronFacade(new GeneralFormatCronValidator(), new GeneralFormatCronParser()));
        application.run(args);
    }

    private void run(String[] args) {
        facade.printParsedCronExpression(args);
    }
}



