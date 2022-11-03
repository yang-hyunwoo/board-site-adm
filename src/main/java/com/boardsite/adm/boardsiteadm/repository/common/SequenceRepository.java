package com.boardsite.adm.boardsiteadm.repository.common;


import com.boardsite.adm.boardsiteadm.domain.common.SequenceId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SequenceRepository extends JpaRepository<SequenceId, Long> {
}
