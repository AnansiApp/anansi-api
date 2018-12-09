package br.com.anansi.controller;

import br.com.anansi.MainController;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith( SpringRunner.class )
@WebAppConfiguration
@ContextConfiguration(classes = MainController.class)
public class ImageControllerTest {

    @Autowired
    private ImageController imageController;

    @Test
    public void getImage() throws IOException {

        ResponseEntity<byte[]> image = imageController.getImage(new String("images-options/1.jpg"));

        Assert.assertNotNull(image);

    }
}