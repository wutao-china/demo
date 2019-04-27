package io.magicbank.springboot.repository;

import io.magicbank.springboot.annotation.SecendLevelRepository;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@SecendLevelRepository(value = "mySecendRepossitory")
//@Component(value = "mySecendRepossitory")//使用Component和SecendLevelRepository没有区别，派生性
public class MySecendRepossitory {
}
