# BDD (Cucumber) Framework with Serenity Reports for Rest-API Automation

## Overview
  This framework is developed using Behavior-Driven Development (BDD) principles with Cucumber and integrated with Serenity Reports. It is designed specifically for automating REST APIs, providing robust reporting and flexibility for handling API responses and requests.
### Key Features
#### Cucumber BDD:
- Enables writing human-readable test scenarios that bridge the gap between non-technical stakeholders and developers.
#### Serenity Reports:
- Provides detailed, narrative-style test reports with test case histories and visual documentation.
#### Response Value Reuse:
- The framework allows passing response values from one API request to another. Simply reference the value using the $ symbol as "$key" to inject it into subsequent API requests dynamically.
#### Comprehensive Logging:
  Logs are configured at a high level, printing detailed information for each test scenario, including:
  - Scenario name
  - Duration
  - Execution status (pass/fail)
  - Failure cause or error (if any)
#### Database Integration:
- The framework can push scenario execution details (status, duration, errors) into a database for further analysis and tracking.
#### Serenity Reports for UAT:
- The Serenity reports are ideal for both User Acceptance Testing (UAT) and API automation. They present test results in a clear and easily understandable format, making them shareable with non-technical stakeholders.
#### Jenkins Integration:
- The framework is designed to run seamlessly in Jenkins pipelines. Serenity reports can be accessed and shared with business users, provided the tests are executed through a Jenkins pipeline.

## Prerequisites
- Java 17 or higher
- Maven 3.6v or higher
- Junit 5.0v or higher
- RestAssured 5.4.0v or higher
- Cucumber 7.16v or higher
- Serenity 4.1.4v or higher

## How to run form cmd line
In the pom.xml, we have configured serenity reports as well as single-page reports.

### To build the Project
To build the project and download all dependencies, run the whole suite following Maven command:
```bash
mvn clean install
```

### To run specific feature, use the following command:
```bash
mvn clean install -Dcucumber.options="--features src/test/resources/features/placeValidations.feature"
```

### To run multiple features, use the following command:
```bash
mvn clean install -Dcucumber.options="--features src/test/resources/features/placeValidations.feature,src/test/resources/features/Example.feature"
```

### To run scenarios with Tag's, use the following command:
```bash
mvn clean install -Dcucumber.options="--tags @Regression"
```

### To run features with Tag's, use the following command:
```bash
mvn clean install -Dcucumber.options="--features src/test/resources/features/placeValidations.feature --tags @Regression"
```

## Jenkins CI/CD
### Report Management
  It is recommended to create a separate folder for storing test reports and generate a sub-folder with a time-stamp for each run in the Jenkins pipeline. This will keep your reports organized and traceable over time.
### Automation with Perl Scripts
  Use a Perl script to:
  - Automatically create a new folder with a time-stamp
  - Move the generated Serenity report files into this sub-folder after each test run
### Jenkins Post-Build Step
  Invoke the Perl script as a Post-Build Action in your Jenkins pipeline, ensuring that the reports are properly archived after every execution.
  
### Basic steps for configuration
#### General Section:
 Select "This project is parameterized" and set below parameters.
1. For 1st parameter, select String parameter and set below details:
 - Name: Features
 - Default value: src/test/resources/features
 - Description: -- Pass the features path here by separated coma (,). -- By default, it will pick up all features.
2. For 2nd parameter, select choice parameter and set below details:
 - Name: Tags
 - Choices: Regression, Smoke, Sanity
 - Description: -- Choose the tags. By default Regression
#### Build Section:
1. For Root POM, give as "pom.xml"
2. For Goals and Options, use the following command:
```bash
clean verify -Dcucumber.options="--features ${Features} --tags @${Tags}"
```
3. Go to "Advanced" and check the "use custom workspace". Add project directory path.

Note: Add project path in the custom workspace field and Also remainings as per requirements.
