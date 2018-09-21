package me.will.spi.service.impl;

import me.will.spi.service.SearchService;

public class DataSearchServiceImpl implements SearchService {

    @Override
    public void search(String keyword) {
        System.out.println("datasearch "+keyword);
    }

}
