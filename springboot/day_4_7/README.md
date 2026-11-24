\# Production-Ready Spring Boot Application with Docker



\## 1. Project Overview



This project containerizes a Spring Boot Student Management REST API with PostgreSQL using Docker and Docker Compose.



The project demonstrates production-oriented containerization practices, including:



\- Multi-stage Docker builds

\- Docker Compose orchestration

\- PostgreSQL persistence using named volumes

\- Custom Docker networking

\- Environment-based configuration and Docker secrets

\- Non-root container execution

\- Read-only container filesystem

\- Dropped Linux capabilities

\- Health checks and resource limits

\- Application monitoring using Spring Boot Actuator

\- Database backup and restore

\- Vulnerability scanning using Docker Scout

\- Automated CI/CD using GitHub Actions



\## 2. Technology Stack



| Component | Technology |

|---|---|

| Backend | Spring Boot 4.1.2 |

| Language | Java 25 |

| Build tool | Maven |

| Database | PostgreSQL 17 |

| Containerization | Docker |

| Orchestration | Docker Compose |

| Monitoring | Spring Boot Actuator |

| Image scanning | Docker Scout |

| CI/CD | GitHub Actions |

| Container registry | GitHub Container Registry |



\## 3. Project Architecture



The application consists of two services:



1\. \*\*API:\*\* Spring Boot REST API running on port 8080.

2\. \*\*Database:\*\* PostgreSQL running on port 5432 inside the Docker network.



The API connects to PostgreSQL using the Compose service name `db`.



The database uses a named Docker volume to preserve data independently of the database container lifecycle.



\## 4. Project Structure



```text

day\_4\_7/

│

├── src/

│   ├── main/

│   │   ├── java/

│   │   └── resources/

│   │

│   └── test/

│       └── resources/

│           └── application.properties

│

├── secrets/

│   └── db\_password.txt

│

├── backups/

│

├── Dockerfile

├── .dockerignore

├── .gitignore

├── compose.yaml

├── pom.xml

└── README.md

```



The GitHub Actions workflow is located at the repository root:



```text

Assignments/

└── .github/

&#x20;   └── workflows/

&#x20;       └── docker-ci-cd.yml

```



\## 5. Prerequisites



Install:



\- Docker Desktop

\- Git

\- GitHub account



Verify Docker:



```powershell

docker --version

docker compose version

```



\## 6. Configuration and Secrets



Create the secrets directory:



```powershell

New-Item -ItemType Directory -Force secrets

```



Create the database password file:



```powershell

notepad .\\secrets\\db\_password.txt

```



Enter a strong password and save the file.



The password is supplied to PostgreSQL using `POSTGRES\_PASSWORD\_FILE`.



The API reads the same Docker secret through Spring Boot configuration tree:



```properties

spring.datasource.password=${db\_password:}

```



Compose mounts the secret at:



```text

/run/secrets/db\_password

```



The secrets directory and `.env` files must not be committed to Git.



\## 7. Build and Run the Application



From the project directory:



```powershell

docker compose config

```



Build and start services:



```powershell

docker compose up -d --build

```



Check service status:



```powershell

docker compose ps

```



View application logs:



```powershell

docker compose logs -f api

```



View database logs:



```powershell

docker compose logs -f db

```



Stop services:



```powershell

docker compose down

```



To stop and remove containers while preserving database data:



```powershell

docker compose down

```



Do not use `docker compose down -v` unless you intentionally want to delete the named volume.



\## 8. REST API Endpoints



Base URL:



```text

http://localhost:8080

```



| Method | Endpoint | Purpose |

|---|---|---|

| POST | `/api/students` | Create student |

| GET | `/api/students` | Retrieve all students |

| GET | `/api/students/{id}` | Retrieve student by ID |

| PUT | `/api/students/{id}` | Update student |

| DELETE | `/api/students/{id}` | Delete student |

| GET | `/api/students/search?name=...` | Search by name |

| GET | `/api/students/search/status?status=active` | Search by status |



Valid student statuses are `active` and `inactive`.



Date format: `dd-MM-yyyy`.



Example request:



```json

{

&#x20; "name": "Docker Test Student",

&#x20; "email": "docker.test@example.com",

&#x20; "dateOfBirth": "15-05-2000",

&#x20; "status": "active"

}

```



\## 9. Health Checks and Monitoring



Spring Boot Actuator endpoints:



```text

http://localhost:8080/actuator/health

http://localhost:8080/actuator/metrics

```



Check health using PowerShell:



```powershell

Invoke-RestMethod http://localhost:8080/actuator/health

```



Retrieve available metrics:



```powershell

Invoke-RestMethod http://localhost:8080/actuator/metrics

```



Docker Compose also defines health checks for the API and database.



\## 10. Container Security



The API container implements the following security controls:



\- Runs using a non-root user.

\- Uses a read-only root filesystem.

\- Uses a temporary writable `/tmp` filesystem.

\- Drops all Linux capabilities.

\- Enables `no-new-privileges`.

\- Receives database credentials through Docker secrets.

\- Uses a private Compose network for API/database communication.



Useful verification commands:



```powershell

docker compose exec api id

```



```powershell

docker inspect student-api --format 'ReadonlyRootfs={{.HostConfig.ReadonlyRootfs}}'

```



```powershell

docker inspect student-api --format '{{json .HostConfig.CapDrop}}'

```



```powershell

docker inspect student-api --format '{{json .HostConfig.SecurityOpt}}'

```



\## 11. Resource Management



The API service has configured resource limits:



\- Memory: 768 MB

\- CPU: 1 CPU



Inspect current resource usage:



```powershell

docker stats --no-stream

```



Inspect configured limits:



```powershell

docker inspect student-api --format 'Memory={{.HostConfig.Memory}} NanoCPUs={{.HostConfig.NanoCpus}}'

```



Inspect logging driver:



```powershell

docker inspect student-api --format '{{.HostConfig.LogConfig.Type}}'

```



\## 12. Database Persistence



PostgreSQL uses the named volume:



```text

postgres\_data

```



Inspect volumes:



```powershell

docker volume ls

```



The database data survives API restarts and PostgreSQL container recreation as long as the named volume is retained.



\## 13. Database Backup and Restore



Create the backup directory:



```powershell

New-Item -ItemType Directory -Force backups

```



Create a PostgreSQL custom-format backup:



```powershell

cmd /c "docker compose exec -T db pg\_dump -U appuser -d student\_assignment\_db -Fc > backups\\student\_backup.dump"

```



Check the backup file:



```powershell

Get-Item .\\backups\\student\_backup.dump

```



Verify the custom-format signature:



```powershell

$bytes = \[System.IO.File]::ReadAllBytes("$PWD\\backups\\student\_backup.dump")

\[System.Text.Encoding]::ASCII.GetString($bytes\[0..4])

```



Expected signature:



```text

PGDMP

```



Create a temporary restore database:



```powershell

docker compose exec db createdb -U appuser restore\_test

```



Copy the backup into the database container:



```powershell

docker cp .\\backups\\student\_backup.dump student-db:/tmp/student\_backup.dump

```



Restore:



```powershell

docker compose exec db pg\_restore -U appuser -d restore\_test /tmp/student\_backup.dump

```



Verify restored records:



```powershell

docker compose exec db psql -U appuser -d restore\_test -c "SELECT id, name, email FROM students;"

```



The restore test successfully recovered the `Persistence Test` student record.



\## 14. Vulnerability Scanning



The Docker image was scanned using Docker Scout:



```powershell

docker scout cves student-api:v2

```



Recorded scan findings:



| Severity | Count |

|---|---:|

| Critical | 0 |

| High | 0 |

| Medium | 1 |

| Low | 0 |

| Unspecified | 1 |



The scan reported:



\- `stdlib 1.27.3` — CVE-2026-97054

\- `github.com/gorilla/websocket 1.5.3` — GHSA-w67g-5rqw-f597



These findings were documented and not remediated in this capstone.



\## 15. CI/CD Pipeline



GitHub Actions automates:



1\. Source code checkout.

2\. Java 25 setup.

3\. Maven test execution.

4\. Docker Buildx setup.

5\. Image metadata generation.

6\. Authentication to GitHub Container Registry.

7\. Docker image build and publication.



The workflow file is:



```text

.github/workflows/docker-ci-cd.yml

```



The workflow is stored at the root of the `Assignments` repository.



The application build context is:



```text

springboot/day\_4\_7

```



The workflow publishes images to GitHub Container Registry (GHCR) on qualifying pushes.



Pull requests run the test and image build without publishing.



\## 16. Testing Performed



The following tests were performed:



\- Maven unit tests using H2.

\- Application startup verification.

\- Student CRUD API testing.

\- Input validation testing.

\- Actuator health verification.

\- Actuator metrics verification.

\- PostgreSQL connectivity verification.

\- API restart persistence testing.

\- PostgreSQL container recreation persistence testing.

\- PostgreSQL backup and restore verification.

\- Docker security configuration verification.

\- Docker resource and logging inspection.

\- Docker Scout vulnerability scanning.

\- GitHub Actions CI/CD pipeline execution.



\## 17. Troubleshooting Commands



Check container status:



```powershell

docker compose ps

```



View application logs:



```powershell

docker compose logs api

```



View database logs:



```powershell

docker compose logs db

```



Inspect a container:



```powershell

docker inspect student-api

```



Open a shell in the API container:



```powershell

docker compose exec api sh

```



Check database readiness:



```powershell

docker compose exec db pg\_isready -U appuser -d student\_assignment\_db

```



Check resource usage:



```powershell

docker stats

```



\## 18. Conclusion



This project demonstrates the containerization and deployment of a Spring Boot REST API with PostgreSQL using Docker.



It covers application packaging, orchestration, networking, persistence, secrets management, container hardening, health checks, observability, resource management, database recovery, vulnerability assessment, and automated CI/CD.



The project provides practical experience with production-oriented Docker workflows and container operations.

