package com.bujak.kegtracker.statistics;

public class Statistics {

    private Integer kegsCount;
    private Integer goldCount;
    private Integer silverCount;
    private Integer blueCount;
    private Integer whiteCount;

    public Statistics(Integer goldCount, Integer silverCount, Integer blueCount, Integer whiteCount, Integer kegsCount) {
        this.goldCount = goldCount;
        this.silverCount = silverCount;
        this.blueCount = blueCount;
        this.whiteCount = whiteCount;
        this.kegsCount = kegsCount;
    }

    public Integer getKegsCount() {
        return kegsCount;
    }

    public Integer getGoldCount() {
        return goldCount;
    }

    public Integer getSilverCount() {
        return silverCount;
    }

    public Integer getBlueCount() {
        return blueCount;
    }

    public Integer getWhiteCount() {
        return whiteCount;
    }

}
