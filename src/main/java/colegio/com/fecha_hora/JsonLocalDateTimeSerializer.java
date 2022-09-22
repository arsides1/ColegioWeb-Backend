package colegio.com.fecha_hora;

import java.io.IOException;
import java.time.LocalDateTime;

import colegio.com.convertir.ObjectUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JsonLocalDateTimeSerializer  extends StdSerializer<LocalDateTime>{

	private static final long serialVersionUID = 1L;

	public JsonLocalDateTimeSerializer() {
        this(null);
    }
 
    public JsonLocalDateTimeSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize (LocalDateTime value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {
    	if (!ObjectUtils.isNull(value)) {
    		gen.writeString( value.toString() );
		}
    }
}
