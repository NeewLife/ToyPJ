package com.study.domain.post;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {

    private final PostMapper postMapper;

    /**
     * 게시글 저장
     * @param params - 게시글 정보
     * @return Generated PK
     */
    @Transactional
    public Long savePost(final PostRequest params) {
        postMapper.save(params);
        return params.getOrderNum();
    }

    /**
     * 게시글 상세정보 조회
     * @param orderNum - PK
     * @return 게시글 상세정보
     */
    public PostResponse findPostByOrderNum(final Long orderNum) {
        return postMapper.findByOrderNum(orderNum);
    }

    /**
     * 게시글 수정
     * @param params - 게시글 정보
     * @return PK
     */
    @Transactional
    public Long updatePost(final PostRequest params) {
        postMapper.update(params);
        return params.getOrderNum();
    }

    /**
     * 게시글 삭제
     * @param orderNum - PK
     * @return PK
     */
    public Long deletePost(final Long orderNum) {
        postMapper.deleteByOrderNum(orderNum);
        return orderNum;
    }

    /**
     * 게시글 리스트 조회
     * @return 게시글 리스트
     */
    public List<PostResponse> findNotNoticePost() {
        return postMapper.findNotNoticePost();
    }
    
//    public List<PostResponse> findNoticePost() {
//        return postMapper.findNoticePost();
//    }

}