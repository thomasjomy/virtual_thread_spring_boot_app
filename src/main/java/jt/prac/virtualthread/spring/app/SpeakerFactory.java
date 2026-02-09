package jt.prac.virtualthread.spring.app;

import java.util.List;
import java.util.stream.IntStream;

public class SpeakerFactory {

    public static List<Speaker> createSpeakers(int speakerCount){
        return IntStream.range(0, speakerCount)
                .mapToObj(i -> new Speaker("Speaker " + i))
                .toList();
    }
}
