package com.task_management_system;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Title can't be blank")
    private String title;

    @NotBlank(message = "Description can't be blank")
    @NotNull(message = "Description must be filled")
    private String description;

    @NotNull(message =  "Status can't be null")
    private Boolean status;


    private LocalDateTime createDate;

    public Task() {
        createDate();
    }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Boolean getStatus() {
            return status;
        }

        public void setStatus(Boolean status) {
            this.status = status;
        }

        public LocalDateTime getCreateDate() {
            return createDate;
        }

        private void createDate() {
            this.createDate = LocalDateTime.now();
        }

        public void setCreateDate(LocalDateTime date){
            this.createDate = date;
        }
}
