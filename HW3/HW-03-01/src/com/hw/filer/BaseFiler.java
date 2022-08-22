package com.hw.filer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

abstract public class BaseFiler<E>{
	
	
	protected String filepath;
	public final static String DELIMETER = ";";
	
	
	
	public BaseFiler(String filepath) {
		this.filepath = filepath;
	}
	
	
	public void store(List<E> entityList) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(filepath));
		for(E entity : entityList) {
			String line = format(entity);
			bw.write(line);
			bw.write("\r\n");
		}
		bw.close();
	}
	
	public List<E> load() throws IOException {
		List<E> entityList = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader(filepath));
		String line = null;
		while((line = br.readLine()) != null) {
			E entity=parse(line);
			entityList.add(entity);
		}
			
		br.close();
		return entityList;
	}

	
	
	public String getFilepath() {
		return filepath;
	}
	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}
	
	abstract protected String format(E entity);
	abstract protected E parse(String line);
	
	
}
