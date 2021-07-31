package com.example.testmongodb.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "market_data")
public class MarketDataMongo {

    private Long time;

    private Data data;



    public static class Data{
        private String open;
        private String close;

        public Data(String open, String close) {
            this.open = open;
            this.close = close;
        }

        public Data() {
        }

        public String getOpen() {
            return open;
        }

        public void setOpen(String open) {
            this.open = open;
        }

        public String getClose() {
            return close;
        }

        public void setClose(String close) {
            this.close = close;
        }
    }

}
