package kr.kh.spring.utils;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
@Component  
public class SseEmitters {  
  
  private final List<SseEmitter> emitters = new CopyOnWriteArrayList<SseEmitter>();  
  private static final AtomicLong counter = new AtomicLong();  
  public SseEmitter add(SseEmitter emitter) {  
      this.emitters.add(emitter);  

      emitter.onCompletion(() -> {  
          this.emitters.remove(emitter);    // 만료되면 리스트에서 삭제
      });  
      emitter.onTimeout(() -> {  
          emitter.complete();  
      });  

      return emitter;  
  }  
  public void count() {  
    long count = emitters.size();  
    emitters.forEach(emitter -> {  
        try {  
            emitter.send(SseEmitter.event()  
                    .name("count")  
                    .data(count));  
        } catch (IOException e) {  
            throw new RuntimeException(e);  
        }  
    });  
}  
}