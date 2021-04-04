package com.alphagfx.testrail;

import org.json.JSONObject;

public interface Status extends JsonReadable {

	int id();


	class Smart implements Status {
		private final Status status;


		public Smart(Status status) {
			this.status = status;
		}


		@Override
		public int id() {
			return status.id();
		}

		public boolean isFinal() {
			return json().getBoolean("is_final");
		}

		public boolean isSystem() {
			return json().getBoolean("is_system");
		}

		public boolean isUntested() {
			return json().getBoolean("is_untested");
		}

		public String label() {
			return json().getString("label");
		}

		public String name() {
			return json().getString("name");
		}

		@Override
		public JSONObject json() {
			return status.json();
		}
	}
}
