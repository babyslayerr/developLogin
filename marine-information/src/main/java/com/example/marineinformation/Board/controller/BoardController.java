package com.example.marineinformation.Board.controller;

import com.example.marineinformation.Auth.annotation.Login;
import com.example.marineinformation.Board.model.BoardModel;
import com.example.marineinformation.Board.service.BoardService;
import com.example.marineinformation.entities.MemberEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/board")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/{seq}")
    public BoardModel selectBoard(@PathVariable Long seq){
        return boardService.selectBoard(seq);
    }

    @PostMapping
    public void createBoard(@Login MemberEntity member , @RequestBody BoardModel boardModel){
        boardService.createBoard(boardModel);
    }

    @DeleteMapping
    public void deleteBoard(HttpServletRequest request){
        Long boardId = Long.parseLong(request.getHeader("BoardId"));
        boardService.deleteBoard(boardId);
    }

    @PutMapping
    public void updateBoard(@RequestBody BoardModel boardModel){
        boardService.updateBoard(boardModel);
    }

    // get List
}
