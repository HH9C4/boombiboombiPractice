package com.sdy.bbbb.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sdy.bbbb.dto.request.CommentRequestDto;
import com.sdy.bbbb.dto.response.CommentResponseDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Comment extends TimeStamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comment;
    private String commentLevel;
    private boolean isChecked;
    @ManyToOne
    @JoinColumn
    @ApiModelProperty(hidden = true)
    private Account account;
    @ManyToOne
    @JoinColumn
    private Post post;


    public Comment(CommentRequestDto requestDto, Post post, Account account) {
        this.account = account;
        this.post = post;
        this.comment = requestDto.getComment();
        this.commentLevel = requestDto.getCommentLevel();

    }
}
