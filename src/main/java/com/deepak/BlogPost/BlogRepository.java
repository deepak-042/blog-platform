package com.deepak.BlogPost;

import org.springframework.data.jpa.repository.JpaRepository;

public interface  BlogRepository  extends JpaRepository<BlogPost,Long> {

}
