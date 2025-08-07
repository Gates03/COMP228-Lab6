# COMP228 – Lab 6: Lotto Game 🎲

This is a JavaFX application built for COMP228 Lab 6. It simulates a Lotto game using multithreading, SecureRandom number generation, and Oracle database integration.

## 🎯 Features

- JavaFX GUI with:
  - Input fields for **Min**, **Max**, and **Number of Balls**
  - Results displayed in a scrollable text area
- Uses **SecureRandom** to generate unique numbers
- Runs up to **5 lotto simulations** using **threads**
- Stores each run in an **Oracle database**
- Implements **HashSet** to ensure number uniqueness

## 💾 Technologies Used

- Java 21
- JavaFX 21
- Oracle SQL (via JDBC)
- IntelliJ IDEA

## 📂 Project Structure

- `Main.java` – Launches the JavaFX application
- `LottoController.java` – Handles UI logic and multithreading
- `LottoGame.java` – Lotto logic using SecureRandom
- `DatabaseUtil.java` – Database connection and insertion logic

## 🛡️ Security Note

🔒 Oracle DB credentials are redacted for public sharing.  
Update `DatabaseUtil.java` with your own credentials to run locally.


---

