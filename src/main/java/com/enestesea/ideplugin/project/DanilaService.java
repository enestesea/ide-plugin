package com.enestesea.ideplugin.project;

import com.enestesea.ideplugin.Gui.Danila;
import com.intellij.openapi.components.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

@Service
public final class DanilaService {

    public BufferedImage getRandomDanilaImage(){

        List<BufferedImage> lst = new ArrayList<>();
        for (int i = 1; i < 20; i++){
            try {
                lst.add(ImageIO.read(Objects.requireNonNull(DanilaService.class
                        .getResource("/images/image" + i + ".jpg"))));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        Random random = new Random();
        int randNumber = random.nextInt(lst.size());
        return lst.get(randNumber);
    }

    public Danila display(){
        return new Danila();
    }
}
