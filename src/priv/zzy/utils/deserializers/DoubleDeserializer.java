package priv.zzy.utils.deserializers;

import priv.zzy.common.Deserializer;

public class DoubleDeserializer implements Deserializer<Double> {

    @Override
    public Double deserialize(String data) {
        return Double.valueOf(data);
    }
}
