package com.sdy.bbbb.entity;

import com.sdy.bbbb.dto.request.PostRequestDto;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class Post extends TimeStamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    @ApiModelProperty(hidden = true)
    private Account account;

    @Column(nullable = false)
    private String guName;

    @Column
    private String tag;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private int commentCount;

    @Column(nullable = false)
    private int likeCount;

    @Column(nullable = false)
    private int views;

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @ApiModelProperty(hidden = true)
    private List<Image> imageList = new ArrayList();

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    @ApiModelProperty(hidden = true)
    private List<Comment> commentList = new ArrayList<>();

    @OneToMany(mappedBy = "post", cascade = CascadeType.REMOVE)
    private List<Like> likeList = new ArrayList<>();

    public Post(PostRequestDto postRequestDto, Account account) {
        this.content = postRequestDto.getContent();
        this.account = account;
        this.guName = postRequestDto.getGu();
        this.tag = postRequestDto.getTag();
    }

    public void update(PostRequestDto postRequestDto) {
        this.content = postRequestDto.getContent();
        this.guName = postRequestDto.getGu();
    }

}
