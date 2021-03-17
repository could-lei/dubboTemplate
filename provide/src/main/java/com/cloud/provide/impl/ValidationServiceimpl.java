package com.cloud.provide.impl;

import com.cloud.cloud.ValidationParameter;
import com.cloud.cloud.ValidationService;
import org.apache.dubbo.config.annotation.Service;

@Service(version="1.0.0",protocol = "dubbo",registry = "test1",group = "group1",dynamic = false,cache = "lru",validation = "true")
public class ValidationServiceimpl implements ValidationService
{
    @Override
    public void save(ValidationParameter parameter) {

    }

    @Override
    public void update(ValidationParameter parameter) {

    }

    @Override
    public void delete(int id) {

    }
}
