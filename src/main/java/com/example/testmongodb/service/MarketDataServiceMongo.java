package com.example.testmongodb.service;

import com.example.testmongodb.entity.MarketDataMongo;
import com.example.testmongodb.repository.MarketDataRepositoryMongo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MarketDataServiceMongo {

    private final MarketDataRepositoryMongo marketDataRepositoryMongo;

    public void addMarkedData(MarketDataMongo marketDataMongo){
        marketDataRepositoryMongo.save(marketDataMongo);

    }

    public List<MarketDataMongo> getAll(){
        return marketDataRepositoryMongo.findAll();
    }

    public void addAll(List<MarketDataMongo> data){
        marketDataRepositoryMongo.saveAll(data);
    }

    public void deleteAll(){
        marketDataRepositoryMongo.deleteAll();
    }
}
