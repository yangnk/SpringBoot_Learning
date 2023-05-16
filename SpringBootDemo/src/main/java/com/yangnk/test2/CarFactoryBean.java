package com.yangnk.test2;

import org.springframework.beans.factory.FactoryBean;

public class CarFactoryBean implements FactoryBean<Car> {
    private String carInfo ;


    public String getCarInfo(){
        return  this.carInfo;
    }

    public void setCarInfo (String carInfo){
        this.carInfo = carInfo;
    }

    @Override
    public Car getObject() throws Exception {
        Car car = new  Car();
        String[] infos = carInfo.split(",");
        car.setBrand(infos[0]);
        car.setMaxSpeed(Integer.valueOf(infos[1]));
        car.setPrice(Double.valueOf(infos[2]));
        return  car;
    }

    @Override
    public Class<?> getObjectType() {
        return Car.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }

}
