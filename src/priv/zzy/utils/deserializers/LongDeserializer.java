package priv.zzy.utils.deserializers;

import priv.zzy.common.Deserializer;

public class LongDeserializer implements Deserializer<Long> {

    @Override
    public Long deserialize(String data) {
        return Long.valueOf(data);
    }
}
