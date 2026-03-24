package model;

public class Movies {
    private int id;
    private String title;
    private int year;
    private float duration;
    private String genre;
    private String studio;
    private float rating;
    private String poster;
    private String synopsis;

    public Movies(String title, int year, float duration, String genre,
                  String studio, float rating, String poster, String synopsis) {
        this.title = title;
        this.year = year;
        this.duration = duration;
        this.genre = genre;
        this.studio = studio;
        this.rating = rating;
        this.poster = poster;
        this.synopsis = synopsis;
    }

    public int getId()
        { return id;
    }

    public String getTitle()
        { return title;
    }

    public void setTitle(String title)
        { this.title = title;
    }

    public int getYear()
        { return year;
    }

    public void setYear(int year)
        { this.year = year;
    }

    public float getDuration()
        { return duration;
    }

    public void setDuration(float duration)
        { this.duration = duration;
    }

    public String getGenre()
        { return genre;
    }

    public void setGenre(String genre)
        { this.genre = genre;
    }

    public String getStudio()
        { return studio;
    }

    public void setStudio(String studio)
        { this.studio = studio;
    }

    public float getRating()
        { return rating;
    }

    public void setRating(float rating)
        { this.rating = rating;
    }

    public String getPoster()
        { return poster;
    }

    public void setPoster(String poster)
        { this.poster = poster;
    }

    public String getSynopsis()
        { return synopsis;
    }

    public void setSynopsis(String synopsis)
        { this.synopsis = synopsis;
    }
}