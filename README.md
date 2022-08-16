# extremely-basics-selenium-google

## Introduction
This is very basic demo of using selenium to run e2e tests agains different browsers.

## Requirements and preparation
To run test from this project you need:
1. Java JDK v11 or later - https://www.java.com/en/download/help/download_options.html
2. Maven https://maven.apache.org/install.html
3. Webdrivers for browsers:
  - Chrome - https://chromedriver.chromium.org/downloads
  - Firefox - https://github.com/mozilla/geckodriver/releases
  - Edge - https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/

**Download wedrivers and set path to them in property file:** [testdata.properties](src/test/resources/testdata.properties)

## Run tests by using the command line
Download project, open command line and go to the root of the repository.

1. Run tests on Chrome browser:
```
mvn clean install -Dbrowser=chrome
```
2. Run tests on Firefox browser:
```
mvn clean install -Dbrowser=firefox
```
3. Run tests on Edge browser:
```
mvn clean install -Dbrowser=edge
```
## Test report
Test report generated by TestNG you can find in project directory **target/** . Screenshots of browser made at the end of every test are located on **target/screenshots/**
