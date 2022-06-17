package service;

import java.util.List;

import org.springframework.stereotype.Component;

import model.Car;
import dao.CarDao;
import dao.CarDaoImp;

@Component
public class CarService {
	
	private static CarDao carDao;
	
	public CarService() {
		if (carDao == null) {
			carDao = new CarDaoImp();
		}
	}
	
	public List<Car> getCars(int amount) {
		return carDao.getCars().stream().limit(amount).toList();
	}
}
