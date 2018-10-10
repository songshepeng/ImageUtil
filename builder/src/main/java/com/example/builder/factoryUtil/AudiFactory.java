package com.example.builder.factoryUtil;

/**
 * Created by baidu on 2018/9/27.
 */

public  abstract class AudiFactory {
  public abstract <T extends AudiCar> T createAudiFactory(Class<T> clz);
}
