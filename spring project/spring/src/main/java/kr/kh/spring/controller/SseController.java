package kr.kh.spring.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import kr.kh.spring.utils.SseEmitters;

@RestController
public class SseController {
	
	private final SseEmitters sseEmitters;  
  
	@Autowired  
  public SseController(SseEmitters sseEmitters) {  
      this.sseEmitters = sseEmitters;  
  }  

  @GetMapping(value = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)  
  public ResponseEntity<SseEmitter> connect() {  
      SseEmitter emitter = new SseEmitter(60 * 1000L);  
      sseEmitters.add(emitter);
      try {  
          emitter.send(SseEmitter.event()  
                  .name("connect")  
                  .data("connected!"));  
          count();
      } catch (IOException e) {  
          throw new RuntimeException(e);  
      }  
      return ResponseEntity.ok(emitter);  
  }  
  @GetMapping("/count")  
  public ResponseEntity<Void> count() {  
      sseEmitters.count();  
      return ResponseEntity.ok().build();  
  }  
}
