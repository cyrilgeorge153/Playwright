# Playwright

![Playwright](https://user-images.githubusercontent.com/52770689/136776927-6fc1bf5d-bb11-4399-9b45-bcb4b7fe311f.png)

> Playwright Java-Maven-Junit framework. 

> Implemented cross browser testing. 

> Implemented page object model .

> Added Log 4j Api to generate log files.

> Used Allure report. 

> Given support to chrome, firefox, microsoft edge, headless chrome, headless firefox, headlessedge. 

> Supports parallel execution of test cases.

Maven Project Execution without using any IDE after downloading project to local system-> Select CMD and go to project path where pom.xml file is loacted and execute following commands in CMD

To execute in chrome->`mvn test -Dbrowsername=chrome`

To execute in headlesschrome->`mvn test -Dbrowsername=headlesschrome`

To execute in firefox->`mvn test -Dbrowsername=firefox`

To execute in headlessfirefox->`mvn test -Dbrowsername=headlessfirefox`

To execute in edge->`mvn test -Dbrowsername=edge`

To execute in headlessedge->`mvn test -Dbrowsername=headlessedge`

To view Allure Report after test case execution, use the command->`allure serve allure-results`

![8Q7njVdCGk](https://user-images.githubusercontent.com/52770689/137688801-d285cc87-bca8-4e37-be0f-877520a88355.png)

![YI51K4cydu](https://user-images.githubusercontent.com/52770689/137689188-92579862-05d4-4f6f-84b5-24df7066e830.png)

**Test execution gif->** ![ewO9C9CLU0](https://user-images.githubusercontent.com/52770689/138232179-2ae6bf3f-bf0a-4bb1-a531-3c7bf45a117a.gif)

**Log file->** Playwright/log/testlog.log

**Test execution video->** Playwright/videos

**Prerequisites**

1.Java 8/+ should be present and environment variable should be set in the local system.

2.Maven should be present and environment variable should be set in the local system.

3.All browsers mentioned above should be present in the local system.

