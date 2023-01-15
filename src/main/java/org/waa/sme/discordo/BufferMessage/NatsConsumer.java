package org.waa.sme.discordo.BufferMessage;

import io.nats.client.Connection;
import io.nats.client.Message;
import io.nats.client.Nats;
import io.nats.client.Subscription;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

/**
 * @deprecated class pour le poc du peer to peer via NATS, au final pas retenu car ne respecte pas le cahiier des charges
 */
public class NatsConsumer extends Thread {

    private final Connection natsConnection;
    private final Subscription subscription;
    private final List<String> messages = new ArrayList<>();

    public NatsConsumer(String url, String topic) throws Exception {
        this.natsConnection = Nats.connect(url);
        this.subscription = natsConnection.subscribe(topic);
    }

    public List<String> getMessages() {
        return messages;
    }

    public void run() {
        while (true) {
            try {
                Message message = subscription.nextMessage(Duration.ofSeconds(1));

                if (message != null) {
                    messages.add(new String(message.getData()));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void publish(String topic, String message) throws Exception {
        natsConnection.publish(topic, message.getBytes());
    }
}

