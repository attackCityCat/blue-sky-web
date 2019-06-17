package org.bs.web.pojo.movie;

import java.io.Serializable;
import java.util.Date;

public class StartAndEndBean implements Serializable {

    private static final long serialVersionUID = -5387979491926340051L;
    private Date start;
    private Date end;

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }
}
