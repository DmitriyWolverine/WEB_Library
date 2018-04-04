package by.htp.login.dao.factory;

public interface DaoFactory <T>{
	T getDataBaseHandler(String parameter);
}
