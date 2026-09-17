class Twitter {
    Map<Integer, Integer> feed;
    List<Integer> post;
    Map<Integer, Set<Integer>> follower;
    public Twitter() {
        feed = new HashMap<>();
        follower = new HashMap<>();
        post = new ArrayList<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        feed.put(tweetId, userId);
        post.add(tweetId);
        Set<Integer> set = follower.getOrDefault(userId, new HashSet<>());
        set.add(userId);
        follower.put(userId, set);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        Set<Integer> set = follower.getOrDefault(userId, new HashSet<>());
        List<Integer> list = new ArrayList<>();
        int i = post.size()-1;
        while (i >= 0 && list.size() < 10) {
            int tweetId = post.get(i);
            int user = feed.get(tweetId);
            if (set.contains(user)) list.add(tweetId);
            i--;
        }
        return list;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> set = follower.getOrDefault(followerId, new HashSet<>());
        set.add(followeeId);
        follower.put(followerId, set);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> set = follower.getOrDefault(followerId, new HashSet<>());
        if (!set.contains(followeeId)) return;
        set.remove(followeeId);
        follower.put(followerId, set);
    }
}
