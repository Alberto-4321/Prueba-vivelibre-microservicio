# Instrucciones

Dado este servicio de autenticación:

Servicio de autenticación que escucha en el puerto 8080 y consta del siguiente endpoint:  
cURL:

    curl --location --request POST 'http://localhost:8080/token' \  
    --header 'Content-Type: application/json' \  
    --data-raw '{  
    "username":"auth-vivelibre",  
    "password":"password"  
    }'  


**Docker**: `docker pull skeet15/auth-vivelibre`.

Realizar un servicio Spring Boot que llame a este endpoint y obtenga el token de la  
respuesta. Este endpoint devolverá el token junto con la fecha en la que se pidió:

**GET** `http://localhost:8081/get-token`  
Cuerpo de la respuesta:

    {  
    "auth-vivelibre-token": "string",  
    "date": "February 21, 2018"  
    }
