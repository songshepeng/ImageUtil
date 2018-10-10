package com.example.builder.factoryUtil;

/**
 * Created by baidu on 2018/9/27.
 */

public class AudiCarFactory extends AudiFactory {
    @Override
    public <T extends AudiCar> T createAudiFactory(Class<T> clz) {
        AudiCar audiCar =null;
        try {
            try {
                audiCar = (AudiCar) Class.forName(clz.getName()).newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return (T) audiCar;
    }
}
