AutomationExerciseProject
========================

Project Description
-------------------
AutomationExerciseProject is a UI test automation project created for practice purposes.
The project covers basic functionalities of the Automation Exercise web application.

Tested functionalities include:
- Adding product to cart
- Removing product from cart
- Searching products
- Sending message via Contact Us page
- Writing a product review

Application URL:
https://automationexercise.com/

Test Environment
----------------
- Operating System: Windows 10
- Browser: Google Chrome
- ChromeDriver: Managed using WebDriverManager

Technologies Used
-----------------
- Java 8+
- Selenium WebDriver
- TestNG
- Maven
- ChromeDriver
- WebDriverManager

Project Structure
-----------------
The project is implemented using Page Object Model (POM) design pattern.

Main packages:
- base – WebDriver setup and configuration
- pages – Page Object classes with constructors and getters
- tests – Test classes with TestNG annotations

Test Scenarios
--------------
1. Add product to cart
2. Remove product from cart
3. Search product
4. Send message from Contact Us page
5. Write review for product

How to Run Tests
----------------
1. Using Maven:
   > mvn test
2. Or directly from IntelliJ IDEA

What is practiced in this project
---------------------------------
- UI test automation with Selenium
- Page Object Model (POM)
- TestNG framework
- Working with forms and validations