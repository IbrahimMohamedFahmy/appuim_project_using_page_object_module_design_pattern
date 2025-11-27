# 🧪 Appium E2E Testing Project – General Store Automation (POM Design Pattern)

## 📌 Overview
This project is an Appium End-to-End Automation Framework implemented using the Page Object Model (POM) Design Pattern. It automates the General Store Android app, covering major flows including Sign-In, Add to Cart, and Cart validation. Both Happy and Sad scenarios are implemented, with reusable components for scalability and maintainability.

```
project-root
├── src
│   ├── main
│   │   ├── java
│   │   │   └── PageObjects
│   │   │       ├── P01_SignIn.java
│   │   │       ├── P02_AddToCart.java
│   │   │       └── P03_Cart.java
│   │   └── resources
│   │       ├── General-Store.apk
│   │       ├── chromedriver_mac64
│   │       └── TestData.json
│   └── test
│       ├── java
│       │   ├── SetUp
│       │   │   ├── Listeners.java
│       │   │   └── SuperClass.java
│       │   └── TestCases
│       │       ├── T01_SignIn.java
│       │       ├── T02_AddToCart.java
│       │       └── T03_Cart.java
├── TestNG_AllScenarios.xml
├── TestNG_HappyScenarios.xml
├── TestNG_SadScenarios.xml
├── pom.xml
├── .gitignore
└── .idea

```

⚙️ Installation and Setup

1️⃣ Clone the repository

git clone https://github.com/IbrahimMohamedFahmy/appuim_project_using_page_object_module_design_pattern
cd appuim_project_using_page_object_module_design_pattern


2️⃣ Install dependencies
Make sure you have Java, Maven, and Appium installed. Then run:

mvn clean install


3️⃣ Run the tests
You can run all scenarios via TestNG XML files:

mvn test -DsuiteXmlFile=TestNG_AllScenarios.xml


🧠 Design Pattern: Page Object Model (POM)

Each screen/page in the app has a dedicated Page Object class containing all relevant methods (e.g., P01_SignIn, P02_AddToCart).

Benefits of POM:

Reusability

Easier maintenance

Scalability without breaking other flows

SetUp/SuperClass.java handles common Appium setup and teardown.
SetUp/Listeners.java manages reporting and logging.

resources/TestData.json contains test data (username, passwords, product names) to separate data from code.

🧾 Reporting

Test execution reports are generated automatically using TestNG listeners.

be integrated with ExtentReports  for HTML-based reporting.

💡 Best Practices Followed

Separation of Page Objects and Test Cases

Use of TestNG XMLs for test suite management (All, Happy, Sad scenarios)

Reusable setup/teardown in SuperClass.java

Externalized test data in JSON file

Clear test case naming (T01, T02, …)

Includes both Happy and Sad scenarios for complete coverage

🧑‍💻 Author
Engineer Ibrahim Omran – QA Automation Engineer
Passionate about software quality, mobile test automation, and continuous improvement.

📅 Last Updated
November 2025
