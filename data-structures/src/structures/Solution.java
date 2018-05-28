package structures;



import java.io.*;
import java.util.*;

//** Goal ** // return a list of unique site names along with the user which liked the page the earliest

// Expected output [in any order]:
//   http://yahoo.com => user2
//   http://google.com => user4
//   http://google.com/maps => user2
//   http://altavista.net/q?f=12344 => user1
//   http://geocities.com => user1

class Solution {
	
  public static void main(String[] args) {
    // Content, user ID, timestamp
    String[][] userContentLikes = new String[][]{
        {"http://yahoo.com", "user3", "201999"},
        {"http://google.com/maps", "user2", "201004"},
        {"http://google.com/maps", "user1", "201015"},
        {"http://google.com", "user4", "201004"},
        {"http://google.com", "user2", "201012"},
        {"http://google.com/maps", "user2", "201008"},
        {"http://google.com/maps", "user2", "201013"},
        {"http://google.com/maps", "user2", "201030"},
        {"http://altavista.net/q?f=12344", "user3", "100002"},
        {"http://google.com/maps", "user3", "201015"},
        {"http://yahoo.com", "user2", "201035"},
        {"http://altavista.net/q?f=12344", "user1", "99999"},
        {"http://altavista.net/q?f=12344", "user1", "100004"},
        {"http://geocities.com", "user1", "100007"},
        {"http://geocities.com", "user3", "100009"},
    };
    
    Solution sol = new Solution();
    
    sol.getLikes(userContentLikes);
    
  }
  
  public class UserLike {
	  String siteName;
	  String userName;
	  String timeStamp;
	  
	  public UserLike(String sn, String un, String ts) {
		  this.siteName = sn;
		  this.userName = un;
		  this.timeStamp = ts;
	  }
  }
  
  public HashMap<String, UserLike> getLikes(String[][] userContentLikes) {
	  HashMap<String, UserLike> hm = new HashMap<String, UserLike>();
	  
	  for (int i = 0; i < userContentLikes.length; i ++) {
		  UserLike ul = new UserLike(userContentLikes[i][0],userContentLikes[i][1],userContentLikes[i][2]);
		  
		  if (!hm.containsKey(ul.siteName)) {
			  hm.put(ul.siteName, ul);
		  } else {
			  if (Integer.parseInt(ul.timeStamp) < Integer.parseInt(hm.get(ul.siteName).timeStamp)) {
				  hm.put(ul.siteName, ul);
			  }
		  }
	  }
	  
	  return hm;
	  
	  
  }

}


