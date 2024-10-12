package com.younus.Joblisting.Repository;

import com.younus.Joblisting.model.Post;

import java.util.List;

public interface SearchRepository {

    List<Post> findByText(String text);

}