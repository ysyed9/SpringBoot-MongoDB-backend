package com.younus.Joblisting.Repository;  // Package for the repository layer, responsible for data access operations.

import com.younus.Joblisting.model.Post;  // Importing the Post model class, which represents the job postings.
import org.springframework.data.mongodb.repository.MongoRepository;  // Importing Spring Data MongoDB's repository interface to perform CRUD operations.

public interface PostRepository extends MongoRepository<Post, String> {
    // This interface extends MongoRepository to provide CRUD operations for Post objects.
    // The generic types <Post, String> indicate that the repository will work with Post entities and the ID type is String (likely for MongoDB ObjectIds).

    // No need to define any methods, as MongoRepository provides several useful ones (findAll, findById, save, delete, etc.).
    // Custom query methods can be added here using Spring Data's query creation mechanism (e.g., findByProfile, findByExp).
}
