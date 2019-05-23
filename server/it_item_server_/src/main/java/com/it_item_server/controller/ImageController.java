package com.it_item_server.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ImageController {

//	@RequestMapping(value = "/image/{imageid}", method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
//	public ResponseEntity<byte[]> getImageWithMediaType(@PathVariable String imageid) throws IOException {
////	public String getImageWithMediaType(@PathVariable String imageid) throws IOException {
//
//		System.out.println("IMAGE"+imageid);
//		File file = new File("src/main/resources/static/image/" + imageid + ".png");
//
//		return ResponseEntity.ok().header("Content-type", "text/html; filename=" + file.getName())
//				.contentType(MediaType.valueOf(FileTypeMap.getDefaultFileTypeMap().getContentType(file)))
//				.body(Files.readAllBytes(file.toPath()));
//
////		return imageid + ".asda";
//
//	}

	
	
	@RequestMapping(value = "/image/{imageid}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("imageid") String imageid) throws IOException {
		File file = new File("src/main/resources/static/image/" + imageid + ".jpg");

	    byte[] image = Files.readAllBytes(file.toPath());
	    
	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}
}