package com.younus.Joblisting.Repository;  // Package for the repository layer, focused on custom search functionality.

import com.younus.Joblisting.model.Post;  // Importing the Post model class, representing the job postings.
import java.util.List;  // Importing List to return a collection of Post objects.

public interface SearchRepository {  // Interface for the custom search repository.

    List<Post> findByText(String text);
    // Custom method signature for searching posts by text.
    // This method will search across fields like techs, description, and profile in the Post entity.
}
