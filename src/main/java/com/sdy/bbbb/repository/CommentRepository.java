package com.sdy.bbbb.repository;

import com.sdy.bbbb.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query(value = "select '*' from Comment join fetch Comment.post")
    Optional<Comment> findCommentById(Long id);

}
