package com.springboot.mongodb.service;

import com.springboot.mongodb.model.DatabaseSequence;
import com.springboot.mongodb.repository.DatabaseSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatabaseSequenceService implements SequenceGenerator {
    @Autowired
    private DatabaseSequenceRepository sequenceRepository;

    @Override
    public long getNext(String sequenceId) {
        Optional<DatabaseSequence> sequenceOptional = this.sequenceRepository.findById(sequenceId);
        DatabaseSequence sequence = null;
        long id = 0;
        if (sequenceOptional.isPresent()) {
            sequence = sequenceOptional.get();
            id = sequence.getSeq();
            sequence.setSeq(id + 1);
        }
        else{
            sequence = new DatabaseSequence();
            sequence.setId(sequenceId);
            sequence.setSeq(id);
        }
        sequenceRepository.save(sequence);
        return id;
    }
}
