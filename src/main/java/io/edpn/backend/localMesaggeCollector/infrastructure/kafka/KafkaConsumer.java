package io.edpn.backend.localMesaggeCollector.infrastructure.kafka;

import io.edpn.backend.localMesaggeCollector.domain.Message;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.json.JSONObject;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {

    private final MongoTemplate mongoTemplate;

    @KafkaListener(topics = "#{@topicList}", groupId = "localMessageCollector")
    public void listen(ConsumerRecord<String, String> record) {
        JSONObject jsonObject = new JSONObject(record.value());
        // Assuming the record value is of type String JSON
        Message message = new Message(jsonObject);

        mongoTemplate.save(message, record.topic());
    }
}
