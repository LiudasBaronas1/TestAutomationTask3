package Data;

import java.util.Random;

public class UserCredentials {
	private String firstName;
    private String lastName;
    private static String email;
    private static String password;

    private static final String[] FIRST_NAMES = {"Jonas", "Antanas", "Petras", "Lukas", "Mantas"};
    private static final String[] LAST_NAMES = {"Kazlauskas", "Petraitis", "Jankauskas", "Balčiūnas", "Stankūnas"};
    private static final String EMAIL_DOMAIN = "@example.com";
    private static final String DEFAULT_PASSWORD = "RandomPass@123";

    public UserCredentials() {
        Random random = new Random();
        this.firstName = FIRST_NAMES[random.nextInt(FIRST_NAMES.length)];
        this.lastName = LAST_NAMES[random.nextInt(LAST_NAMES.length)];
        this.email = firstName.toLowerCase() + "." + lastName.toLowerCase() + random.nextInt(1000) + EMAIL_DOMAIN;
        this.password = DEFAULT_PASSWORD;
    }

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public static String getEmail() {
		return email;
	}

	public static String getPassword() {
		return password;
	}

}
