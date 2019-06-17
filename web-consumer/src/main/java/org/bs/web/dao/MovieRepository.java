package org.bs.web.dao;

import org.bs.web.pojo.MovieBean;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface MovieRepository extends ElasticsearchRepository<MovieBean,Integer> {
}
