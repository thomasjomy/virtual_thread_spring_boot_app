package jt.prac.virtualthread.spring.app;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/api")
public class SpeakerController {
    private Logger logger = LoggerFactory.getLogger(SpeakerController.class);

    private final FakeHttpService fakeHttpService;


    public SpeakerController(FakeHttpService fakeHttpService) {
        this.fakeHttpService = fakeHttpService;
    }

    @GetMapping("/speakers")
    public List<Speaker> retrieveSpeakers() {
        logger.info("Fetching all speakers");
        return fakeHttpService.retrieveSpeakers();
    }

    @GetMapping("/speakers-async")
    public CompletableFuture<List<Speaker>> retrieveSpeakersAsync(){
        return fakeHttpService.retrieveSpeakersAsync();
    }

}
