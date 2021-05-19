package it.beije.makemake.util;

import it.beije.makemake.entity.User;

public class EcommerceUtil {
	public static String getDisplayName(User user) {
		if (user.getName() != null) {
			return user.getName();
		} else {
			return user.getUsername();
		}
	}
}
