To simply run test suite just execute maven goal:

mvn clean test

If running from IDE, please use for your run configuration testng xml suite fuile or Test runner from "testRunners" folder. Do not use direct run configuration against feature file, because it will not apply predefined parameters from BasicTest.java class.
In any case, one runner corresponds exactly to one feature file, so this should not make any inconvenience :)