package uz.unicon.websocket_demo.user;


import org.springframework.data.jpa.domain.Specification;
import uz.unicon.websocket_demo.utils.SpecUtils;

import javax.persistence.criteria.JoinType;

public abstract class UserSpec {

    public static Specification<User> byCriteria(UserCriteria criteria) {
        return SpecUtils.and(
                fetchUsersContacts(),
                byUserName(criteria.getUsername())
        );
    }

    private static Specification<User> byUserName(String userName) {
        return (root, query, cb) -> cb.equal(root.get(User_.userName), userName);
    }


    private static Specification<User> fetchUsersContacts() {
        return (root, query, cb) -> {
            root.fetch(User_.contacts, JoinType.LEFT);
            return null;
        };
    }
}
