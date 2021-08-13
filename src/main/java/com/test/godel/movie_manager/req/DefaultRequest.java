package com.test.godel.movie_manager.req;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class DefaultRequest {

    private Long directorId;
    private String directorLastName;
    @DateTimeFormat(pattern = "ddMMyyyy")
    private LocalDate releaseFromDate;
    @DateTimeFormat(pattern = "ddMMyyyy")
    private LocalDate releaseUntilDate;

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }

    public void setReleaseFromDate(LocalDate releaseFromDate) {
        this.releaseFromDate = releaseFromDate;
    }

    public LocalDate getReleaseFromDate() {
        return releaseFromDate;
    }

    public void setReleaseUntilDate(LocalDate releaseUntilDate) {this.releaseUntilDate = releaseUntilDate;    }

    public LocalDate getReleaseUntilDate() {return releaseUntilDate;}

    public void setDirectorLastName(String directorLastName) {
        this.directorLastName = directorLastName;
    }

    public String getDirectorLastName() {
        return directorLastName;
    }


}
