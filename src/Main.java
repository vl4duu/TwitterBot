import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

import java.util.List;

/**
 * @author Vl4duu
 * A small presonal project made for the sole purpose of understanding the Twitter4j API.
 *
 */
public class Main {
    public static void main(String[] args) {
        Twitter twitter = generateTweeter();
        List<twitter4j.Status> tweets;
        try {
            String message = "Trump";
            Query q = new Query(message);
            /** This line adds geolocation filter */
//            q.setGeoCode(new GeoLocation(45.17528,28.79146), 19, Query.KILOMETERS);
            q.setCount(1000);
            tweets = twitter.search(q).getTweets();
            for (Status t : tweets) {
                System.out.println(t.getGeoLocation());
                System.out.print("User: " + t.getUser().getName() + ".\n");
                System.out.println("Tweet: " + t.getText());
                System.out.println("Date: " + t.getCreatedAt().toString());
                System.out.println("UserID: " + t.getUser());
                System.out.print("---------------------------------------------|");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * This is where you need to enter your credentials
     */
    public static Twitter generateTweeter() {
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey("your consumer key")
                .setOAuthConsumerSecret("your consumer secret")
                .setOAuthAccessToken("your access token")
                .setOAuthAccessTokenSecret("your access token secret ");
        TwitterFactory tf = new TwitterFactory(cb.build());
        return tf.getInstance();
    }


}
