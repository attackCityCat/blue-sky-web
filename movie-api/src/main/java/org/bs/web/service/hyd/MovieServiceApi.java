package org.bs.web.service.hyd;


import org.bs.web.pojo.movie.PaiqiBean;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

public interface MovieServiceApi {

    @RequestMapping(value = "/hyd/movie/saveMovie")
    Integer saveMovie(@RequestBody PaiqiBean paiqiBean);

    @RequestMapping(value = "/hyd/movie/findMoviePaiqi",method = RequestMethod.GET)
    List<PaiqiBean> findMoviePaiqi();
}
