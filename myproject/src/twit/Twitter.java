package twit;

import java.util.*;

public class Twitter {

	private HashMap<Integer,HashSet<Integer>> userMap;
	private HashMap<Integer,ArrayList<Integer>> twitsMap;
	private HashMap<Integer,Integer> orderMap;
	
	public Twitter() {
		userMap = new HashMap<Integer,HashSet<Integer>>();
		twitsMap = new HashMap<Integer,ArrayList<Integer>>();
		orderMap = new HashMap<Integer,Integer>();
	}
	
	public void postTwits(int userId,int twitId) {
		ArrayList<Integer> arrList = twitsMap.get(userId);
		if(arrList==null) {
			ArrayList<Integer> list = new ArrayList<Integer>();
			twitsMap.put(userId,list);
		}
		arrList.add(twitId);
		twitsMap.put(userId, arrList);
		follow(userId,userId);
	}
	
	public void follow(int follower,int followee) {
		if(userMap.get(follower)==null) {
			userMap.put(follower, new HashSet<Integer>());
		}
		HashSet<Integer> set = userMap.get(follower);
		set.add(followee);
	}
	
	public void unFollow(int follower,int followee) {
		if(userMap.get(follower)==null) {
			return ;
		}
		HashSet<Integer> set = userMap.get(follower);
		set.remove(followee);
	}
	
	public ArrayList<Integer> getFeed(int userId) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		HashSet<Integer> followees = userMap.get(userId);
		ArrayList<ArrayList<ArrayList>>	cmnts = ArrayList<ArrayList<ArrayList>>();
		for(int uid :followees) {
			ArrayList<Integer> ucmnts = ArrayList<Integer>();
			ucmnts.add(twitsMap.get(uid));
			cmnts.add(ucmnts);
		}
		PriorityQueue<Wrapper> queue = PriorityQueue<Wrapper>(new comparator<Wrapper>() {
			public int compare(Wrapper a,Wrapper b) {
				return orderMap.get(b.list.get(b.index)-a.list.get(a.index));
			}
		});
		for(ArrayList<Integer> list: lists){
            queue.offer(new Wrapper(list, list.size()-1));
        }
 
        while(!queue.isEmpty() && result.size()<10){
            Wrapper top = queue.poll();
            result.add(top.list.get(top.index));
 
            top.index--;
 
            if(top.index>=0)
                queue.offer(top);
        }
		return result;
	}
}
