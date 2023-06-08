package io.edpn.backend.localMesaggeCollector.domain;

import lombok.Value;
import org.json.JSONObject;

@Value
public class Message {
    JSONObject data;
}
