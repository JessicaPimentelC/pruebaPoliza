# API Gestión de Pólizas

API REST desarrollada con **Spring Boot** para gestionar pólizas y riesgos.

## Tecnologías

- Java
- Spring Boot
- Spring Data JPA
- H2 Database

## Ejecutar el proyecto

```bash
mvn spring-boot:run

La aplicación se ejecutará en:

http://localhost:8080
Endpoints
Listar pólizas
GET http://localhost:8080/polizas
Filtrar pólizas
GET http://localhost:8080/polizas?tipo=individual&estado=activa
Riesgos de una póliza
GET http://localhost:8080/polizas/1/riesgos
Renovar póliza
POST http://localhost:8080/polizas/{id}/renovar
Cancelar póliza
POST http://localhost:8080/polizas/{id}/cancelar
Mock sistema CORE
POST http://localhost:8080/core-mock/evento

Header requerido:

x-api-key: 123456
