package gr2232.json;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import gr2232.core.Unit;

public class UnitSerializer extends JsonSerializer<Unit> {

  /**
   * This method accepts a unit and writes json to file.
   *
   * @param unit               to be written to file
   * @param jgen               generates json
   * @param serializerProvider provides serializing functionality
   * @throws IOException if writing file goes wrong
   */
  @Override
  public void serialize(Unit unit, JsonGenerator jgen, SerializerProvider serializerProvider)
      throws IOException {
    jgen.writeStartObject();
    jgen.writeStringField("isRented", String.valueOf(unit.getIsRented()));
    jgen.writeStringField("customerName", unit.getCustomerName());
    jgen.writeStringField("location",String.valueOf(unit.getLocation()));
    jgen.writeStringField("size", String.valueOf(unit.getSize()));
    jgen.writeEndObject();
  }
  
}
