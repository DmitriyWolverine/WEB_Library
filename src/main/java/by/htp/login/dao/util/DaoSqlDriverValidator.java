package by.htp.login.dao.util;

import static by.htp.login.dao.util.DaoSqlRequestsPool.DRIVER_SQL;

public class DaoSqlDriverValidator {
	private DaoSqlDriverValidator() {}
	public static void loadDriver() {
		try {
			Class.forName(DRIVER_SQL);	
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
	}
}
