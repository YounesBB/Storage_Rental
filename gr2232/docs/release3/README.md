# Release 3

The major implementations of this release are as follows: 

- REST-API
    - Created a REST-API using Spring-boot. 
    - Accepts the following paths:
        - GET http://localhost:8080/unitlist
            - Returns all units from the Server
        - POST http://localhost:8080/unitlist
            - Accepts a JSON string of a Unit. 
            - Returns statuscode:200 and "true" in responsebody if sucessfull. 
        - DELETE http://localhost:8080/unitlist/{location}
            - Deletes the Unit from the server. 
            - Returns statuscode:200 and "true" in responsebody if sucessfull. 
        - PUT http://localhost:8080/unitlist/removetenant/{location}
            - Removes the tenant from the location.
            - Returns statuscode:200 and "true" in responsebody if sucessfull. 
        - PUT http://localhost:8080/unitlist/addtenant/{location}/{tenant}
            - Adds a tenant to the given location
            - Returns statuscode:200 and "true" in responsebody if sucessfull.

    - See Swagger for complete documentation.
