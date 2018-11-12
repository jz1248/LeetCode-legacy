package priv.zzy.utils.deserializers;

import priv.zzy.common.Deserializer;

public class IntegerDeserializer implements Deserializer<Integer> {

    @Override
    public Integer deserialize(String data) {
        return Integer.valueOf(data);
    }
}
