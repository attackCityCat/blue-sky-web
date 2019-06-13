package org.bs.web.service;


import org.springframework.web.bind.annotation.RequestMapping;

public interface MovieService {

    @RequestMapping(value = "test")
    String test();
}
