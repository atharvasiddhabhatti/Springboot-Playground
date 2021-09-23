package com.spring.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.spring.model.FileDB;
import com.spring.repository.FileDBRepository;

@Service
public class FileDBStoreService {

	@Autowired
	private FileDBRepository dbRepository;
	
	public FileDB store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		FileDB fileDB = new FileDB(fileName,file.getContentType(), file.getBytes());
		
		return dbRepository.save(fileDB);
	}
	public FileDB getFile(String id) {
		return dbRepository.findById(id).get();
	}
	public Stream<FileDB> getAllFiles() {
		return dbRepository.findAll().stream();
	}
}
