package me.will.spi.service.impl;

import me.will.spi.service.SearchService;

public class FileSearchServiceImpl implements SearchService {
    @Override
    public void search(String keyword) {
        System.out.println("filesearch "+keyword);
    }

}
