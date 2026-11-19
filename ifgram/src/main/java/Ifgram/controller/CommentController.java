package Ifgram.controller;

import Ifgram.dto.CommentRequest;
import Ifgram.dto.CommentResponse;
import Ifgram.service.CommentService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    // Criar comentário
    @PostMapping
    public CommentResponse criar(
            @Valid @RequestBody CommentRequest request) {
        return commentService.criar(request);
    }

    // Listar comentários de um post
    @GetMapping("/post/{postId}")
    public List<CommentResponse> listarPorPost(
            @PathVariable Long postId) {
        return commentService.listarPorPost(postId);
    }

    // Deletar comentário
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        commentService.deletar(id);
    }
}
