package com.alphagfx.testrail;

import org.json.JSONObject;

public interface Priority extends JsonReadable {

	int id();


	class Smart implements Priority {

		private final Priority priority;


		public Smart(Priority priority) {
			this.priority = priority;
		}


		@Override
		public int id() {
			return priority.id();
		}

		public boolean isDefault() {
			return json().getBoolean("is_default");
		}

		public String name() {
			return json().getString("name");
		}

		public int priority() {
			return json().getInt("priority");
		}

		public String shortName() {
			return json().getString("short_name");
		}

		@Override
		public JSONObject json() {
			return priority.json();
		}
	}
}
