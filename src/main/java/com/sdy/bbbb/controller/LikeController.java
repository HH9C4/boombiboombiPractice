package com.sdy.bbbb.controller;

import com.sdy.bbbb.config.UserDetailsImpl;
import com.sdy.bbbb.dto.request.LikeRequestDto;
import com.sdy.bbbb.dto.response.GlobalResponseDto;
import com.sdy.bbbb.service.LikeService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/likes/{postId}")
public class LikeController {
    private final LikeService likeService;

    @ApiOperation(value = "좋아요 생성", notes = "설명")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public GlobalResponseDto createLike(@PathVariable Long postId,
                                        @ModelAttribute LikeRequestDto requestDto,
                                        @ApiIgnore @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likeService.createLike(postId, requestDto.getLiketLevel(),  userDetails.getAccount());
    }

    @ApiOperation(value = "좋아요 삭제", notes = "설명")
    @DeleteMapping
    public GlobalResponseDto deleteLike(@PathVariable Long postId,
                                        @ApiIgnore @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likeService.deleteLike(postId, userDetails.getAccount());
    }
}
