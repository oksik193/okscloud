package org.oksik193.okscloud.repos;

import org.oksik193.okscloud.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
