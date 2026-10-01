# Full-Stack Supplier & Logistics Operations Dashboard

A compact supplier/order/shipment operations app: Spring Boot REST API + React dashboard, with MongoDB and Redis configuration examples. A local in-memory data mode is available by default so the API starts without external services. The repository is a portfolio baseline; it does not substantiate business impact figures without a measured deployment.

## Prerequisites
- Java 17+, Maven 3.9+
- Node.js 20+ and npm

## Run API
```bash
cd backend
mvn spring-boot:run
```
API: http://localhost:8080/api/operations/summary and http://localhost:8080/api/operations/orders

## Run UI
```bash
cd frontend
npm install
npm run dev
```
Open the Vite URL shown in terminal. UI expects API at `http://localhost:8080`; configure `VITE_API_URL` to override.

## Optional infrastructure
`docker-compose.yml` shows MongoDB and Redis services. The demo backend currently uses deterministic in-memory sample data so it remains runnable without them. JUnit tests cover summary/order endpoints.
