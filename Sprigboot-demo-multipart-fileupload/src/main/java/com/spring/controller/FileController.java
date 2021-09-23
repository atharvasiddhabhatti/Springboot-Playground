package com.spring.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.engine.query.spi.ReturnMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.spring.message.ResponseFile;
import com.spring.message.ResponseMessage;
import com.spring.model.FileDB;
import com.spring.service.FileDBStoreService;

import ch.qos.logback.core.rolling.DefaultTimeBasedFileNamingAndTriggeringPolicy;

@Controller
@CrossOrigin("http://localhost:8081")
public class FileController {

	@Autowired
	private FileDBStoreService dbStoreService;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file) {
		String message = "";
		try {
			dbStoreService.store(file);
			message = "Uploaded the file successfully: "+ file.getOriginalFilename();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}
		catch (Exception e) {
			message = "Could not upload the file: "+ file.getOriginalFilename() + "!";
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
		}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getListFiles(){
		List<ResponseFile> files = dbStoreService.getAllFiles().map(dbFile -> {
	
		String fileDownloadUri = ServletUriComponentsBuilder
				.fromCurrentContextPath()
				.path("/files/")
				.path(dbFile.getId())
				.toUriString();
		
		return new ResponseFile(
				dbFile.getName(),
				fileDownloadUri,
				dbFile.getType(),
				dbFile.getData().length);
	}).collect(Collectors.toList());
	
return ResponseEntity.status(HttpStatus.OK).body(files);
	}
	
   @GetMapping("/files/{id}")
   public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	   FileDB fileDB = dbStoreService.getFile(id);
	   return ResponseEntity.ok()
			   .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+fileDB.getName() + "\"")
			   .body(fileDB.getData());
   }
}
