package com.seneca.senecademo.db;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

@Entity(tableName = "user_data")
//@Entity
public class Pojo implements Serializable {

        @PrimaryKey
        @NonNull
        @SerializedName("id")
        @Expose
        private Double id;
        @SerializedName("isImportant")
        @Expose
        private Boolean isImportant;
        @SerializedName("picture")
        @Expose
        private String picture;
        @SerializedName("from")
        @Expose
        private String from;
        @SerializedName("subject")
        @Expose
        private String subject;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("timestamp")
        @Expose
        private String timestamp;
        @SerializedName("isRead")
        @Expose
        private Boolean isRead;

        public Double getId() {
            return id;
        }

        public void setId(Double id) {
            this.id = id;
        }

        public Boolean getIsImportant() {
            return isImportant;
        }

        public void setIsImportant(Boolean isImportant) {
            this.isImportant = isImportant;
        }

        public String getPicture() {
            return picture;
        }

        public void setPicture(String picture) {
            this.picture = picture;
        }

        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public Boolean getIsRead() {
            return isRead;
        }

        public void setIsRead(Boolean isRead) {
            this.isRead = isRead;
        }

    public void setFrom(Integer valueOf) {
    }
}

