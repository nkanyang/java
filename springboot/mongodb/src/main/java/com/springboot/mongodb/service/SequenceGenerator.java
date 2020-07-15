package com.springboot.mongodb.service;

public interface SequenceGenerator {
    public long getNext(String sequenceId);
}
