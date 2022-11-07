package com.sdy.bbbb.service;

import com.sdy.bbbb.entity.Account;
import com.sdy.bbbb.entity.Like;
import com.sdy.bbbb.entity.Post;
import com.sdy.bbbb.exception.CustomException;
import com.sdy.bbbb.exception.ErrorCode;
import com.sdy.bbbb.repository.LikeRepository;
import com.sdy.bbbb.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeService {
    private final LikeRepository likeRepository;
    private final PostRepository postRepository;
    @Transactional
    public boolean createLike(Long postId, Account account){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.NotFound));
        //게시글 없으면 에러처리
        Optional<Like> foundLike = likeRepository.findByPostAndAccount(post, account);
        if (foundLike.isPresent()){
            throw new CustomException(ErrorCode.NotFound);
            // 좋아요 정보가 있는 상태 예외 처리 -> 예외코드 만들어야함 (혹시 몰라서 일단 예외처리)
        }else {
        Like like = new Like(post, account);
        likeRepository.save(like);
        post.getLikeList().add(like);
        return true;
        }
    }

    @Transactional
    public boolean deleteLike(Long postId, Account account){
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new CustomException(ErrorCode.NotFound));
        //게시글 없으면 에러처리
        Optional<Like> foundLike = likeRepository.findByPostAndAccount(post, account);
        if (foundLike.isPresent()){
            likeRepository.delete(foundLike.get());
            return false;
        }else {
            throw new CustomException(ErrorCode.NotFound);
            // 좋아요 정보가 없는 상태 예외처리 -> 예외코드 만들어야함 (혹시 몰라서 일단 예외처리)
        }
    }
}
