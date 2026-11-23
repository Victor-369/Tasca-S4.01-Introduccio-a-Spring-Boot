# Package `cat.itacademy.s04.t01.userapi`

Root package of the **userapi** Spring Boot application, a simple REST API.

## Structure

| Package / class | Purpose |
|---|---|
| `UserapiApplication` | Entry point. Annotated with `@SpringBootApplication`, it starts the application and enables component scanning of this package and its sub-packages. |
| `controllers` | REST controllers that expose the API endpoints. |
| `records` | Immutable data carriers (Java records) used as response bodies. Jackson serialises them to JSON automatically. |

## Endpoints

| Method | Path | Controller | Response |
|---|---|---|---|
| `GET` | `/health` | `HealthController` | `{"status": "OK"}` |

## Notes

- Any new component (controller, service, repository, etc.) must live in this package or one of its sub-packages, otherwise Spring's component scanning will not detect it.
- Tests mirror this package structure under `src/test/java`.
