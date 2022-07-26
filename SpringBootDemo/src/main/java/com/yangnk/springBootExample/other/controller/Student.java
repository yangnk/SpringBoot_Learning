package com.yangnk.springBootExample.other.controller;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component
@Data
@PropertySource(value = "student.properties")

public class Student {
    @Value("${name}")
    String name;
    @Value("${age}")
    String age;
}
