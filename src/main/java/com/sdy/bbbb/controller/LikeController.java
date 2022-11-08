package com.sdy.bbbb.controller;

import com.sdy.bbbb.config.UserDetailsImpl;
import com.sdy.bbbb.dto.response.GlobalResponseDto;
import com.sdy.bbbb.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/likes/{postId}")
public class LikeController {
    private final LikeService likeService;

    @PostMapping
    public boolean createLike(@PathVariable Long postId,
                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likeService.createLike(postId, userDetails.getAccount());
    }
    @DeleteMapping
    public boolean deleteLike(@PathVariable Long postId,
                              @AuthenticationPrincipal UserDetailsImpl userDetails){
        return likeService.deleteLike(postId, userDetails.getAccount());
    }
}
