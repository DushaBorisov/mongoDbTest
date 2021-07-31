package com.example.testmongodb.repository;

import com.example.testmongodb.entity.MarketDataMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketDataRepositoryMongo extends MongoRepository<MarketDataMongo, Long> {
}
