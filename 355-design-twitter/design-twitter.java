// Design a simplified version of Twitter where users can post tweets, follow/unfollow another user and is able to see the 10 most recent tweets in the user's news feed. Your design should support the following methods:
//
//
//
// postTweet(userId, tweetId): Compose a new tweet.
// getNewsFeed(userId): Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent.
// follow(followerId, followeeId): Follower follows a followee.
// unfollow(followerId, followeeId): Follower unfollows a followee.
//
//
//
// Example:
//
// Twitter twitter = new Twitter();
//
// // User 1 posts a new tweet (id = 5).
// twitter.postTweet(1, 5);
//
// // User 1's news feed should return a list with 1 tweet id -> [5].
// twitter.getNewsFeed(1);
//
// // User 1 follows user 2.
// twitter.follow(1, 2);
//
// // User 2 posts a new tweet (id = 6).
// twitter.postTweet(2, 6);
//
// // User 1's news feed should return a list with 2 tweet ids -> [6, 5].
// // Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
// twitter.getNewsFeed(1);
//
// // User 1 unfollows user 2.
// twitter.unfollow(1, 2);
//
// // User 1's news feed should return a list with 1 tweet id -> [5],
// // since user 1 is no longer following user 2.
// twitter.getNewsFeed(1);


public class Twitter {
    public static int TIME_STAMP=0;
	public class tweet{
		int tweetId;
		int time;
		tweet next;
		tweet(int id){
			tweetId = id;
			time = TIME_STAMP++;
			next = null;
		}
	}
	
    public class user{

		 int userId;
	     Set<Integer>follows;
	     tweet head;
	     
	     public user(int id){
	    	 userId = id;
	    	 follows = new HashSet<>();
	    	 follow(id);
	    	 head = null;
	     }
	     
	     public void post(int tweetId){
	    	 tweet newTweet = new tweet(tweetId);
	    	 newTweet.next = this.head;
	    	 this.head = newTweet;
	     }
	     public void follow(int id){
	    	 follows.add(id);
	     }
	     public void unfollow(int id){
	    	 follows.remove(id);
	     }
	}
	
	Map<Integer,user>users;
	
	/** Initialize your data structure here. */
    public  Twitter() {
        users = new HashMap<Integer,user>();
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
    	if(!users.containsKey(userId)){
    		user u = new user(userId);
    		users.put(userId, u);	
    	}
    	user u = users.get(userId);
		u.post(tweetId);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer>result = new ArrayList<>();
        if(!users.containsKey(userId))return result;
        Set<Integer>follows = users.get(userId).follows;
        PriorityQueue<tweet> pq = new PriorityQueue<>(users.size(),new Comparator<tweet>() {
			@Override
			public int compare(tweet o1, tweet o2) {
				return o2.time-o1.time;
			}
		});
        for(Integer u :follows){
        	user user = users.get(u);
        	if(user.head!=null)pq.add(user.head);
        }
        int count=0;
        while(!pq.isEmpty()&&count<10){
        	tweet t = pq.poll();
        	result.add(t.tweetId);
        	count++;
        	if(t.next!=null)pq.add(t.next);
        }
		return result;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)){
        	user u = new user(followerId);
    		users.put(followerId, u);	
        }
        if(!users.containsKey(followeeId)){
        	user u = new user(followeeId);
    		users.put(followeeId, u);	
        }
        user u = users.get(followerId);
        u.follow(followeeId);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!users.containsKey(followerId)||!users.containsKey(followeeId)||followerId==followeeId)return;
        user u = users.get(followerId);
        u.unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
