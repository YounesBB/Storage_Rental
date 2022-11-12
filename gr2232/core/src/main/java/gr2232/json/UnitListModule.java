package gr2232.json;

import com.fasterxml.jackson.databind.module.SimpleModule;
import gr2232.core.Unit;
import gr2232.core.UnitList;

public class UnitListModule extends SimpleModule {

  private static final long serialVersionUID = 1L;
  private static final String NAME = "UnitListModule";

  /**
   * Registers serializers and deserializers and connects them to the correct class.
   */
  public UnitListModule() {
    super(NAME);
    addSerializer(Unit.class, new UnitSerializer());
    addDeserializer(Unit.class, new UnitDeserializer());

    addSerializer(UnitList.class, new UnitListSerializer());
    addDeserializer(UnitList.class, new UnitListDeserializer());
  }
  
}
