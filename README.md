Clone the repo and open in the IDE

Run this project as a java application by selecting Run from 'Run' dropdown OR

To run as maven tests install maven and git.

To run tests:
 $ mvn clean test

to run with tags:

$ mvn test -Dcucumber.options="--tags @search"  - to run only scenarios with tag 'search'

Available browsers - Chrome


To generate Allure Report you should perform following steps:

$ mvn test site jetty:run

To see a report, open http://localhost:8080 in your browser.

To see cucumber native report run open target/cucumber/index.html


