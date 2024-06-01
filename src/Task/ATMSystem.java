package Task;

import java.util.HashMap;
import java.util.Map;

public class ATMSystem {
	
	private Map<String, User> users;

    public ATMSystem() {
        users = new HashMap<>();
        
        
        users.put("user1", new User("user1", "1234", new Account(1000)));
        users.put("user2", new User("user2", "2345", new Account(2000)));
    }

    public User validateUser(String userId, String userPin) {
        User user = users.get(userId);
        if (user != null && user.validatePin(userPin)) {
            return user;
        }
        return null;
    }

    public User getUserById(String userId) {
        return users.get(userId);
    }
}
