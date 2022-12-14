package colegio.com.fecha_hora;

import java.io.IOException;
import java.time.LocalDate;

import colegio.com.convertir.ObjectUtils;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

public class JsonLocalDateSerializer extends StdSerializer<LocalDate> {


	private static final long serialVersionUID = 1L;

	public JsonLocalDateSerializer() {
        this(null);
    }
 
    public JsonLocalDateSerializer(Class t) {
        super(t);
    }

    @Override
    public void serialize (LocalDate value, JsonGenerator gen, SerializerProvider arg2) throws IOException, JsonProcessingException {
    	if (!ObjectUtils.isNull(value)) {
    		gen.writeString(value.toString());
		}
    }
}
