package newTech;

import lombok.extern.slf4j.Slf4j;
import org.hamcrest.core.IsEqual;
import org.junit.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import reactor.core.publisher.ConnectableFlux;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.time.Duration.ofSeconds;
import static org.junit.Assert.assertThat;

@Slf4j
public class ReactiveProgramming {


    @Test
    public void testBasic() {
        List<Integer> integers = new ArrayList<>();
        Flux.just(1, 2, 3).log().subscribe(integers::add);
        assertThat(integers, IsEqual.equalTo(Arrays.asList(1, 2, 3)));
    }

    @Test
    public void testWithSubscriberInterface() {
        List<Integer> elements = new ArrayList<>();

        Flux.just(1, 2, 3, 4, 5)
                .log()
                .subscribe(new Subscriber<>() {
                    int consumed;
                    Subscription subscription;

                    @Override
                    public void onSubscribe(Subscription subscription) {
                        this.subscription = subscription;
                        subscription.request(2);
                    }

                    @Override
                    public void onNext(Integer integer) {
                        elements.add(integer * 2);
                        consumed = +2;
                        subscription.request(consumed);
                    }

                    @Override
                    public void onError(Throwable throwable) {

                    }

                    @Override
                    public void onComplete() {
                        log.debug("a7a");
                    }
                });

        assertThat(elements, IsEqual.equalTo(Arrays.asList(2, 4, 6, 8, 10)));
    }


    @Test
    public void testCombining() {
        List<String> integers = new ArrayList<>();
        Flux.just(1, 2, 3, 4).log().map(integer -> integer * 2).
                zipWith(Flux.range(1, Integer.MAX_VALUE), (t1, t2) -> String.format("T1: %d, T2: %d", t1, t2)).
                subscribe(integers::add);
        assertThat(integers, IsEqual.equalTo(Arrays.asList("T1: 2, T2: 1",
                "T1: 4, T2: 2",
                "T1: 6, T2: 3",
                "T1: 8, T2: 4")));
    }

    @Test
    public void testHotStream() {
        ConnectableFlux<Object> publish = Flux.create(fluxSink -> {
            while (true) {
                fluxSink.next(System.currentTimeMillis());
            }
        }).sample(ofSeconds(2)).publish();

        publish.log().subscribe();
    }


}
