package org.bs.web.pojo.movie;

import java.io.Serializable;

/**
 * @author Lenovo
 * @title: MoviePerformerBean
 * @projectName blue-sky-web
 * @description: TODO
 * @date 2019/6/1711:03
 */
public class MoviePerformerBean implements Serializable {

    private static final long serialVersionUID = -2901904360774581613L;

    private Integer id;

    private Integer movieId;

    private Integer performerId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    public Integer getPerformerId() {
        return performerId;
    }

    public void setPerformerId(Integer performerId) {
        this.performerId = performerId;
    }
}
