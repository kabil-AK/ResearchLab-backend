# Research Lab Full-Stack Backend

## Stack
- Java 17
- Spring Boot
- Spring Security
- JWT
- Spring Data JPA
- MySQL

## Database
Create:
```sql
CREATE DATABASE research_lab_db;
```

Set DB values in `application.properties` or environment variables.

## Run
```bash
mvn spring-boot:run
```

Backend:
`http://localhost:8080`

## Default admin
Email: `admin@researchlab.com`
Password: `Admin@12345`

Change these before deployment using:
- `ADMIN_EMAIL`
- `ADMIN_PASSWORD`
- `JWT_SECRET`
- `DB_URL`
- `DB_USERNAME`
- `DB_PASSWORD`
- `FRONTEND_URL`

## API
Public GET:
- `/api/public/site-info`
- `/api/public/team-members`
- `/api/public/publications`
- `/api/public/achievements`
- `/api/public/gallery`
- `/api/public/funding`
- `/api/public/collaborations`

Admin:
- `POST /api/auth/login`
- `/api/admin/site-info`
- `/api/admin/team-members`
- `/api/admin/publications`
- `/api/admin/achievements`
- `/api/admin/gallery`
- `/api/admin/funding`
- `/api/admin/collaborations`

All admin endpoints require:
`Authorization: Bearer <JWT>`
