package com.example.marineinformation.repository;

import com.example.marineinformation.entities.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

    Optional<MemberEntity> findByUsernameAndPassword(String userName, String password);

    // jwtToken Test용 후에 username과 password 둘다 가져와야함
    Optional<MemberEntity> findByUsername(String userName);
}
