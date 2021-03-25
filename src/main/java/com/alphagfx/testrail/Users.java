package com.alphagfx.testrail;

public interface Users {

	User get(int id);

	// TODO: 3/26/21 Add get_current_user API method
	// TODO: 3/26/21 ? Add get_user_by_email ?

	Iterable<User> list(/* TODO: 3/26/21 project_id filter may be here */);
}
