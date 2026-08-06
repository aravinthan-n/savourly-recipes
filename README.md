# 🍳 FoodCo Recipes Web Application

![Build Status](https://img.shields.io/badge/build-passing-brightgreen.svg)
![Java Version](https://img.shields.io/badge/JDK-25-orange.svg)
![Spring Version](https://img.shields.io/badge/Spring_Framework-6.2.2-blue.svg)
![Cucumber Version](https://img.shields.io/badge/Cucumber_Java-7.21.1-green.svg)
![JUnit Version](https://img.shields.io/badge/JUnit-5.11.4-red.svg)

A modern, full-stack Java web application for managing, filtering, searching, and starring culinary recipes. Built with **Spring MVC 6**, **Java 25**, **Jakarta EE Servlet 6.0**, and backed by comprehensive **Behavior-Driven Development (BDD)** tests using **Cucumber Java 7** and **JUnit 5**.

---

## 📋 Table of Contents

- [🌟 Key Features](#-key-features)
- [🛠️ Technology Stack](#️-technology-stack)
- [📂 Project Structure](#-project-structure)
- [🚀 Getting Started & Test Suite](#-getting-started--test-suite)
- [💻 Running the Web Application Locally](#-running-the-web-application-locally)
  - [Method 1: Embedded Jetty Server](#method-1-running-via-embedded-jetty-server-in-terminal-recommended)
  - [Configuring Server Port](#configuring-server-port)
  - [Customizing Initial Recipe Dataset](#customizing-initial-recipe-dataset)
  - [Method 2: Packaging & Deploying WAR File](#method-2-packaging--deploying-war-file)
  - [Method 3: Running in IDE](#method-3-running-in-ide-intellij-idea--eclipse)
- [🥒 Cucumber Feature Specifications](#-cucumber-feature-specifications)
- [🤝 Contributing & License](#-contributing--license)

---

## 🌟 Key Features

- **Recipe List & Pagination**: Browse recipe listings with support for page navigation and limit controls.
- **Detailed Recipe View**: Inspect cooking times, high-resolution recipe images, and formatted ingredient quantities (e.g., `4 x Chicken Breasts`, `1 tsp Thyme`).
- **Dynamic Search & Filtering**:
  - Search recipes by name or ingredients.
  - Filter recipes by maximum cooking time (e.g. `25 minutes`).
- **User Favorites / Starring System**:
  - Star and unstar recipes per user.
  - Quick filter view to list user's starred recipes.
- **100% In-Memory Test Backend**: Fully isolated state reset per scenario for fast BDD execution without external database dependencies.

---

## 🛠️ Technology Stack

- **Language**: Java 25 (OpenJDK 25)
- **Framework**: Spring Framework 6.2.2 (Spring MVC, Spring AOP, Spring Context)
- **Specification**: Jakarta Servlet API 6.0
- **BDD Testing**: Cucumber Java 7.21.1, Cucumber JUnit Platform Engine
- **Unit Testing & Mocking**: JUnit 5 (JUnit Jupiter 5.11.4), Mockito 5.14.0, ByteBuddy 1.15.11
- **JSON Processing**: Jackson 2.18.2
- **Logging**: SLF4J 2.0.16 & Logback 1.5.16
- **Frontend**: AngularJS, Angular Route, Angular UI Bootstrap, Bootstrap CSS

---

## 📂 Project Structure

```
recipes-web-app/
├── pom.xml                                   # Maven POM configured for JDK 25 & modern dependencies
├── README.md                                 # Project documentation
├── .gitignore                                # Standard git ignore rules
└── src/
    ├── main/
    │   ├── java/co/uk/foodco/recipes/
    │   │   ├── builder/                      # Recipe test data builders
    │   │   ├── controller/                   # Spring MVC REST Controllers
    │   │   ├── model/                        # Domain models (Recipe, Ingredient, User, Recipes)
    │   │   ├── repository/                   # In-memory repository interface & implementation
    │   │   ├── service/                      # Business logic service interfaces & implementation
    │   │   ├── util/                         # Application constants
    │   │   └── web/                          # Spring Web MVC config & Servlet Initializer
    │   ├── resources/                        # Logging configuration
    │   └── webapp/                           # AngularJS frontend UI & static assets
    └── test/
        ├── java/co/uk/foodco/recipes/
        │   ├── cucumber/
        │   │   ├── RunCucumberTest.java      # JUnit 5 Cucumber Test Runner
        │   │   └── RecipeSteps.java          # Cucumber Java Step Definitions
        │   └── service/
        │       └── DefaultRecipesServiceTest.java  # JUnit 5 Unit Tests
        └── resources/
            └── features/                     # Gherkin BDD Feature Files
                ├── filter_recipes.feature    # Search & filtering BDD specs
                ├── recipe.feature            # Detailed recipe view BDD specs
                ├── recipe_list.feature       # Recipe listing & pagination BDD specs
                └── star.feature              # Starring / Favorites BDD specs
```

---

## 🚀 Getting Started & Test Suite

### Prerequisites

- **JDK 25** or higher installed (`java -version`).
- **Apache Maven 3.9+** installed (`mvn -version`).

### Run Test Suite

To compile the project and execute all **18 Cucumber BDD Scenarios** and **JUnit 5 Unit Tests**:

```bash
mvn clean test
```

#### Test Execution Output & HTML Reports
Running tests automatically produces:
- Console output detailing passed Gherkin scenarios.
- Standalone HTML report: `target/cucumber-reports/cucumber.html`
- JSON report: `target/cucumber-reports/cucumber.json`

---

## 💻 Running the Web Application Locally

### Method 1: Running via Embedded Jetty Server in Terminal (Recommended)

1. Open your terminal in the project root directory:
   ```bash
   cd recipes-web-app
   ```

2. Start the application using Jetty Maven plugin (default port `8080`):
   ```bash
   mvn jetty:run
   ```

3. Once the server starts, open your browser and navigate to:
   - **Frontend UI App**: [http://localhost:8080/foodcompany/recipe/](http://localhost:8080/foodcompany/recipe/)
   - **REST API Endpoint**: [http://localhost:8080/foodcompany/foodcompany/recipe](http://localhost:8080/foodcompany/foodcompany/recipe)

---

### Configuring Server Port

You can pass a custom HTTP server port dynamically via the `-Dserver.port` Maven argument:

```bash
# Run application on port 8081
mvn jetty:run -Dserver.port=8081

# Run application on port 9090
mvn jetty:run -Dserver.port=9090
```

When running on port `8081`, access the app at [http://localhost:8081/foodcompany/recipe/](http://localhost:8081/foodcompany/recipe/).

---

### Customizing Initial Recipe Dataset

By default, the server starts with 12 recipes. You can customize the initial total recipes in the system by passing `-DtotalRecipes`:

```bash
# Start with 0 recipes
mvn jetty:run -DtotalRecipes=0

# Start with 1 recipe
mvn jetty:run -DtotalRecipes=1

# Start with 3 recipes
mvn jetty:run -DtotalRecipes=3

# Combine custom port and recipe count
mvn jetty:run -Dserver.port=9090 -DtotalRecipes=5
```

---

### Method 2: Packaging & Deploying WAR File

1. Build the standalone `.war` distribution package:
   ```bash
   mvn clean package
   ```
2. The generated web application archive will be created at:
   `target/foodcompany.war`
3. Deploy `foodcompany.war` into your Servlet container (Tomcat 10+, Jetty 11+, or Payara 6+).

---

### Method 3: Running in IDE (IntelliJ IDEA / Eclipse)

1. Import the project as a **Maven Project**.
2. Configure **JDK 25** as the Project SDK / Java Compiler.
3. Create a new Maven Run Configuration:
   - **Command**: `jetty:run -Dserver.port=8080`
4. Click **Run** or **Debug** to start the local web application server on `http://localhost:8080/foodcompany/recipe/`.

---

## 🥒 Cucumber Feature Specifications

| Feature File | Scenarios Covered |
| :--- | :--- |
| `recipe_list.feature` | No recipes available, Single recipe view, Multiple recipes display, Selected recipe navigation, Pagination controls (10 items/page). |
| `recipe.feature` | Missing recipe error messages, Cooking time display, Image URL mapping, Formatted ingredient quantities. |
| `star.feature` | User creation, Star recipe, Unstar recipe, Empty starred recipes warning, Filter view by starred recipes. |
| `filter_recipes.feature` | Search by name, Search by ingredient, Filter by max cooking time, No matching results handling. |

---

## 🤝 Contributing & License

Developed for **FoodCo Recipes**. Open for development and extension.
