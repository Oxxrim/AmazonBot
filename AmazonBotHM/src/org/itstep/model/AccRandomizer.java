package org.itstep.model;

public class AccRandomizer {

	public static String getName() {

		String[] names = { "Dima", "Bogdan", "Denys", "Vika", "Vlad", "Anton", "Gleb", "Alex", "Artem", "Nika" };
		int rndInt = ((int) (Math.random() * 10));
		String name = names[rndInt] + rndInt * (int) (Math.random() * (1000000 - 10000));
		return name;
	}

	public static String getEmail() {
		String email = "";
		int rndInt = 10000 + (int) (Math.random() * (1000000 - 10000));
		email = getName() + "." + rndInt + "@" + getDomen();
		return email;
	}

	private static String getDomen() {
		int rndInt = ((int) (Math.random() * 5));
		switch (rndInt) {
		case 0:
			return "gmail.com";
		case 1:
			return "ukr.net";
		case 2:
			return "yandex.ru";
		case 3:
			return "bigmir.net";
		case 4:
			return "mail.ua";
		default:
			return "mail.ru";
		}
	}

	public static String getPassword() {
		String password = getName() + String.valueOf(10000 + (int) (Math.random() * (100000 - 10000)));
		return password;
	}
}
