package com.boardsite.adm.boardsiteadm.service.common;

import com.boardsite.adm.boardsiteadm.domain.common.SequenceId;
import com.boardsite.adm.boardsiteadm.repository.common.SequenceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SequenceService {

    private final SequenceRepository sequenceRepository;


    @Transactional
    public Long getSeq() {

        SequenceId seq = new SequenceId("System");
        var seqRead = sequenceRepository.save(seq);
        return seqRead.getId();
    }
}
