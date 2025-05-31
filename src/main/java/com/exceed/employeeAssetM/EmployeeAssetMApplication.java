package com.exceed.employeeAssetM;

import io.github.cdimascio.dotenv.Dotenv;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main entry point for the Employee Asset Management Spring Boot application.
 * Loads environment variables from a .env file and injects them into the system environment.
 */
@SpringBootApplication
public class EmployeeAssetMApplication {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeAssetMApplication.class);

	public static void main(String[] args) {

		// Load environment variables from .env
		Dotenv dotenv = loadDotenv();

		// Set DB environment variables for Spring Boot
		setDatabaseEnvironmentVariables(dotenv);

		// Start the Spring Boot application
		SpringApplication.run(EmployeeAssetMApplication.class, args);
	}

	/**
	 * Load the environment variables from the .env file.
	 * @return Dotenv instance containing the loaded environment variables.
	 */
	private static Dotenv loadDotenv() {
		try {
			Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();
			logger.info(".env file loaded successfully.");
			return dotenv;
		} catch (Exception e) {
			logger.error("Failed to load .env file", e);
			throw new RuntimeException("Could not load .env file", e);
		}
	}

	/**
	 * Sets necessary environment variables required by Spring Boot
	 * @param dotenv Dotenv instance containing loaded variables.
	 */
	private static void setDatabaseEnvironmentVariables(Dotenv dotenv) {
		String dbUrl = dotenv.get("DB_URL");
		String dbUsername = dotenv.get("DB_USERNAME");
		String dbPassword = dotenv.get("DB_PASSWORD");

		if (dbUrl == null || dbUsername == null || dbPassword == null) {
			logger.error("Missing required environment variables: DB_URL, DB_USERNAME, or DB_PASSWORD");
			throw new IllegalStateException("Required DB environment variables are missing.");
		}

		System.setProperty("DB_URL", dbUrl);
		System.setProperty("DB_USERNAME", dbUsername);
		System.setProperty("DB_PASSWORD", dbPassword);
		logger.info("Database environment variables set successfully.");
	}
}
