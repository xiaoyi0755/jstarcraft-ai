package com.jstarcraft.ai.data.converter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;

import com.jstarcraft.ai.data.DataModule;
import com.jstarcraft.ai.data.attribute.QualityAttribute;
import com.jstarcraft.ai.data.attribute.QuantityAttribute;
import com.jstarcraft.ai.data.exception.DataException;
import com.jstarcraft.core.utility.StringUtility;

/**
 * 流式转换器
 * 
 * @author Birdy
 *
 */
public abstract class StreamConverter extends AbstractConverter<InputStream> {

    protected StreamConverter(Collection<QualityAttribute> qualityAttributes, Collection<QuantityAttribute> quantityAttributes) {
        super(qualityAttributes, quantityAttributes);
    }

    protected abstract int parseData(DataModule module, BufferedReader buffer) throws IOException;

    @Override
    public int convert(DataModule module, InputStream stream) {
        try {
            try (InputStreamReader iterator = new InputStreamReader(stream, StringUtility.CHARSET); BufferedReader buffer = new BufferedReader(iterator)) {
                return parseData(module, buffer);
            }
        } catch (Exception exception) {
            // TODO 处理日志.
            throw new DataException(exception);
        }
    }

}
