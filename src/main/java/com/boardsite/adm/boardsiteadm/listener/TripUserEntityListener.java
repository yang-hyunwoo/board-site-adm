package com.boardsite.adm.boardsiteadm.listener;


import com.boardsite.adm.boardsiteadm.domain.user.TripUser;
import com.boardsite.adm.boardsiteadm.domain.user.TripUserHistory;
import com.boardsite.adm.boardsiteadm.repository.user.TripUserHistoryRepository;
import com.boardsite.adm.boardsiteadm.support.BeanUtils;
import org.springframework.stereotype.Component;
import javax.persistence.PostPersist;
import javax.persistence.PostUpdate;

@Component
public class TripUserEntityListener {

    @PostPersist
    @PostUpdate
    public void prePersistAndPreUpdate(Object o){
        TripUserHistoryRepository tripUserHistoryRepository = BeanUtils.getBean(TripUserHistoryRepository.class);
        TripUser user = (TripUser) o;
        TripUserHistory tripUserHistory = TripUserHistory.of(user.getId(),
                                                            user.getName(),
                                                            user.getNickName(),
                                                            user.getEmail(),
                                                            user.getPassword(),
                                                            user.getPoint(),
                                                            user.getGender()
                                                            );

        tripUserHistoryRepository.save(tripUserHistory);
    }
}
