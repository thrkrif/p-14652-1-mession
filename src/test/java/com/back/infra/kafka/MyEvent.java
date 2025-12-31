package com.back.infra.kafka;

import com.back.standard.event.HasEventName;

public record MyEvent(String msg) implements HasEventName {
// record를 사용하면 @AllArgs~~~ 생성자 사용 안해도 된다?
}
