package gr2232.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import gr2232.core.Unit;
import gr2232.core.UnitList;
import java.io.IOException;


public class UnitListSerializer extends JsonSerializer<UnitList> {

  /**
   * This method accepts a visit log and writes json to file.
   *
   * @param log                to be written to file
   * @param jgen               generates json
   * @param serializerProvider provides serializing functionality
   * @throws IOException if writing file goes wrong
   */
  @Override
  public void serialize(UnitList list, JsonGenerator jgen, SerializerProvider serializerProvider)
      throws IOException {
    jgen.writeStartObject();
    //jgen.writeArrayFieldStart("log");
    jgen.writeStartArray();
    for (Unit v : list.getUnitListEntries()) {
      jgen.writeObject(v);
    }
    jgen.writeEndArray();
    jgen.writeEndObject();
  }

}