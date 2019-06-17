package org.bs.web.pojo;
import java.io.Serializable;
import java.util.Date;

public class MovieTimeBean implements Serializable {

    private static final long serialVersionUID = 7840050776247773441L;

    private Integer id;

    private Date startDate;

    private Date endDate;

    private Integer movieId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Integer getMovieId() {
        return movieId;
    }

    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }
}