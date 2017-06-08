package com.shoppingcart.backend1.DAO;

import java.util.List;

import com.shoppingcart.backend1.model.User;

public interface UserDAO {
	 boolean addUser(User u);
		List<User>getAllUser();

		public boolean updateUser(User u);
		public boolean deleteUser(String id);
		public User getUserId(String id);

}
