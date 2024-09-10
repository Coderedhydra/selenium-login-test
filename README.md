# Automated Testing of Login Screen

## Overview

This project automates the login functionality testing for the web application [Germany is Calling](https://app.germanyiscalling.com/). The project uses **Selenium** and **TestNG** to test both successful and unsuccessful login scenarios.

## Prerequisites

- Java (>= 8)
- Maven (for managing dependencies)
- Chrome WebDriver (or WebDriver for your browser)
- TestNG (unit testing framework)

## Test Cases

### 1. Successful Login

- Test script verifies the login with valid credentials.
- Ensures the user is redirected to the dashboard or another page after a successful login.

### 2. Unsuccessful Login

- Test script verifies the behavior when incorrect credentials are provided.
- Ensures that the appropriate error message is displayed when login fails.

## How to Run the Tests

1. Clone this repository.
2. Install all dependencies by running `mvn clean install`.
3. Ensure that Chrome WebDriver is in your system's PATH or update the path in `LoginTest.java`.
4. Run the test suite using the command: `mvn test`.

## Assumptions

- The selectors used in the tests are based on the following assumptions:
  - Email input field has `id="email"`.
  - Password input field has `id="password"`.
  - Login button has `id="loginButton"`.
  - Error message for invalid login has `id="errorMessage"`.
- The redirection URL after successful login is `/dashboard`.

## Bonus Points Implemented

- Tests for empty field inputs and special character handling can be easily added to this framework.

## Notes

- You can extend these test cases by adding more validations like testing for field-level errors, empty input validation, and invalid email formats.
