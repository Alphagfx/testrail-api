package com.alphagfx.testrail;

import org.json.JSONObject;

public interface User extends JsonReadable {

	TestRail testrail();


	int id();


	class Smart implements User {

		private final User user;


		public Smart(User user) {
			this.user = user;
		}


		@Override
		public TestRail testrail() {
			return user.testrail();
		}

		@Override
		public int id() {
			return user.id();
		}

		public String email() {
			return json().getString("email");
		}

		public boolean isActive() {
			return json().getBoolean("is_active");
		}

		public String name() {
			return json().getString("name");
		}

		public int roleId() {
			return json().getInt("role_id");
		}

		public String role() {
			return json().getString("role");
		}

		@Override
		public JSONObject json() {
			return user.json();
		}
	}
}
