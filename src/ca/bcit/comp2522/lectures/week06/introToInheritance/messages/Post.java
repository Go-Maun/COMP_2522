package ca.bcit.comp2522.lectures.week06.introToInheritance.messages;

import java.util.ArrayList;

/**
 * Stores information about a news feed post in a social network. Posts can be
 * stored and displayed. This class serves as a superclass for more specific
 * post types.
 * 
 * @author BCIT Based on code by the authors of BlueJ
 * @version 2020
 */
public class Post {
    private String username;
    private long timestamp;
    private int likes;
    private ArrayList<String> comments;

    /**
     * Constructor for objects of class Post.
     * 
     * @param author
     *            The username of the author of this post.
     */
    public Post(String author) {
        username = author;
        timestamp = System.currentTimeMillis();
        likes = 0;
        comments = new ArrayList<String>();
    }

    /**
     * Record one more 'Like' indication from a user.
     */
    public void like() {
        likes++;
    }

    /**
     * Record that a user has withdrawn his/her 'Like' vote.
     */
    public void unlike() {
        if (likes > 0) {
            likes--;
        }
    }

    /**
     * Adds a comment to this post.
     * 
     * @param text
     *            The new comment to add.
     */
    public void addComment(String text) {
        comments.add(text);
    }

    /**
     * Returns the time of creation of this post.
     * 
     * @return The post's creation time, as a system time value.
     */
    public long getTimeStamp() {
        return timestamp;
    }

    /**
     * Displays the details of this post.
     */
    public void display() {
        System.out.println(username);
        System.out.print(timeString(timestamp));

        if (likes > 0) {
            System.out.println("  -  " + likes + " people like this.");
        } else {
            System.out.println();
        }

        if (comments.isEmpty()) {
            System.out.println("   No comments.");
        } else {
            System.out.println("   " + comments.size() + " comment(s). Click here to view.");
        }
    }

    /**
     * Creates a string describing a time point in the past in terms relative to
     * current time, such as "30 seconds ago" or "7 minutes ago". Currently,
     * only seconds and minutes are used for the string.
     * 
     * @param time
     *            The time value to convert (in system milliseconds)
     * @return A relative time string for the given time
     */

    private String timeString(long time) {
        long current = System.currentTimeMillis();
        long pastMillis = current - time; // time passed in milliseconds
        long seconds = pastMillis / 1000;
        long minutes = seconds / 60;
        if (minutes > 0) {
            return minutes + " minutes ago";
        } else {
            return seconds + " seconds ago";
        }
    }
}
