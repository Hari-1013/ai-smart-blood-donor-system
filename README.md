# AI-Powered Smart Blood Donor System

A web-based blood donor discovery and blood-request management system built with Spring Boot, Thymeleaf, MySQL/H2 and an AI-assisted donor matching engine.

## Major modules
1. Donor registration and profile management
2. Blood request creation and tracking
3. AI-assisted donor matching and ranking
4. Hospital/Blood Bank staff dashboard
5. Donation history and donor availability
6. Blood stock monitoring
7. Notifications and request status workflow
8. Admin user and system management

## Technology stack
- Java 17
- Spring Boot 3.4.4
- Spring MVC + Thymeleaf
- Spring Data JPA
- MySQL 8 / H2 for local demo
- HTML5, CSS3, JavaScript, Bootstrap CDN

## Run locally
1. Install JDK 17 and Maven 3.9+.
2. Run `mvn spring-boot:run`.
3. Open `http://localhost:8080`.
4. For a quick demo, the application uses H2 by default.
5. To use MySQL, edit `application.properties` and enable the MySQL settings.

## Demo accounts
- Admin: admin@bloodcare.local / admin123
- Staff: staff@bloodcare.local / staff123
- Donor: donor@bloodcare.local / donor123

## GitHub upload
```bash
git init
git add .
git commit -m "Initial AI Powered Smart Blood Donor System"
git branch -M main
git remote add origin https://github.com/<YOUR-USERNAME>/ai-smart-blood-donor.git
git push -u origin main
```

## Important note
The matching engine is an explainable AI-style scoring module for the academic prototype. It ranks eligible donors using blood-group compatibility, distance, availability, recent donation interval, and priority. A production system must add medical validation, verified hospital workflows, secure identity handling and clinical approval.
