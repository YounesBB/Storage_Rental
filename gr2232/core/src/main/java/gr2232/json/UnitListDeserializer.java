package gr2232.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import java.io.IOException;
import gr2232.core.UnitList;

public class UnitListDeserializer extends JsonDeserializer<UnitList> {

  private final UnitDeserializer unitDeserializer = new UnitDeserializer();

  /**
   * This method accepts json and returns a UnitList.
   *
   * @param jp   is a json-tree
   * @param ctxt is the deserialization context
   * @return a Unit list.
   * @throws IOException if reading goes wrong
   */
  @Override
  public UnitList deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
    JsonNode node = jp.getCodec().readTree(jp);
    UnitList list = new UnitList();
    node.forEach(n -> list.addUnit(unitDeserializer.deserialize(n))); //see if we get correct values
    return list;
  }
}