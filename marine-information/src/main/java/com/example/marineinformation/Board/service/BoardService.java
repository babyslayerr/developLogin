package com.example.marineinformation.Board.service;

import com.example.marineinformation.Board.model.BoardModel;
import com.example.marineinformation.entities.BoardEntity;
import com.example.marineinformation.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardModel selectBoard(Long seq) {
        return new BoardModel(boardRepository.findById(seq).orElse(null));
    }

    public void createBoard(BoardModel boardModel){
        boardRepository.save(boardModel.to());
    }

    public void deleteBoard(Long boardId) {
        BoardEntity boardEntity = boardRepository.findById(boardId).get();
        boardRepository.delete(boardEntity);
    }

    public void updateBoard(BoardModel boardModel) {
        BoardEntity findBoard = boardRepository.findById(boardModel.getBoardSeq()).get();
        findBoard.updateBoard(boardModel.getTitle(),boardModel.getContent());
    }
}
