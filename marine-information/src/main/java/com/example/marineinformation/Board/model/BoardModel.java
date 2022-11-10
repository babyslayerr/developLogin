package com.example.marineinformation.Board.model;

import com.example.marineinformation.entities.BoardEntity;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BoardModel {

    private Long boardSeq;
    private String title;
    private String content;

    public BoardModel(BoardEntity boardEntity){
        boardSeq = boardEntity.getBoardSeq();
        title = boardEntity.getTitle();
        content = boardEntity.getContent();
    }

    public BoardEntity to() {
        return BoardEntity.builder()
                .boardSeq(boardSeq)
                .title(title)
                .content(content)
                .build();
    }
}
