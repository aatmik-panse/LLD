package com.example.profiles;

/**
 * Profile service that creates immutable UserProfile objects using the Builder pattern.
 * No longer mutates profiles after creation.
 */
public class ProfileService {

    // Creates a minimal profile with only required fields
    public UserProfile createMinimal(String id, String email) {
        return UserProfile.builder()
                .id(id)
                .email(email)
                .build(); // Validation happens in builder.build()
    }

    // Creates a full profile with all fields
    public UserProfile createFull(String id, String email, String phone, String displayName, 
                                 String address, boolean marketingOptIn, String twitter, String github) {
        return UserProfile.builder()
                .id(id)
                .email(email)
                .phone(phone)
                .displayName(displayName)
                .address(address)
                .marketingOptIn(marketingOptIn)
                .twitter(twitter)
                .github(github)
                .build(); // Validation happens in builder.build()
    }

    // Instead of mutating, return a new profile with updated display name
    public UserProfile withUpdatedDisplayName(UserProfile original, String displayName) {
        // Validate display name length
        if (displayName != null && displayName.length() > 100) {
            throw new IllegalArgumentException("displayName must not exceed 100 characters");
        }
        
        // Create new profile with updated display name, copying all other fields
        return UserProfile.builder()
                .id(original.getId())
                .email(original.getEmail())
                .phone(original.getPhone())
                .displayName(displayName) // updated field
                .address(original.getAddress())
                .marketingOptIn(original.isMarketingOptIn())
                .twitter(original.getTwitter())
                .github(original.getGithub())
                .build();
    }
}
