package org.bs.web.dao.ljw;

import org.bs.web.pojo.MovieBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchCrudRepository;

/**
 * @author Lenovo
 * @title: MovieRepository
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1820:58
 */
public interface MovieRepository extends ElasticsearchCrudRepository<MovieBean,Integer> {
}
