# Selenium Automation Framework – Java

This is a modular and scalable Selenium automation framework built using Java, TestNG, Maven, and the Page Object Model (POM) design pattern. The project is designed to automate end-to-end functional testing for web applications with clean code structure, robust reporting, and easy maintainability.

<br>

## 🚀 Features

- Page Object Model (POM) structure
- Cross-browser test support using Selenium WebDriver
- Test execution management with TestNG
- Excel-based Data-Driven Testing (Apache POI)
- Extent Reports integration for rich HTML reports
- Screenshot capture on test failure and success
- Configuration management via `config.properties`

<br>

## 🛠️ Technologies Used

- Java (OpenJDK 17)
- Selenium WebDriver
- TestNG
- Maven
- Extent Reports
- Apache POI (for Excel data reading)
- Page Object Model (POM)

<br>

## 🧪 How to Run the Tests

1. **Clone the Repository**
   
   ```bash
   git clone https://github.com/Sairaj-Thorat/selenium-automation-framework-java.git
   cd selenium-automation-framework-java

3. **Install Dependencies**
Make sure Maven is installed. Then run:

   ```bash
   mvn clean install

4. **Execute Test Suite**
   
   ```bash
   mvn test

6. **View Test Report**  
After execution, open:

   ```lua
   extent-test-output/ExtentReport.html

<br>

## 🧾 Configuration
Update config.properties to set:
- Browser type (chrome, edge, etc.)
- Base URL
- Timeout settings
- Use testdata.xlsx (if present) for data-driven test inputs.

<br>

## 🤝 Contributing
Contributions are welcome! Feel free to fork this repo and submit a pull request with improvements or new test cases.
