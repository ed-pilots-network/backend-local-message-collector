package io.edpn.backend.localMesaggeCollector.infrastructure.persistence;

import io.edpn.backend.localMesaggeCollector.domain.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MessageRepository extends MongoRepository<Message, String> {
}
