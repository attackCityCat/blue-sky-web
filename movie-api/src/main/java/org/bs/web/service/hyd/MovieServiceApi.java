package org.bs.web.service.hyd;


import org.bs.web.pojo.movie.HitMovies;
import org.bs.web.pojo.movie.PaiqiBean;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface MovieServiceApi {

    @RequestMapping(value = "/hyd/movie/saveMovie")
    Integer saveMovie(@RequestBody PaiqiBean paiqiBean);

    @RequestMapping(value = "/hyd/movie/findMoviePaiqi")
    List<PaiqiBean> findMoviePaiqi(@RequestParam("movieId") Integer movieId);

    @RequestMapping(value = "/hyd/findMoviesDetail")
    HitMovies findMoviesDetail(@RequestParam(value = "id")Integer id);

    @RequestMapping(value = "/hyd/page/toDetail")
    List<PaiqiBean> findPaiQiById(@RequestParam("id") Integer id);

    @RequestMapping(value = "/hyd/findHitMovies")
    List<HitMovies> findHitMovies();

    @RequestMapping(value = "/hyd/findPaiqiByIdAndByTime")
    List<PaiqiBean> findPaiqiByIdAndByTime(@RequestParam(value = "id") Integer id);
}
