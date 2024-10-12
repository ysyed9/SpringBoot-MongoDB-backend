package com.younus.Joblisting.model;  // Package structure indicates this is part of a job listing service. Naming is fine here.

import org.springframework.data.mongodb.core.mapping.Document;  // Importing necessary annotation for MongoDB. Make sure you have the correct MongoDB dependencies set up in your build file.
import java.util.Arrays;  // Importing Arrays class to handle the array in toString() method. Useful for printing array contents.

@Document(collection = "Clustor0")  // Annotation to map this class to MongoDB. Double-check the collection name 'Clustor0' (might be a typo for 'Cluster0').
public class Post {  // This class represents a MongoDB document for job postings. Nice choice of fields for job details.

    private String profile;  // Stores job title or profile name.
    private String desc;  // Short form for description, consider renaming to 'description' for better readability.
    private int exp;  // Stores required years of experience. Using int is a good choice.
    private String techs[];  // Array to store required technologies. Might want to switch to List<String> for flexibility.

    public Post() {  // Default constructor, useful for frameworks like Spring to instantiate objects via reflection.
    }

    public String getProfile() {  // Getter for the profile field.
        return profile;
    }

    public void setProfile(String profile) {  // Setter for the profile field.
        this.profile = profile;
    }

    public String getDesc() {  // Getter for the desc field.
        return desc;
    }

    public void setDesc(String desc) {  // Setter for the desc field.
        this.desc = desc;
    }

    public int getExp() {  // Getter for the exp field.
        return exp;
    }

    public void setExp(int exp) {  // Setter for the exp field.
        this.exp = exp;
    }

    public String[] getTechs() {  // Getter for the techs array.
        return techs;
    }

    public void setTechs(String[] techs) {  // Setter for the techs array.
        this.techs = techs;
    }

    @Override
    public String toString() {  // Overrides toString() to provide a readable output of the object.
        return "Post{" +
                "profile='" + profile + '\'' +
                ", desc='" + desc + '\'' +
                ", exp=" + exp +
                ", techs=" + Arrays.toString(techs) +
                '}';
    }
}
