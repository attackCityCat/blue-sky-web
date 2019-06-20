package org.bs.web.dao.ljw;

import org.bs.web.pojo.movie.MovieBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @author Lenovo
 * @title: MovieRepository
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1820:58
 */
public interface MovieRepository extends ElasticsearchRepository<MovieBean,Integer> {
}
