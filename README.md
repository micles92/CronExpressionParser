# Cron Expression Parser

'Simple application to display Cron Expressions in user-friendly way.

## Example
Command: 
`java -jar cron-expression-parser-0.0.1-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find`

Result:
```
minute        0 15 30 45
hour          0
day of month  1 15
month         1 2 3 4 5 6 7 8 9 10 11 12
day of week   1 2 3 4 5
command       /usr/bin/find
```


## How to use it:

Argument should include cron expression(separated by spaces) and command in one string.

### From command Line level:

Provide arguments in via command line:

`java -jar cron-expression-parser-0.0.1-SNAPSHOT.jar "*/15 0 1,15 * 1-5 /usr/bin/find"`

### From application level:

Simply go to [CronApplication](src/main/java/com/shif4/cron/CronApplication.java). Click on green arrow on class level.
![Modify run configuration](doc/1.png?raw=true "Modify run configuration")
Go to : **Modify run Configuration**. Add Your cron expression into **Program arguments**.
![Cron expression in program arguments](doc/2.png?raw=true "Cron expression in program arguments")


Click **Apply**, then run.

