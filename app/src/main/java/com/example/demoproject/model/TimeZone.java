package com.example.demoproject.model;

public class TimeZone {
    private String id;
    private String is_dst;
    private String timezone_abbr;
    private String timezone_identifier;
    private int utc_offset_sec;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIs_dst() {
        return is_dst;
    }

    public void setIs_dst(String is_dst) {
        this.is_dst = is_dst;
    }

    public String getTimezone_abbr() {
        return timezone_abbr;
    }

    public void setTimezone_abbr(String timezone_abbr) {
        this.timezone_abbr = timezone_abbr;
    }

    public String getTimezone_identifier() {
        return timezone_identifier;
    }

    public void setTimezone_identifier(String timezone_identifier) {
        this.timezone_identifier = timezone_identifier;
    }

    public int getUtc_offset_sec() {
        return utc_offset_sec;
    }

    public void setUtc_offset_sec(int utc_offset_sec) {
        this.utc_offset_sec = utc_offset_sec;
    }
}
