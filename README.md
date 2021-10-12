# Playwright

![Playwright](https://user-images.githubusercontent.com/52770689/136776927-6fc1bf5d-bb11-4399-9b45-bcb4b7fe311f.png)

Playwright Java-Maven-TestNG framework. Implemented cross browser testing. Implemented page object model . Added Log 4j Api to generate log files. Used TestNG inbuild reports. Used retry analyzer to rerun the failed test cases. Used properties file to read the application url.  Given support to chrome, firefox, microsoft edge, headless chrome, headless firefox, headlessedge. 

Maven Project Execution without using any IDE after downloading project to local system-> Select CMD and go to project path where pom.xml file is loacted and execute following commands in CMD

To execute in chrome->`mvn test -Dbrowsername=chrome`

To execute in headlesschrome->`mvn test -Dbrowsername=headlesschrome`

To execute in firefox->`mvn test -Dbrowsername=firefox`

To execute in headlessfirefox->`mvn test -Dbrowsername=headlessfirefox`

To execute in edge->`mvn test -Dbrowsername=edge`

To execute in headlessedge->`mvn test -Dbrowsername=headlessedge`

Testng Report path after execution->Playwright\test-output\index.html

Log file->Playwright/log/testlog.log

Prerequisites

1.Java 8/+ should be present and environment variable should be set in the local system.
2.Maven should be present and environment variable should be set in the local system.
3.All browsers mentioned above should be present in the local system.

