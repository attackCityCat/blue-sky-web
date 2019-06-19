package org.bs.web.service.hyd;


import org.bs.web.pojo.movie.PaiqiBean;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieServiceApi {

    @RequestMapping(value = "/hyd/movie/saveMovie")
    Integer saveMovie(@RequestBody PaiqiBean paiqiBean);

    @RequestMapping(value = "/hyd/movie/findMoviePaiqi")
    List<PaiqiBean> findMoviePaiqi(@RequestParam("movieId") Integer movieId);

    @RequestMapping(value = "/hyd/page/toDetail")
    List<PaiqiBean> findPaiQiById(@RequestParam("id") Integer id);
}
