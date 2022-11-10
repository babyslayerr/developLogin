package com.example.marineinformation.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BoardEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardSeq;
    @Column
    private String title;
    @Column
    private String content;

    public void updateBoard(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
