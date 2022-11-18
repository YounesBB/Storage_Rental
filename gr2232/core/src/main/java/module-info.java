module gr2232.core {
  requires transitive com.fasterxml.jackson.databind;
  requires transitive com.google.gson;

  opens gr2232.json to com.google.gson;
  opens gr2232.core to com.google.gson;
  
  exports gr2232.core;
  exports gr2232.json; 

}


