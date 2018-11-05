package com.dulp.xyz.common.access;

import com.dulp.xyz.pojo.User;

public class UserContext {
	
	private static ThreadLocal<User> userHolder = new ThreadLocal<>();
	
	public static void setUser(User user) {
		userHolder.set(user);
	}
	
	public static User getUser() {
		return userHolder.get();
	}

}
