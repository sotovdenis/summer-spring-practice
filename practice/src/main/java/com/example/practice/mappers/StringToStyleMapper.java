package com.example.practice.mappers;

import com.example.practice.entities.Style;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;


@Component
public class StringToStyleMapper implements Converter<String, Style> {
    @Override
    public Style convert(String value) {
        String string = String.valueOf(Style.CRAWL);
        return Style.valueOf(Style.class, string);
    }
}
//@Getter
//@Setter
//public class StringToStyleMapper {
//    private String input;
//    private Style output;
//
//    public Style mapToStyle(int input){
//        switch (input){
//            case 3 -> {
//                return Style.CRAWL;
//            }
//        }
//        return Style.MEDLEY;
//    }
//
//    public int mapToInt(Style input){
//        switch (input){
//            case CRAWL -> {
//                return 3;
//            }
//        }
//        return 4;
//    }
//}
