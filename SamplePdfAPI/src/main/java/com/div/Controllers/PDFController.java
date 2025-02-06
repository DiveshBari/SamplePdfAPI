package com.div.Controllers;

import java.io.IOException;

import org.springframework.core.io.ClassPathResource;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PDFController {
	@GetMapping(path = "/getSamplePdf")
	public ResponseEntity<byte[]> getSamplePdf() throws IOException {
		System.out.println("getSamplePdf called");
		
		// Load the sample PDF file (Replace with actual file path)
        ClassPathResource pdfFile = new ClassPathResource("Files/samplePDF.pdf");
		
        // Read file as byte array
        byte[] pdfBytes = StreamUtils.copyToByteArray(pdfFile.getInputStream());
        
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename("sample.pdf").build());
        
		return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
	}
	
}
