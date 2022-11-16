package gr2232.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import gr2232.core.Unit;


public class UnitDeserializer extends JsonDeserializer<Unit> {

  /**
   * This method accepts json and returns a unit.
   *
   * @param jp   is a json-tree
   * @param ctxt is the deserialization context
   * @return a unit
   * @throws IOException if reading value goes wrong.
   */
  @Override
  public Unit deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    return deserialize(jp.getCodec().readTree(jp));
  }

  /**
   * Deserializes a JsonNode into a Unit.
   *
   * @param node JsonNode node to be deserialized
   * @return Unit
   */
  public Unit deserialize(JsonNode node) {
    Boolean isRented = node.get("isRented").asBoolean();
    String customerName = node.get("customerName").asText();
    Integer location = node.get("location").asInt();
    Character size =  node.get("size").asText().charAt(0);
    return new Unit(size, location, isRented, customerName);
  }
}
