package org.bs.web.service.hyd;

import org.bs.web.pojo.movie.MovieBean;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@FeignClient(value = "web-provider")
public interface MovieService extends MovieServiceApi {
    @RequestMapping("/hyd/findMovieBeanList")
    List<MovieBean> findMovieBeanList();
}
