package com.yangnk.test;

import org.springframework.boot.context.TypeExcludeFilter;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;

import java.io.IOException;

public class TestTypeExcludeFilter extends TypeExcludeFilter {
    @Override
    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
        if (metadataReader.getClassMetadata().getClassName().equals(MyController1.class)) {
            return true;
        }
        return false;
//        return super.match(metadataReader, metadataReaderFactory);
    }
}
