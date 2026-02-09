package jt.prac.virtualthread.spring.app;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.CompletableFuture.delayedExecutor;
import static java.util.concurrent.CompletableFuture.supplyAsync;

@Service
public class FakeHttpService {

    public List<Speaker> retrieveSpeakers() {
        try {
            Thread.sleep(1_000);
            return speakers();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private List<Speaker> speakers() {
        List<Speaker> speakers = new ArrayList<>();
        speakers.add(Speaker.builder().name("Jessica Blake").build());
        return speakers;
    }

    public CompletableFuture<List<Speaker>> retrieveSpeakersAsync() {
        return supplyAsync(this::speakers, delayedExecutor(1_000, TimeUnit.MILLISECONDS));
    }

}
