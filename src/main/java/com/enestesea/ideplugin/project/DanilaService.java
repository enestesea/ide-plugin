package com.enestesea.ideplugin.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class DanilaService {

    public String getRandomDanilaImage(){
        List<String> list = new ArrayList<>();
        list.add("imagees/image1");
        list.add("images/image2");
        Random random = new Random();
        int randNumber = random.nextInt(list.size());
        return list.get(randNumber);
    }

    public void display(){
        String image = getRandomDanilaImage();
    }
}
