package com.comparable;

import java.io.File;
import java.io.IOException;
import java.util.UUID;


public class Demo {

	
	public static void main(String[] args) throws IOException {
	Demo demo= new Demo();
	demo.uploadImage("abc", null);
		
	}
	
	public String uploadImage(String path, File file) throws IOException {
		String name = file.getName();
		String randomID = UUID.randomUUID().toString();
		String fileName1 
		= randomID.concat(name.substring(name.lastIndexOf(".")));
		return fileName1;
		}
}
