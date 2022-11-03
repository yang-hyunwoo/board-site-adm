package com.boardsite.adm.boardsiteadm.repository.user;

import com.boardsite.adm.boardsiteadm.domain.user.TripUserHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TripUserHistoryRepository extends JpaRepository<TripUserHistory, Long> {

    List<TripUserHistory> findByTripUserId(Long userId);
}
