package vn.iotstar.security.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import vn.iotstar.security.entity.UserInfo;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
    Optional<UserInfo> findByUsername(String username);
}

