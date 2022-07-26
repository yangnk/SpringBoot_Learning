package com.yangnk.test;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Import({TestA.class})
@Configuration
public class ImportConfig {
}
