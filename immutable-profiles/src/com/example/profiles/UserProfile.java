package com.example.profiles;

/**
 * Mutable and confusing. Multiple constructors + setters.
 */
public class UserProfile {
    private final String id;
    private final String email;
    private final String phone;
    private final String displayName;
    private final String address;
    private final boolean marketingOptIn;
    private final String twitter;
    private final String github;

    public UserProfile(String id, String email , String phone, String displayName, String address, boolean marketingOptIn, String twitter, String github) {
        this.id = id;
        this.email = email;
        this.phone = phone;
        this.displayName = displayName;
        this.address = address;
        this.marketingOptIn = marketingOptIn;
        this.twitter = twitter;
        this.github = github;
    }

    // getters
    public String getId() { return id; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
    public String getDisplayName() { return displayName; }
    public String getAddress() { return address; }
    public boolean isMarketingOptIn() { return marketingOptIn; }
    public String getTwitter() { return twitter; }
    public String getGithub() { return github; }
}
