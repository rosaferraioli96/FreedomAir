package connessioneDB;

import java.sql.SQLException;

public interface ConstantsDB {
	
	public enum ConfigurazioneDB {

		SERVER("jdbc:mysql://localhost"),
		PORT("3306"),
		NOMEDB("FreedomAir"),
		USERNAME("Freedom.user"),
		PASSWORD("rootroot");

		private String value;

		public void setValue(String value) {
			this.value = value;
		}

		public String getValue() {
			return value;
		}

		private ConfigurazioneDB(String value) {

			this.value = value;
		}
	}
	
}
