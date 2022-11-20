module gr2232.rest {
    requires gr2232.core;
    requires io.swagger.v3.core;
    requires io.swagger.v3.oas.annotations;
    requires spring.web;
    requires spring.beans;
    requires spring.boot;    
    requires spring.boot.autoconfigure;
    requires spring.context;
    
    //opens gr2232.rest to spring.boot.autoconfigure,spring.boot, spring.beans, spring.web, spring.test;
}
