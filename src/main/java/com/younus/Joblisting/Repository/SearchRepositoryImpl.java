package com.younus.Joblisting.Repository;  // Package for the repository implementation, focused on MongoDB operations.

import com.mongodb.client.AggregateIterable;  // Importing MongoDB's aggregate query result iterable.
import com.mongodb.client.MongoClient;  // MongoDB client to interact with the database.
import com.mongodb.client.MongoCollection;  // Represents a collection in the MongoDB database.
import com.mongodb.client.MongoDatabase;  // Represents the MongoDB database.
import com.younus.Joblisting.model.Post;  // Importing the Post model class.
import org.bson.Document;  // BSON Document used for MongoDB operations.
import org.springframework.beans.factory.annotation.Autowired;  // Autowiring dependencies from Spring's IoC container.
import org.springframework.data.mongodb.core.convert.MongoConverter;  // MongoConverter to convert between MongoDB Document and Post objects.
import org.springframework.stereotype.Component;  // Marking this class as a Spring Component (bean).

import java.util.ArrayList;  // Importing ArrayList to store Post objects.
import java.util.Arrays;  // Importing Arrays to handle array operations.
import java.util.List;  // Importing List to return a collection of Post objects.

@Component  // Marks the class as a Spring-managed component, allowing it to be autowired elsewhere in the application.
public class SearchRepositoryImpl implements SearchRepository {  // Implementation of the custom search repository.

    @Autowired  // Spring will automatically inject the MongoClient bean.
    MongoClient client;

    @Autowired  // Spring will automatically inject the MongoConverter bean to convert documents to Post objects.
    MongoConverter converter;

    @Override
    public List<Post> findByText(String text) {  // Implementation of the search method to find posts by text.

        final List<Post> posts = new ArrayList<>();  // Create a list to store the results (Post objects).

        MongoDatabase database = client.getDatabase("Clustor0");  // Get the MongoDB database. Ensure the name is correct.
        MongoCollection<Document> collection = database.getCollection("Clustor0");  // Get the specific collection (Clustor0).

        // MongoDB aggregation pipeline to search by text in the fields techs, desc, and profile, sort by experience, and limit to 5 results.
        AggregateIterable<Document> result = collection.aggregate(Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", text)  // Search for the given text in the specified fields.
                                        .append("path", Arrays.asList("techs", "desc", "profile")))),
                new Document("$sort",
                        new Document("exp", 1L)),  // Sort by experience (exp) in ascending order.
                new Document("$limit", 5L)));  // Limit the result set to 5 posts.

        // Iterate over the result and convert each MongoDB Document to a Post object using MongoConverter.
        result.forEach(doc -> posts.add(converter.read(Post.class, doc)));

        return posts;  // Return the list of Post objects matching the search criteria.
    }
}
