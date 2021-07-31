package com.example.testmongodb.controllers;

import com.example.testmongodb.entity.MarketDataMongo;
import com.example.testmongodb.service.MarketDataServiceMongo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.bson.types.BSONTimestamp;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequiredArgsConstructor
@Slf4j
public class MarketDataControllerMongo {

    private final MarketDataServiceMongo marketDataServiceMongo;

    @PostMapping("/add")
    public ResponseEntity<?> addNewMarketData() {

        List<MarketDataMongo> listOfMarketDatumMongos = new ArrayList<>(50000
        );


       Long unixTime = 0L;

        for(int i = 0; i < 50000; i++){
            MarketDataMongo.Data data = new MarketDataMongo.Data(Integer.toString(i), Integer.toString(i + 5));
            MarketDataMongo marketDataMongo = new MarketDataMongo();
            marketDataMongo.setTime(unixTime);
            marketDataMongo.setData(data);

            listOfMarketDatumMongos.add(marketDataMongo);
        }

        StopWatch watch = new StopWatch();
        watch.start();
        marketDataServiceMongo.addAll(listOfMarketDatumMongos);
        watch.stop();
        log.info(" Execution time addAll: " + watch.getTotalTimeSeconds());


        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public List<MarketDataMongo> getAllData(){
        StopWatch watch = new StopWatch();
        watch.start();
        List<MarketDataMongo> marketDataList = marketDataServiceMongo.getAll();
        watch.stop();
        log.info(" Execution time getAll: " + watch.getTotalTimeSeconds());
        return marketDataList;
    }

    @DeleteMapping("/deleteAll")
    public void deleteAll(){
        marketDataServiceMongo.deleteAll();
    }

}
