package org.bs.web.pojo.movie;

import java.io.Serializable;
import java.util.Date;

public class MovieTimeBean implements Serializable {

    private static final long serialVersionUID = 7840050776247773441L;

    private Integer id;

    private String startDate;

    private String endDate;

    private Integer movieId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}
