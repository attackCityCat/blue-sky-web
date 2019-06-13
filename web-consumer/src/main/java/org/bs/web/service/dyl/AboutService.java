package org.bs.web.service.dyl;


import org.bs.web.pojo.MovieBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "web-provider")
public interface AboutService {

    @RequestMapping(value="/queryMovieByName/{name}")
    MovieBean queryMovieByName(@RequestParam(value = "name") String name);
}
