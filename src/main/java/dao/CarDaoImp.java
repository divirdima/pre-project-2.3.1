package dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import model.Car;

public class CarDaoImp implements CarDao{

	private static List<Car> cars;
	
	public CarDaoImp() {
		if (cars == null) {
			cars = Arrays.asList(new Car(), new Car(), new Car(), new Car(), new Car());
		}
	}
	
	@Override
	public List<Car> getCars() {
		return cars;
	}

}
