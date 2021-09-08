package org.event.repository;
import java.util.List;
import org.event.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MembersRepository extends JpaRepository<Members,Long> {
    List<Members> findMembersByIsMember(boolean b);
}
