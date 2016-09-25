package uz.unicon.websocket_demo.user;


public interface UserService {
    User findByUserName(UserCriteria criteria);
}
