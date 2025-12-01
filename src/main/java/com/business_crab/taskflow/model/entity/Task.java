package com.business_crab.taskflow.model.entity;

import java.time.LocalDateTime;

import com.business_crab.taskflow.model.enums.Priority;
import com.business_crab.taskflow.model.enums.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id" , nullable=false)
    private Long id;
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id" , nullable=false)
    private Project projectId;
    @Column(name = "title" , nullable=false)
    private String title;
    @Column(name = "description" , nullable=true)
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "status" , nullable=false)
    private Status status;
    @Enumerated(EnumType.STRING)
    @Column(name = "priority" , nullable=false)
    private Priority priority;
    @Column(name = "created_at" , nullable=false)
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreated() {
        createdAt = LocalDateTime.now();
    }
}