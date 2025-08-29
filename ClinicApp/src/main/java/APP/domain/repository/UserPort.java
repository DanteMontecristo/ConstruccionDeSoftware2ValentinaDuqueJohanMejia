package APP.domain.repository;

import APP.domain.model.User;

public interface UserPort {
    public User findByDocument(User user) throws Exception;
    public User findByUserName(User user) throws Exception;
    public void save(User user) throws Exception;
}
