package com.zhengshun.touch.api.domain;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * 游戏数据
 */

@Document(collection="game_data")
public class GameData implements Serializable {

    @Field(value="id")
    private Long id;

    @Field(value="user_id")
    private Long userId;
    @Field(value="schedule_data")
    private Map<String, String> scheduleData;
    @Field(value="card_data")
    private Map<String, String> cardData;
    @Field(value="status")
    private Integer status;
    @Field(value="delete_flag")
    private Integer deleteFlag;
    @Field(value="data_version")
    private Integer dataVersion;
    @Field(value="create_date")
    private Date createDate;
    @Field(value="update_date")
    private Date updateDate;
    @Field(value="version")
    private String version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Integer getDataVersion() {
        return dataVersion;
    }

    public void setDataVersion(Integer dataVersion) {
        this.dataVersion = dataVersion;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Map<String, String> getScheduleData() {
        return scheduleData;
    }

    public void setScheduleData(Map<String, String> scheduleData) {
        this.scheduleData = scheduleData;
    }

    public Map<String, String> getCardData() {
        return cardData;
    }

    public void setCardData(Map<String, String> cardData) {
        this.cardData = cardData;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}