package com.younus.Joblisting.Repository;

import com.younus.Joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface PostRepository extends MongoRepository<Post,String> {

}
