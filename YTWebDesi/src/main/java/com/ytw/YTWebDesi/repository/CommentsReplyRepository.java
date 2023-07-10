package com.ytw.YTWebDesi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ytw.YTWebDesi.model.CommentsReply;

public interface CommentsReplyRepository extends JpaRepository<CommentsReply, Integer>{
	List<CommentsReply> findByReplyMadeOnCommentsCommentsId(int replyMadeOnCommentsCommentsId);
}
