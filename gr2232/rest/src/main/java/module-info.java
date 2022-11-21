module gr2232.rest {

  requires transitive gr2232.core;
  requires spring.core;

  requires spring.web;
  requires spring.beans;
  requires spring.boot;
  requires spring.context;
  requires spring.boot.autoconfigure;
  requires io.swagger.v3.oas.annotations;


  opens gr2232.rest to spring.beans, spring.context, spring.web, spring.core;

    //opens gr2232.rest to gr2232.core, gr2232.json, gr2232.fxui, spring.boot.autoconfigure,spring.boot, spring.beans, spring.web, spring.test;
}
